package calsuite.auth;

import lombok.Getter;
import calsuite.models.general.Configuration;

public class AuthManager {

    @Getter
    private static String token;

    public static void initializeToken() throws Exception {
        token = fetchToken();
    }

    private static String fetchToken() throws Exception {
        if (Configuration.getEnvironmentValue().equals("CLOUD")) {
            return TokenProvider.getBearerToken();
        } else if (Configuration.getEnvironmentValue().equals("LOCAL")) {
            //add cookie logic if needed
            return "Cookie";
        } else {
            throw new Exception("invalid env");
        }
    }
}
