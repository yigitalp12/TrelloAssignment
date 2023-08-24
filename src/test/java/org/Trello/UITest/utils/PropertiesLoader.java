package org.Trello.UITest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream configFile = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTrelloURL() {
        return properties.getProperty("trello.url");
    }
    public static String getTrelloUsername() { return properties.getProperty("trello.username"); }
    public static String getTrelloPassword() { return properties.getProperty("trello.password"); }
}
