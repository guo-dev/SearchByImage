package com.search.guo.testcases;

import com.search.guo.keyworddriver.CrazyPath;
import com.search.guo.utils.ProUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author guoqinglin
 * @create 2020-04-24-14:48
 */
public class TestBase {
    public static WebDriver driver;
    static Logger logger = Logger.getLogger(TestBase.class);

    //@Parameters(value = "browserType")
    @BeforeSuite
    public void BaseTest() {
        ProUtil proUtil = new ProUtil(CrazyPath.globalPath);
        String browserType = ProUtil.getKey("browserType");
        logger.info("测试的浏览器类型是：" + browserType);
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            // options.addArguments("--kiosk");
            driver = new ChromeDriver(options);

        } else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else {
            logger.error("很抱歉，找不到您输入的浏览器类型！！！浏览器：【" + browserType + "】");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // try {
        // /*
        // * Thread.sleep(1000); // 获取浏览器高度和宽度 System.out.println("高度是：" +
        // * window.getSize().height + "，宽度是：" + window.getSize().width);
        // * Thread.sleep(1000); // 根据坐标，窗口显示在指定位置 window.setPosition(new Point(300,
        // * 300)); Thread.sleep(1000); // 设置窗口大小 window.setSize(new Dimension(500,
        // 500));
        // * Thread.sleep(1000);
        // */
        // } catch (Exception e) {
        // e.printStackTrace();
        // } finally {
        //
        // }
    }

    @AfterSuite
    public void quit() {
        //logger.info("测试结束，等待5秒后关闭浏览器！");
        //sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) throws Exception{
        TestBase t = new TestBase();
        t.BaseTest();
    }
}
