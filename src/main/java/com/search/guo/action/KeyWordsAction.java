package com.search.guo.action;

import com.search.guo.keyworddriver.KeywordsTests;
import com.search.guo.utils.GetLocatorUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author guoqinglin
 * @create 2020-04-23-10:28
 */
    public class KeyWordsAction{
    public  WebDriver driver;
    //KeywordsTests KeywordsTests;
    public KeyWordsAction(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


//    public void open(String locator, String browser_name) throws InterruptedException {
//        if(browser_name.equalsIgnoreCase("chrome")){
//            File file = new File("D://zhuzhuang/SearchByImage/chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
//        }
//    }

    public  void visit(String locator,String url){
        try {
            driver.get(url);
        } catch (Exception e) {
            KeywordsTests.testResult = false;
            e.printStackTrace();
        }
    }

    /* 此方法名称对应 excel 文件中“关键字”列中的 click 关键字，     *
     */
    public  void click(String locator,String string) {
        try {
           driver.findElement(GetLocatorUtil.getByLocatorKeyWord(locator)).click();
        } catch (Exception e) {
            KeywordsTests.testResult = false;
            e.printStackTrace();
        }
    }
    public  void input(String locator,String inputValue) {
        try {
            driver.findElement(GetLocatorUtil.getByLocatorKeyWord(locator))
                    .sendKeys(inputValue);
        } catch (Exception e) {
            KeywordsTests.testResult = false;
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
    public  void sleep(String string,String ms){
        try {
            //driver.wait(Integer.valueOf(time));
            Thread.sleep(Integer.valueOf(ms));
        } catch (Exception e) {
            KeywordsTests.testResult = false;
            e.printStackTrace();
        }
    }
}
