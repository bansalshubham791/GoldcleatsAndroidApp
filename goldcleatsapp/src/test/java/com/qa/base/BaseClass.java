package com.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Utils.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static AndroidDriver<MobileElement> driver;
    static DesiredCapabilities caps = new DesiredCapabilities();
    static ExtentHtmlReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public WebDriverWait wait;
    Actions action = null;

/*    @BeforeClass
    public void setup(){
        reporter = new ExtentHtmlReporter("C:\\Users\\Shubham Bansal\\IdeaProjects\\goldcleatsapp\\Reports\\Goldcleats_Reports.html");
        reporter.config().setAutoCreateRelativePathMedia(true);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }*/
    @BeforeSuite(alwaysRun = true)
    public void extentSetup(){
        reporter = new ExtentHtmlReporter("C:\\Users\\Shubham Bansal\\IdeaProjects\\goldcleatsapp\\Reports\\Goldcleats_Reports.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @BeforeMethod(alwaysRun = true)
    public static void setUp() {

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        /*caps.setCapability(MobileCapabilityType.VERSION, "9");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "POCO X2");
        caps.setCapability(MobileCapabilityType.UDID, "7df97bdb");*/

        caps.setCapability(MobileCapabilityType.VERSION, "10");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "southpaw");
        caps.setCapability(MobileCapabilityType.UDID, "320034505e4ac5ff");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability("appPackage", "com.goldCleats.GoldCleats");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.goldCleats.goldCleats.activity.SplashScreen");
        try {
            URL url = new URL("http://127.0.0.1:9090/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (Exception exp){
            System.out.println("Cause is : " + exp.getCause());
            System.out.println("Message is : " + exp.getMessage());
            exp.printStackTrace();
            }
    }
    public AndroidDriver getDriver() {
        return driver;
    }

    //Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    //Wait
    public void waitVisibility(By by){
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitElementsVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) by));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= Utility.getScreenshot(driver, result.getName());
            //Utility.getScreenshot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            logger.log(Status.FAIL, "Test Cases Failed is : " + result.getName());  //to add name in extent report.
            logger.log(Status.FAIL, result.getThrowable()); //to add error/ exception in extent report.
            logger.log(Status.FAIL, "Snapshot below: " + logger.addScreencastFromPath(temp));   //to add screenshot in extent report.
        }

        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, "Test Cases Skipped is : " + result.getName());
    }
        extent.flush();
        driver.closeApp();
        driver.quit();
    }
}
