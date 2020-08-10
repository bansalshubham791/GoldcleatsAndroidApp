package com.qa.screen;

import com.qa.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends BaseClass {

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
    @CacheLookup
    AndroidElement alwaysAllowAlertButton;
    @FindBy(xpath = "//*[@text='OK']")
    AndroidElement okButton;

    //Initializing the page objects:
  /*  public LoginScreen(){
        super();
        BaseClass.setUp();
        PageFactory.initElements(driver, LoginScreen.class);
    }*/

    public LoginScreen allowAppPremissions(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_always_button")));
        androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button")).click();
        return this;
    }

    public LoginScreen loginButtonClick(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Log In']")));
        androidDriver.findElement(By.xpath("//*[@text='Log In']")).click();
        return this;
    }

    public LoginScreen loginUserNameTextBox(String username, AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Enter Your mobile/email']")));
        androidDriver.findElement(By.xpath("//*[@text='Enter Your mobile/email']")).sendKeys(username);
        return this;
    }
    public LoginScreen loginPasswordTextBox(String password,AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Enter your password']")));
        androidDriver.findElement(By.xpath("//*[@text='Enter your password']")).sendKeys(password);
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"mobile.The password will be sent on this\"]")));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"mobile.The password will be sent on this\"]")).click();
        return this;
    }

    public Boolean isWrongPasswordAlertBoxPresent(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='The password you entered is incorrect']")));
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text='The password you entered is incorrect']")).isDisplayed();
    }

    public Boolean isInvalidUserNameAlertBoxPresent(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='There is no user registered with this email or mobile number']")));
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text='There is no user registered with this email or mobile number']")).isDisplayed();
    }

    public Boolean isLoginTutorialsPresent(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.id("com.goldCleats.GoldCleats:id/btGotIt")));
        return androidDriver.findElement(By.id("com.goldCleats.GoldCleats:id/btGotIt")).isDisplayed();
    }

    public Boolean isDeactivatedScreenPresent(AndroidDriver androidDriver){
        //waitVisibility(By.xpath("//*[@text='Enter Your mobile/email']"));
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.id("com.goldCleats.GoldCleats:id/btGotIt")));
        return driver.findElement(By.xpath("//*[@text='Enter Your mobile/email']")).isDisplayed();
    }
    public Boolean isIncorrectUsernamePresent(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Please enter valid phone number.']")));
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Please enter valid phone number.']")).isDisplayed();
    }
    public Boolean isUserNamePresent(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Please enter valid phone number.']")));
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Please enter valid phone number.']")).isDisplayed();
    }

    public Boolean isOnlyPlayerOrParentAccessAlertboxPresent(AndroidDriver androidDriver){
        new WebDriverWait(androidDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Only player or parent can access account!']")));
        return androidDriver.findElement(By.xpath("//*[@text='Only player or parent can access account!']")).isDisplayed();
    }

}
