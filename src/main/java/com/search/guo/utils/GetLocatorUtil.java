package com.search.guo.utils;

import org.openqa.selenium.By;

/**
 * @author guoqinglin
 * @create 2020-04-23-11:54
 */
public class GetLocatorUtil {
    ProUtil locator;

    public GetLocatorUtil(String locatorFile){
        this.locator = new ProUtil(locatorFile);
    }

     public static By getByLocatorKeyWord(String locatorKeyValue) {
        // 将配置对象中的定位类型存到 locatorType 变量，将定位表达式的值存入到 locatorValue 变量
        String type = locatorKeyValue.split(">")[0];// id
        String value = locatorKeyValue.split(">")[1];// kw
        System.out.println("type:"+type);
        System.out.println("value:"+value);
        // 根据 locatorType 的变量值内容判断，返回何种定位方式的 By 对象
        if (type.equalsIgnoreCase("id"))
            return By.id(value);
        else if (type.equalsIgnoreCase("xpath"))
            return By.xpath(value);
        else if ((type.toLowerCase().equalsIgnoreCase("classname")))
            return By.className(value);
        else if ((type.equalsIgnoreCase("linkText")))
            return By.linkText(value);
        else if (type.equalsIgnoreCase("PartialLinkText"))
            return By.partialLinkText(value);
        else if ((type.equalsIgnoreCase("cssSelector")))
            return By.cssSelector(value);
        else{
            throw new RuntimeException(" locator type not exist in this framework：" + type);
        }
    }
}
