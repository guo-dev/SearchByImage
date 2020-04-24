package com.search.guo.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

/**
 * @author guoqinglin
 * @create 2020-04-23-16:38
 */
public class MyWebDriver {

    public WebDriver driver;

    public MyWebDriver() throws Exception {
        InitDriver init = new InitDriver();
        this.driver = init.getDriver();
    }

    public WebElement findElement(By by) {
       try {
            return  driver.findElement(by);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<WebElement> findElements(By by) {
        try {
            List<WebElement> elements = driver.findElements(by);
            return elements;
        } catch (Exception e) {
            // TODO: handle exception
              throw new RuntimeException(e.getMessage());
        }
    }
    public String getPageSource() {
        return driver.getPageSource();
    }
}
