package com.qacart.todo.Utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String env = System.getProperty("env","PRODUCTION");
        switch (env){
            case "PRODUCTION":
                properties =
                        PropertiesUtils
                                .loadproperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties =
                        PropertiesUtils
                                .loadproperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("Env is not supported!");
        }

    }

    public static ConfigUtils getInstance(){
        if(configUtils==null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl(){
       String prop = properties.getProperty("baseUrl");
       if(prop != null) return prop;
       throw new RuntimeException("Couldn't find the base url in the property file");
    }
    public String getEmail(){
        String prop = properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Couldn't find the email in the property file");
    }
    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Couldn't find the password in the property file");
    }


}
