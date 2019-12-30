package utils;


import java.io.IOException;
import java.util.Properties;

/**
 * @author lidehe
 * Oct 30,2019
 */
public class PropertyUtils {
    static Properties properties = new Properties();
    static private String tableName;
    static {
        try {
            properties.load(PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取线程数
     * @return
     */
    public static String getThreadNum() {
        return properties.getProperty("threadNum");
    }


}
