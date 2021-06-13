package com.ithillel.utils;

import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {


    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();


    //---------------Properties--------------------------

    public static final String BROWSER = prop.getProperty("browser");
    public static final String BASE_URL = prop.getProperty("base.url");
    public static final String BASE_BLOG_URL = prop.getProperty("base.blog.url");
    public static final String BASE_SERTIFICATE_URL = prop.getProperty("base.certificate.url");
    public static final int IMPLICIT_WAIT = Integer.parseInt(prop.getProperty("implicit.wait"));

    public static final String API_URL = prop.getProperty("api.url");
    public static final int API_PORT = Integer.parseInt(prop.getProperty("api.port"));
    public static final String API_USER = prop.getProperty("api.user");
    public static final String API_PASSWORD = prop.getProperty("api.password");

    //---------------Properties-end--------------------------


    private ConfigProvider() {
    }

    private static Properties initProperties() {
        Properties prop = new Properties();
        try {
            prop.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties");
        }
        return prop;
    }


}
