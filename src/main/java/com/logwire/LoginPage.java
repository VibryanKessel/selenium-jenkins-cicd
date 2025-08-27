package com.logwire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    private By usernameLocator = By.cssSelector("[name='username']");
    private By passwordLocator = By.cssSelector("[name='password']");
    private By loginBtnLocator = By.cssSelector(".orangehrm-login-button");
    private By errorMsgLocator = By.cssSelector(".oxd-alert-content-text");
    private By requiredMsgLocator = By.cssSelector(".oxd-input-field-error-message");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillUsername(String text){
        driver.findElement(usernameLocator).sendKeys(text);
    }
    public void fillPassword(String text){
        driver.findElement(passwordLocator).sendKeys(text);
    }
    public void clickLoginButton(){
        driver.findElement(loginBtnLocator).click();;
    }

    public String getUrl(){
        return this.url;
    }

    public void doLogin(){
        this.fillUsername("Admin");
        this.fillPassword("admin123");
        this.clickLoginButton();
    }

    public String getErrorMsgText(){
        return driver.findElement(errorMsgLocator).getText();
    }
    public String getRequiredMsgText(){
        return driver.findElement(requiredMsgLocator).getText();
    }
}
