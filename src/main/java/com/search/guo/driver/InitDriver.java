package com.search.guo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author guoqinglin
 * @create 2020-04-23-17:56
 */

public class InitDriver {

    public WebDriver getDriver() throws Exception {
        return initChromeDriver();
    }

    public WebDriver initChromeDriver() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

}
