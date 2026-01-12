package calsuite.models.general;

import calsuite.utils.PropertiesReader;

public class Configuration {

    public static String getBaseUrl(){
        return PropertiesReader.getProperty("baseUrl");
    }

    public static String getClientSecret(){
        return PropertiesReader.getProperty("clientSecret");
    }

    public static String getClientId(){
        return PropertiesReader.getProperty("clientId");
    }

    public static boolean getLoggingEnabled(){
        return Boolean.parseBoolean(PropertiesReader.getProperty("loggingEnabled"));
    }

    public static String getEnvironmentValue(){
        return PropertiesReader.getProperty("environment");
    }
}
