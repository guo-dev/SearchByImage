package com.search.guo.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * @author guoqinglin
 * @create 2020-04-23-12:44
 */
public class Log {
    private static Logger log;
    private static Thread thread;
    public static Log getLogger(Class<?> T) {
        thread=Thread.currentThread();
        log=Logger.getLogger(T);
        return new Log();
    }

    public void error(Object message) {
        log.error(thread.getName()+" "+message);
    }
    public void info(Object message) {
        log.info(thread.getName()+" "+message);
    }


}
