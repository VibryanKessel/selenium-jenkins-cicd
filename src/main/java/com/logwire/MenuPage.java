package com.logwire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    private WebDriver driver;

    private By menuLocator = By.xpath("(//aside[@data-v-5b6b3cf3])[1]");

    private By searchLoacator = By.xpath("//input[@data-v-636d6b87]");
    private By adminBtnLocator = By.xpath("(//span[@data-v-6475d26d])[1]");
    private By pimBtnLocator = By.xpath("(//span[@data-v-6475d26d])[2]");
    private By leaveBtnLocator = By.xpath("(//span[@data-v-6475d26d])[3]");
    private By timeBtnLocator = By.xpath("(//span[@data-v-6475d26d])[4]");
    private By recruitmentBtnLocator = By.xpath("(//span[@data-v-6475d26d])[5]");
    private By myInfoBtnLocator = By.xpath("(//span[@data-v-6475d26d])[6]");
    private By performanceBtnLocator = By.xpath("(//span[@data-v-6475d26d])[7]");
    private By dashboardBtnLocator = By.xpath("(//span[@data-v-6475d26d])[8]");
    private By directoryBtnLocator = By.xpath("(//span[@data-v-6475d26d])[9]");
    private By maintenanceBtnLocator = By.xpath("(//span[@data-v-6475d26d])[10]");
    private By claimBtnLocator = By.xpath("(//span[@data-v-6475d26d])[11]");
    private By buzzBtnLocator = By.xpath("(//span[@data-v-6475d26d])[12]");
    

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isMenuDisplayed() {
        return driver.findElement(menuLocator).isDisplayed();
    }

    public void goToAdmin() {
        driver.findElement(adminBtnLocator).click();
    }
    public void goToPIM() {
        driver.findElement(pimBtnLocator).click();
    }
    public void goToLeave() {
        driver.findElement(leaveBtnLocator).click();
    }
    public void goToTime() {
        driver.findElement(timeBtnLocator).click();
    }
    public void goToRecruitment() {
        driver.findElement(recruitmentBtnLocator).click();
    }
    public void goToMyInfo() {
        driver.findElement(myInfoBtnLocator).click();
    }
    public void goToPerformance() {
        driver.findElement(performanceBtnLocator).click();
    }
    public void goToDashboard() {
        driver.findElement(dashboardBtnLocator).click();    
    }
    public void goToDirectory() {
        driver.findElement(directoryBtnLocator).click();
    }
    public void goToMaintenance() {
        driver.findElement(maintenanceBtnLocator).click();
    }
    public void goToClaim() {
        driver.findElement(claimBtnLocator).click();
    }
    public void goToBuzz() {
        driver.findElement(buzzBtnLocator).click();
    }
    public void search(String text) {
        driver.findElement(searchLoacator).sendKeys(text);
    }
}
