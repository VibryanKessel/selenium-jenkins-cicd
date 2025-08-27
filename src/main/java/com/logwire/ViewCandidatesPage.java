package com.logwire;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewCandidatesPage {
    private WebDriver driver;

    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";

    private By addBtnLocator = By.xpath("(//button[@data-v-10d463b7])[3]");
    private By candidateBlocLocator = By.cssSelector("[data-v-1f99f73c]");
    
    public ViewCandidatesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void addCandidate(){
        driver.findElement(addBtnLocator).click();
    }

    public boolean isCandidateDisplayed(String firstName, String middleName, String lastName) {
        String candidateName = firstName + " " + middleName + "" + lastName;
        List<WebElement> candidateBlocs = driver.findElements(candidateBlocLocator);
        for (WebElement candidateBloc : candidateBlocs) {
            if (candidateBloc.getText().contains(candidateName)) {
                return true;
            }
        }
        return false;
    }
}
