package com.qa.test;

        import com.aventstack.extentreports.ExtentReports;
        import com.aventstack.extentreports.ExtentTest;
        import com.aventstack.extentreports.MediaEntityBuilder;
        import com.aventstack.extentreports.Status;
        import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
        import com.qa.Utils.Retry;
        import com.qa.Utils.Utility;
        import com.qa.base.BaseClass;
        import com.qa.screen.IntroductionScreen;
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.touch.WaitOptions;
        import io.appium.java_client.touch.offset.PointOption;
        import org.openqa.selenium.By;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.ITestResult;
        import org.testng.annotations.*;

        import java.io.IOException;
        import java.time.Duration;

public class PublicViewTest extends BaseClass {

   

 /*   @Test
    public void testPublicviewonetimevideoplay() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        new TouchAction(driver).press(PointOption.point(660, 1270)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1226))).moveTo((PointOption.point(660, 1270))).release().perform();
        driver.findElement(By.xpath("//*[@class='android.widget.VideoView']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='video_view']")));
        driver.findElement(By.xpath("//*[@id='video_view']")).click();
        driver.findElement(By.xpath("//*[@class='android.widget.VideoView']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Deny']")));
        driver.findElement(By.xpath("//*[@text='Deny']")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).isDisplayed());
    }*/
    @Test(retryAnalyzer= Retry.class)
    public void testSearchButtonAtPublicView(){
        logger = extent.createTest("TC01_ifSearchbuttonAtPublicViewDisplayed ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).isDisplayed());
        //Assert.assertTrue(false);
        logger.log(Status.PASS, "Search Button verified");
    }

    @Test(retryAnalyzer=Retry.class)
    public void testCommunityButtonAtPublicView(){
        logger = extent.createTest("TC02_ifCommunitybuttonAtPublicViewDisplayed ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.id("com.goldCleats.GoldCleats:id/tvCommunity")));
        Assert.assertTrue(driver.findElement(By.id("com.goldCleats.GoldCleats:id/tvCommunity")).isDisplayed());
        logger.log(Status.PASS, "Community button Clicked..");
    }

    @Test(retryAnalyzer=Retry.class)
    public void testFollowingButtonAtPublicView(){
        logger = extent.createTest("TC03_ifFollowingbuttonAtPublicViewDisplayed ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.id("com.goldCleats.GoldCleats:id/tvFollowing")));
        Assert.assertTrue(driver.findElement(By.id("com.goldCleats.GoldCleats:id/tvFollowing")).isDisplayed());
        logger.log(Status.PASS, "Following button Clicked..");

    }
  /*  @Test
    public void testProfilePicAtPublicView(){
        logger = extent.createTest("ifprofilePictureAtPublicViewDisplayed ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.id("com.goldCleats.GoldCleats:id/ivUserPic\n")));
        Assert.assertTrue(driver.findElement(By.id("com.goldCleats.GoldCleats:id/ivUserPic\n")).isDisplayed());
        logger.log(Status.PASS, "Community button Clicked..");
    }*/


  /*  @Test
    public void testSearchAtPublicView(){
        introductionScreen.clickNextButton();
        introductionScreen.clickNextButton();
        introductionScreen.clickNextButton();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        Assert.assertTrue(driver.findElement(By.id("searchAtPublicViewID")).isDisplayed());
        }*/


}
