package com.logwire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCandidatePage {
    private WebDriver driver;
    
    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate";

    private By firstNameFieldLocator = By.xpath("(//input[@data-v-1f99f73c])[2]");
    private By middleNameFieldLocator = By.xpath("(//input[@data-v-1f99f73c])[3]");
    private By lastNameFieldLocator = By.xpath("(//input[@data-v-1f99f73c])[4]");
    private By emailFieldLocator = By.xpath("(//input[@data-v-1f99f73c])[5]");
    private By contactNumberFieldLocator = By.xpath("(//input[@data-v-1f99f73c])[6]");
    private By keyWordsFieldLocator = By.xpath("(//input[@data-v-1f99f73c])[7]");
    private By notesFieldLocator = By.cssSelector("[data-v-bd337f32]");

    private By dataConsentCheckboxLocator = By.cssSelector("[data-v-6179b72a]");

    private By vacancySelectLocator = By.cssSelector("[data-v-67d2aedf]");
    private By vacancyListLocator = By.cssSelector("[data-v-40acfd38]");

    private By saveBtnLocator = By.xpath("(//button[@data-v-10d463b7])[2]");
    private By cancelBtnLocator = By.xpath("(//button[@data-v-10d463b7])[1]"); 

    private By requiredErrMsgLocator = By.cssSelector(".oxd-input-field-error-message");
       
    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }

    public void fillCandidateInfos(String firstName, String middleName, String lastName, String email, String contactNumber, String keyWords, String notes) throws InterruptedException {
        driver.findElement(firstNameFieldLocator).sendKeys(firstName);
        driver.findElement(middleNameFieldLocator).sendKeys(middleName);
        driver.findElement(lastNameFieldLocator).sendKeys(lastName);
        driver.findElement(emailFieldLocator).sendKeys(email);
        driver.findElement(contactNumberFieldLocator).sendKeys(contactNumber);
        driver.findElement(keyWordsFieldLocator).sendKeys(keyWords);
        driver.findElement(notesFieldLocator).sendKeys(notes);        

        driver.findElement(vacancySelectLocator).click();

        Thread.sleep(3000); // Wait for the vacancy list to load

        driver.findElement(vacancyListLocator).click(); 
    }

    public void checkDataConsentCheckbox(){
        driver.findElement(dataConsentCheckboxLocator).click();
    }
    public void save(){
        driver.findElement(saveBtnLocator).click();
    }
    public void cancel(){
        driver.findElement(cancelBtnLocator).click();
    }

    public int nbOfUnfilledRequiredFields() {
        return driver.findElements(requiredErrMsgLocator).size();
    }
}
