package assignment6_exercises.fuzzing;


import java.net.URI;
import java.net.URISyntaxException;

public class HttpUtils {
	
	
	public static boolean httpProgram(String url) throws URISyntaxException {
        String[] supportedSchemes = {"http", "https"};

        URI result = new URI(url);
        String scheme = result.getScheme();
        String host = result.getHost();

        // Check if the scheme is supported
        boolean schemeSupported = false;
        for (String supportedScheme : supportedSchemes) {
            if (supportedScheme.equals(scheme)) {
                schemeSupported = true;
                break;
            }
        }

        if (!schemeSupported) {
            throw new IllegalArgumentException("Scheme must be one of " + String.join(", ", supportedSchemes));
        }

        // Check if the host is non-empty
        if (host == null || host.isEmpty()) {
            throw new IllegalArgumentException("Host must be non-empty");
        }

        // Do something with the URL
        return true;
    }
	
	
	public static boolean  isValidUrl(String url) {
		try {
			return httpProgram(url);
		
		}catch(Exception e) {
			return false;
		}
	}        		

}
