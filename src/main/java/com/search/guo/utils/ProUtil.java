package com.search.guo.utils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author guoqinglin
 * @create 2020-04-24-10:22
 */
public class ProUtil {

    private static String file;
    private static Properties prop;
    private static Log logger = Log.getLogger(ProUtil.class);

    public ProUtil(String file) {
        this.file = file;
        this.prop = readProperties();
      }

    private Properties readProperties(){
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            properties.load(bf);
            inputStream.close(); // 关闭流
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e.getMessage());
        }
        return properties;
    }

       public static String getKey(String key){
        if (prop.containsKey(key)) {
            return prop.getProperty(key);
        } else {
            logger.error("get key: " + key + " is not exist in " + file);
            throw new RuntimeException("get key: " + key + " is not exist in " + file);
        }
    }
}
