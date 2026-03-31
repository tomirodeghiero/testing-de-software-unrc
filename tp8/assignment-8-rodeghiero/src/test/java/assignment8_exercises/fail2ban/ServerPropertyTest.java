package assignment8_exercises.fail2ban;

import java.util.List;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Provide;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

class ServerPropertyTest {

    private static final long BAN_WINDOW_MS = 60000L;

    private static final class MutableTime implements ITime {
        private long now;

        MutableTime(long now) {
            this.now = now;
        }

        void setNow(long now) {
            this.now = now;
        }

        @Override
        public long getCurrentTime() {
            return now;
        }
    }

    private static final class UpdateScenario {
        private final List<IP> ips;
        private final long startTime;
        private final long elapsed;

        UpdateScenario(List<IP> ips, long startTime, long elapsed) {
            this.ips = ips;
            this.startTime = startTime;
            this.elapsed = elapsed;
        }
    }

    @Property(tries = 100)
    void updateRemovesExactlyExpiredBans(@ForAll("updateScenarios") UpdateScenario scenario) {
        Server server = new Server();
        MutableTime time = new MutableTime(scenario.startTime);
        server.setTime(time);

        long[] expires = new long[scenario.ips.size()];
        for (int i = 0; i < scenario.ips.size(); i++) {
            IP ip = scenario.ips.get(i);
            boolean added = server.addBan(ip);
            Assertions.assertTrue(added, "Cada IP del escenario debe poder agregarse como ban");
            expires[i] = time.getCurrentTime() + BAN_WINDOW_MS;
            time.setNow(time.getCurrentTime() + 1L);
        }

        long nowAtUpdate = scenario.startTime + scenario.ips.size() + scenario.elapsed;
        time.setNow(nowAtUpdate);
        server.update();

        for (int i = 0; i < scenario.ips.size(); i++) {
            IP ip = scenario.ips.get(i);
            boolean banStillActive = expires[i] > nowAtUpdate;
            boolean expectedConnection = !banStillActive;
            Assertions.assertEquals(expectedConnection, server.connect(ip));
        }

        Assertions.assertTrue(server.repOK());
    }

    @Provide
    Arbitrary<UpdateScenario> updateScenarios() {
        Arbitrary<IP> ipArbitrary = Combinators.combine(
                Arbitraries.integers().between(0, 255),
                Arbitraries.integers().between(0, 255),
                Arbitraries.integers().between(0, 255),
                Arbitraries.integers().between(0, 255))
            .as(IP::new);

        Arbitrary<List<IP>> ipsArbitrary = ipArbitrary
            .list()
            .uniqueElements()
            .ofMinSize(1)
            .ofMaxSize(6);

        Arbitrary<Long> startTimeArbitrary = Arbitraries.longs().between(1_000_000L, 10_000_000L);
        Arbitrary<Long> elapsedArbitrary = Arbitraries.longs().between(0L, 120_000L);

        return Combinators.combine(ipsArbitrary, startTimeArbitrary, elapsedArbitrary)
            .as(UpdateScenario::new);
    }
}
