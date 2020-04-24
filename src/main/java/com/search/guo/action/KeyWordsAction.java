package com.search.guo.action;

import com.search.guo.driver.MyWebDriver;
import com.search.guo.keyworddriver.KeywordsTests;
import com.search.guo.utils.GetLocatorUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author guoqinglin
 * @create 2020-04-23-10:28
 */
    public class KeyWordsAction {
    public  WebDriver driver;
    public KeyWordsAction(WebDriver driver) throws InterruptedException {
        this.driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void open(String locator, String browser_name) throws InterruptedException {
        //global driver
        if(browser_name.equalsIgnoreCase("chrome")){
            File file = new File("D://zhuzhuang/SearchByImage/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            WebDriver driver = new ChromeDriver();
        }
        else if(browser_name.equalsIgnoreCase("ie")){
            //TODO: 兼容ie
        }
        else if(browser_name.equalsIgnoreCase("firefox")){
            //TODO:兼容火狐
        }
        else{
            System.out.println("浏览器不存在");
        }
    }

    public  void visit(String locator,String url){
        try {
            //driver.get(url);
        } catch (Exception e) {
        //    KeywordsTest.testResult = false;
            e.printStackTrace();
        }
    }

    /* 此方法名称对应 excel 文件中“关键字”列中的 click 关键字，     *
     */
    public  void click(String locator,String string) {
        try {
           driver.findElement(GetLocatorUtil.getByLocatorKeyWord(locator)).click();
        } catch (Exception e) {
         //   KeywordsTest.testResult = false;
            e.printStackTrace();
        }
    }
    public  void input(String locator,String inputValue) {
        //   WebDriver driver = new ChromeDriver();

        try {
            driver.findElement(GetLocatorUtil.getByLocatorKeyWord(locator))
                    .sendKeys(inputValue);
        } catch (Exception e) {
            //          KeywordsTests.testResult = false;
            e.printStackTrace();
        }
    }

    public  void  assert_word(String string,String assertString)  {
        try{
            System.out.println(driver.getPageSource());
            Assert.assertTrue(driver.getPageSource().contains(assertString));
        } catch (AssertionError e) {
            KeywordsTests.testResult = false;
            System.out.println("断言失败");
        }
    }
    public  void sleep(){
        try {
            driver.wait(5000);
        } catch (Exception e) {
            //KeywordsTest.testResult = false;
            e.printStackTrace();
        }
    }
}
