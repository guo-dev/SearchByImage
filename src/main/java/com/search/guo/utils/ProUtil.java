package com.search.guo.utils;
import java.util.Properties;

/**
 * @author guoqinglin
 * @create 2020-04-24-10:22
 */
public class ProUtil {

    private String file;
    private Properties prop;
    private Log logger = Log.getLogger(ProUtil.class);

    public ProUtil(String file) {
        this.file = file;
      }

       public String getKey(String key){
        if (prop.containsKey(key)) {
            return prop.getProperty(key);
        } else {
            logger.error("get key: " + key + " is not exist in " + file);
            throw new RuntimeException("get key: " + key + " is not exist in " + file);
        }
    }
}
