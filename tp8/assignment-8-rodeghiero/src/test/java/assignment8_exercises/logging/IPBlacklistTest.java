package assignment8_exercises.logging;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;


public class IPBlacklistTest {
	
    private IPBlacklist ipblacklist;
    private LoginService service;

    @Before
    public  void setUp() {
         ipblacklist = new IPBlacklist();
         service = createMock(LoginService.class);
         ipblacklist.setService(service);
    }
 
    //Write tests here
    @Test
    public void shouldBlacklistIpAfterThreeConsecutiveFailedAttempts() {
        String ip = "192.168.0.10";
        String user = "usuario";
        String password = "clave";
        String passwordHash = Utils.getPasswordHashMD5(password);

        expect(service.login(ip, user, passwordHash)).andReturn(false).times(3);
        replay(service);

        assertFalse(ipblacklist.login(ip, user, password));
        assertFalse(ipblacklist.login(ip, user, password));
        assertFalse(ipblacklist.login(ip, user, password));

        assertTrue(ipblacklist.blacklisted(ip));
        verify(service);
    }

    @Test
    public void shouldNotBlacklistIpWhenFailedAttemptsAreLessThanThree() {
        String ip = "192.168.0.20";
        String user = "usuario";
        String password = "clave";
        String passwordHash = Utils.getPasswordHashMD5(password);

        expect(service.login(ip, user, passwordHash)).andReturn(false).times(2);
        replay(service);

        assertFalse(ipblacklist.login(ip, user, password));
        assertFalse(ipblacklist.login(ip, user, password));

        assertFalse(ipblacklist.blacklisted(ip));
        verify(service);
    }
    
}
