package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getApiUrl() {
        String env = System.getProperty("env");  
        System.out.println(" Environment : " + env);
        return getProperty(env + ".api.url");
    }
    
    public static String getAuthtoken() {
        String authtoken = System.getProperty("env");  
        return getProperty(authtoken + ".authtoken" );
    }
    
    public static String getDBdetails() {
        String DBdetails = System.getProperty("env");  
        return getProperty(DBdetails + ".jdbc.url" );
    }
    
    
    
}