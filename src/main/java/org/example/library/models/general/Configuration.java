package org.example.library.models.general;

import org.example.library.utils.PropertiesProvider;

public class Configuration {

    public static String getBaseUrl(){
        return PropertiesProvider.getProperty("baseUrl");
    }

    public static String getClientSecret(){
        return PropertiesProvider.getProperty("clientSecret");
    }

    public static String getClientId(){
        return PropertiesProvider.getProperty("clientId");
    }

    public static boolean getLoggingEnabled(){
        return Boolean.parseBoolean(PropertiesProvider.getProperty("loggingEnabled"));
    }

    public static String getEnvironmentValue(){
        return PropertiesProvider.getProperty("environment");
    }
}
