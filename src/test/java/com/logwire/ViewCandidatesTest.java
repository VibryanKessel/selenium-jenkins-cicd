package com.logwire;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class ViewCandidatesTest {
    private WebDriver driver;
    private ViewCandidatesPage viewCandidatesPage;
    private MenuPage menu;
    private LoginPage loginPage;
    private AddCandidatePage addCandidatePage;

    @BeforeEach
    public void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
        String hubUrl = System.getProperty("selenium.hub.url", "http://192.168.1.81:4444/wd/hub");
        driver = new RemoteWebDriver(new URL(hubUrl), options);
        
        menu = new MenuPage(driver);
        loginPage = new LoginPage(driver);
        viewCandidatesPage = new ViewCandidatesPage(driver);
        addCandidatePage = new AddCandidatePage(driver);
        
        driver.get(loginPage.getUrl());
        
        Thread.sleep(3000); 
        
        loginPage.doLogin();
        
        Thread.sleep(3000); 
        
        menu.goToRecruitment();
        testURL();
        
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
    
    @Tag("view-candidates")
    @Tag("TC-011")
    @Tag("smoke")
    @Tag("regression")
    @Tag("TC-011")
    @DisplayName("Aller au formulaire d'ajout d'un candidat")
    @Test
    public void test1() throws InterruptedException {
        viewCandidatesPage.addCandidate();
        
        Thread.sleep(3000); 
        
        assertEquals(addCandidatePage.getUrl(), driver.getCurrentUrl());
    }
}
