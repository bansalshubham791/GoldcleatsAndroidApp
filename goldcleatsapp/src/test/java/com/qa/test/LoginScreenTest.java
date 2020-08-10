package com.qa.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.Utils.Retry;
import com.qa.Utils.Utility;
import com.qa.base.BaseClass;
import com.qa.screen.LoginScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginScreenTest extends BaseClass {
    static LoginScreen loginScreen = new LoginScreen();

    @Test(priority = 1, retryAnalyzer= Retry.class)
        public void wrongPasswordAlertBoxTest(){
        logger = extent.createTest("TC01_ifWrongPasswordAlertBoxComing");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("d22@yopmail.com", driver).loginPasswordTextBox("123456", driver);
        Assert.assertTrue(loginScreen.isWrongPasswordAlertBoxPresent(driver));
        logger.log(Status.PASS, "Wrong Password Alertbox displayed..");
    }

    @Test(priority = 2, retryAnalyzer=Retry.class)
    public void invalidUserNameAlertBoxTest(){
        logger = extent.createTest("TC02_ifInvalidUserNameAlertBoxComing");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("d1@yopmail.com", driver).loginPasswordTextBox("123456", driver);
        Assert.assertTrue(loginScreen.isInvalidUserNameAlertBoxPresent(driver));
        logger.log(Status.PASS, "Invalid UserName Alertbox displayed..");

    }
    @Test(priority = 3, retryAnalyzer=Retry.class)
    public void validLoginCredentialsEmailTest(){
        logger = extent.createTest("TC03_ifPlayerLoginViaEmailSuccessful ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("d22@yopmail.com", driver).loginPasswordTextBox("1234567", driver);
        Assert.assertTrue(loginScreen.isLoginTutorialsPresent(driver));
        logger.log(Status.PASS, "Valid Email Credentials provided.. Login Completed Successfully..");

    }

    @Test(priority = 4, retryAnalyzer=Retry.class)
    public void validLoginCredentialsMobileTest(){
        logger = extent.createTest("TC04_ifPlayerLoginViaMobileSuccessful ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("7983947872", driver).loginPasswordTextBox("1234567", driver);
        Assert.assertTrue(loginScreen.isLoginTutorialsPresent(driver));
        logger.log(Status.PASS, "Valid Mobile Credentials provided.. Login Completed Successfully..");

    }


    @Test(priority = 5, retryAnalyzer=Retry.class)
    public void invalidEmailIdPresentTest(){
        logger = extent.createTest("TC05_ifPlayerLoginSuccessful ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("aa", driver).loginPasswordTextBox("123456", driver);
        Assert.assertTrue(loginScreen.isIncorrectUsernamePresent(driver));
        logger.log(Status.PASS, "InValid Email Credentials provided.. ");

    }
    @Test(priority = 6, retryAnalyzer=Retry.class)
    public void EmailIdPresentTest(){
        logger = extent.createTest("TC06_ifPlayerLoginSuccessful ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginPasswordTextBox("123456", driver);
        Assert.assertTrue(loginScreen.isUserNamePresent(driver));
        logger.log(Status.PASS, "Username not provided.. ");

    }

    @Test(priority = 7, retryAnalyzer=Retry.class)
    public void scoutEmailIdPresentTest(){
        logger = extent.createTest("TC07_ifScoutLoginSuccessful ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("us42@yopmail.com",driver).loginPasswordTextBox("123456", driver);
        Assert.assertTrue(loginScreen.isOnlyPlayerOrParentAccessAlertboxPresent(driver));
        logger.log(Status.PASS, "Scout credentials provided.. ");
    }
    /*@Test
    public void failTest(){
        Assert.assertFalse(true);
    }*/
    /*
     *  deactivatedLoginCredentialsTest element is not getting identified at reactivation screen.
     *
     * */
    @Test(enabled = false)
    public void deactivatedLoginCredentialsTest(){
        logger = extent.createTest("TC07_deactivatedLoginCredentialsTest ");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Start Sign Up ✍️']")).click();
        logger.log(Status.INFO, "Public Profile Reached..");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")));
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"SEARCH\"]")).click();
        logger.log(Status.INFO, "Login Screen Reached..");
        loginScreen.allowAppPremissions(driver).loginButtonClick(driver).loginUserNameTextBox("9555462969", driver).loginPasswordTextBox("123456", driver);
        Assert.assertTrue(loginScreen.isDeactivatedScreenPresent(driver));
        logger.log(Status.PASS, "Deactivated Credentials provided..");
    }
}
