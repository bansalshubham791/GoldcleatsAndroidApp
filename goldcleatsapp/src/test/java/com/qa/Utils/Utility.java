package com.qa.Utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
   
    public static String getScreenshot(AndroidDriver driver, String screenShotName)
    {
        String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path= System.getProperty("user.dir") + "/failedTestScreenShots/" + screenShotName +"_"+ dateName + ".png";
        File destination=new File(path);
        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
    }
}

