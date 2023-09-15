package com.templatecucumber.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final static String CONFIG_FILE = "/environment.properties";
    private final static Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum Browsers {
        CHROME,
        FIREFOX
    }
    public final static boolean BROWSER_CLOSE = true;
    public final static boolean BROWSER_HEADLESS = false;
    public final static Browsers browser = Browsers.CHROME;
    public final static String URI_TEST = properties.getProperty("uri.base");
}
