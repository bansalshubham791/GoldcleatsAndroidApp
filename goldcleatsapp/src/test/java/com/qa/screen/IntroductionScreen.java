package com.qa.screen;

import com.qa.base.BaseClass;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntroductionScreen extends BaseClass {
    @FindBy(xpath="//*[@text='Next']")
    MobileElement nextElement ;

    public void clickNextButton(){
       // new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        nextElement.click();
    }
}
