package com.automation.framework.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();
    static {
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                prop.load(is);
            } else {
                try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
                    prop.load(fis);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
        }
    }
    public static String get(String key) {
        return prop.getProperty(key);
    }
    public static int getInt(String key, int defaultVal) {
        try {
            return Integer.parseInt(prop.getProperty(key));
        } catch (Exception e) {
            return defaultVal;
        }
    }
}
