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

public class MenuTest {
    private WebDriver driver;
    private MenuPage menu;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ViewCandidatesPage viewCandidatesPage;

    @BeforeEach
    public void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
        String hubUrl = System.getProperty("selenium.hub.url", "http://selenium-hub:4444/wd/hub");
        driver = new RemoteWebDriver(new URL(hubUrl), options);

        menu= new MenuPage(driver);
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage(driver);
        viewCandidatesPage = new ViewCandidatesPage(driver);

        driver.get(loginPage.getUrl());

        Thread.sleep(3000); // On attend le chargement de la page

        loginPage.doLogin();
        testURL();

        Thread.sleep(3000); // On attend le chargement de la page

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }   

    public void testURL(){
        String currentURL = driver.getCurrentUrl();
        assertEquals(dashboardPage.getUrl(), currentURL);
    }

    @Tag("TC-009")
    @Tag("menu")
    @Tag("smoke")
    @Tag("regression")
    @DisplayName("Affichage du menu")
    @Test
    public void test1() throws InterruptedException {
        assertTrue(menu.isMenuDisplayed());
    }

    @Tag("TC-010")
    @Tag("menu")
    @Tag("regression")
    @DisplayName("Aller à la page Recrutement")
    @Test
    public void test2() throws InterruptedException {
        menu.goToRecruitment();
        
        Thread.sleep(3000); // On attend le chargement de la page
        
        assertEquals(viewCandidatesPage.getUrl(), driver.getCurrentUrl());
    }
}
