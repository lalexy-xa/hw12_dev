package org.example.config;


import org.example.util.ConfigurationUtils;

import java.util.Properties;

public class DbConfig {
    private static final String CONFIG_FILE_PATH = "application.properties";

    private static final String DB_URL_CONFIG_KEY = "url";
    private static final String DB_USER_CONFIG_KEY = "user";
    private static final String DB_PASSWORD_CONFIG_KEY = "password";

    public Properties getDbProperties() {
        return ConfigurationUtils.getPropertiesFromFile(CONFIG_FILE_PATH);
    }
    public String getDbUrlConfigKey(){
        return  getDbProperties().getProperty(DB_URL_CONFIG_KEY);
    }

    public String getDbUserConfigKey(){
        return
                getDbProperties().getProperty(DB_USER_CONFIG_KEY);
    }

    public String getDbPasswordConfigKey(){
        return getDbProperties().getProperty(DB_PASSWORD_CONFIG_KEY);
    }
}
