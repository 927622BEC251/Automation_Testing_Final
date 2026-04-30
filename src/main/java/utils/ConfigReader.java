package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties getProperties() {
        try {
            prop = new Properties();

            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            prop.load(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}