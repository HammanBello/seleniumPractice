package com.zenity.intranet.config;

public enum SystemPropertiesReader {

    INSTANCE;

    public static SystemPropertiesReader getInstance() {return  INSTANCE; }

    public String browser;
    public boolean headless;
    public Env env;

    SystemPropertiesReader() {
        browser = System.getProperty("browser", "chrome");
        headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        env = Env.valueOf(System.getProperty("env", "development").toUpperCase());
    }

}
