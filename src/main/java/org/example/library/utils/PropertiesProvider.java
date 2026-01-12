package org.example.library.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider {
    private static Properties properties;

    static{
        properties = new Properties();
        try{
            InputStream fileiInputStream = PropertiesProvider.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(fileiInputStream);
            fileiInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
