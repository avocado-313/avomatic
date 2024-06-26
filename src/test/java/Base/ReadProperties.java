package Base;

import Utilities.PropertiesLoader;

import java.util.Random;


public class ReadProperties {
    public static final String URL = getPropertyFromEnv("URL");
    public static final String username = getPropertyFromEnv("username");
    public static final String password = getPropertyFromEnv("password");
    public static final String Workspace = getPropertyFromEnv("workspace");
    public static final String username2 = getPropertyFromEnv("username2");
    public static final String password2 = getPropertyFromEnv("password2");
    public static final String Workspace2 = getPropertyFromEnv("workspace2");
    public static final String CONTACT = getPropertyFromEnv("contact");


    private static String getPropertyFromEnv(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readEnvFile(propertyName));
    }



}
