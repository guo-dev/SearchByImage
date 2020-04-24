package com.search.guo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author guoqinglin
 * @create 2020-04-22-22:25
 */
public class ProjectTest {
    public static void main(String[] args) throws Exception {

        File file = new File("D://zhuzhuang/SearchByImage/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/");
        //driver.findElement(By.id("kw")).sendKeys("selenium");
        //driver.findElement(By.id("su")).click();
        driver.findElement(By.className("soutu-btn")).click();
        driver.wait(5000);




          driver.quit();
    }

}
