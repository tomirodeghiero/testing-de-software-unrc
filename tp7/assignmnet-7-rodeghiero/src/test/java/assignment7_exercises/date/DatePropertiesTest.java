package assignment7_exercises.date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

class DatePropertiesTest {

    @Property(tries = 250)
    void addDaysSiempreDevuelveFechaValida(
        @ForAll("fechasValidas") Date fecha,
        @ForAll("diasNoNegativos") int dias
    ) {
        Date receptor = new Date(1, 1, 1900);

        Date resultado = receptor.addDays(fecha, dias);

        assertNotNull(resultado);
        assertTrue(resultado.repOk());
    }

    @Provide
    Arbitrary<Date> fechasValidas() {
        return Arbitraries.integers().between(1900, 2400).flatMap(year ->
            Arbitraries.integers().between(1, 12).flatMap(month ->
                Arbitraries.integers().between(1, daysInMonth(month, year)).map(day ->
                    new Date(day, month, year)
                )
            )
        );
    }

    @Provide
    Arbitrary<Integer> diasNoNegativos() {
        return Arbitraries.integers().between(0, 5000);
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 2:
            return Date.leap(year) ? 29 : 28;
        default:
            throw new IllegalArgumentException("invalid month");
        }
    }
}
