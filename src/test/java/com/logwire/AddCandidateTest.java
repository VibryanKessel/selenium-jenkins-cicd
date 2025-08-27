package com.logwire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class AddCandidateTest {
    
    private WebDriver driver;

    private AddCandidatePage addCandidatePage;
    private ViewCandidatesPage viewCandidatesPage;
    private MenuPage menu;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
        
        menu = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        addCandidatePage = new AddCandidatePage(driver);
        viewCandidatesPage = new ViewCandidatesPage(driver);
        
        driver.get(loginPage.getUrl());
        
        Thread.sleep(3000); 
        
        loginPage.doLogin();
        
        Thread.sleep(3000); 

        menu.goToRecruitment();
        testURL();

        Thread.sleep(3000); 

        viewCandidatesPage.addCandidate();
        
        Thread.sleep(3000); 
        
    }   

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public void testURL() {
        assertEquals(viewCandidatesPage.getUrl(), driver.getCurrentUrl());
    }
    
    @Tag("TC-012")
    @DisplayName("Remplir le formulaire d'ajout d'un candidat")
    @Test
    @Tag("add-candidate")
    @Tag("smoke")
    @Tag("regression")
    public void test2() throws InterruptedException {
        addCandidatePage.fillCandidateInfos("Jean", "Fontaine", "Dupont", "jeandupont@gmail.com", 
                "0123456789", "Développeur", "Candidat très motivé");
        
        Thread.sleep(3000);

        addCandidatePage.checkDataConsentCheckbox();
        addCandidatePage.save();
        
        Thread.sleep(5000);

        assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate/\\d+$"));
        
        Thread.sleep(3000);
        
        driver.get(viewCandidatesPage.getUrl());

        viewCandidatesPage.isCandidateDisplayed("Jean", "Fontaine", "Dupont");
    }

    @Tag("TC-012")
    @DisplayName("Annuler l'ajout d'un candidat")
    @Test
    @Tag("add-candidate")
    @Tag("regression")
    public void test3() throws InterruptedException {
        addCandidatePage.fillCandidateInfos("Jean", "Fontaine", "Dupont", "jeandupont@gmail.com", 
                "0123456789", "Développeur", "Candidat très motivé");
        
        Thread.sleep(3000);

        addCandidatePage.checkDataConsentCheckbox();
        addCandidatePage.cancel();
        
        Thread.sleep(5000);

        assertEquals(viewCandidatesPage.getUrl(), driver.getCurrentUrl());
    }

    @Tag("TC-013")
    @DisplayName("Remplir le formulaire sans remplir les champs obligatoires(First Name, Last Name, Email)")
    @Test
    @Tag("add-candidate")
    @Tag("regression")
    public void test4() throws InterruptedException {
        addCandidatePage.fillCandidateInfos("", "Fontaine", "", "", 
                "0123456789", "Développeur", "Candidat très motivé");
        
        Thread.sleep(3000);

        addCandidatePage.checkDataConsentCheckbox();
        addCandidatePage.save();

        Thread.sleep(5000);

        assertEquals(3, addCandidatePage.nbOfUnfilledRequiredFields());

    }
}