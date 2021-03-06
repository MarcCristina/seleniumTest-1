package org.fasttrackit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();


    static  {
        String environment = System.getProperty("env","production");
        InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(environment + ".properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load properties." + e.getLocalizedMessage());
        }

    }

    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = properties.getProperty("gecko.driver.path");
    private static String siteUrl = properties.getProperty("site.url");

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }
}

