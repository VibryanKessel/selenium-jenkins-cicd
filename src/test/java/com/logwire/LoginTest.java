package com.logwire;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Tag; 
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    @Tag("login")
public class LoginTest {
    
    private String dashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private WebDriver driver;
    
    private LoginPage loginPage;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        
        driver.get(loginPage.getUrl());
    }

    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    private void testURL() throws InterruptedException {
        String currentURL = driver.getCurrentUrl();
        assertEquals(loginPage.getUrl(), currentURL);

        Thread.sleep(3000);// On attend le chargement de la page
    }


    @Tag("TC-001")
    @Tag("login")
    @Tag("smoke")
    @Tag("regression")
    @DisplayName("Login username correct et password correct")
    @Test
    public void test1() throws InterruptedException{
        testURL();

        loginPage.fillUsername("Admin");
        loginPage.fillPassword("admin123");
        loginPage.clickLoginButton();

        assertEquals(dashboardUrl, driver.getCurrentUrl());
    }

@Tag("TC-002")
@Tag("login")
@Tag("regression")
@DisplayName("Login username incorrect et password correct")
@Test
public void test2() throws InterruptedException{
    testURL();

    loginPage.fillUsername("wrongusername");
    loginPage.fillPassword("admin123");
    loginPage.clickLoginButton();

    Thread.sleep(3000);

    assertEquals("Invalid credentials", loginPage.getErrorMsgText());
}

@Tag("TC-003")
@Tag("login")
@Tag("regression")
@DisplayName("Login username incorrect et password correct")
@Test
public void test3() throws InterruptedException{
    testURL();

    loginPage.fillUsername("wrongusername");
    loginPage.fillPassword("admin123");
    loginPage.clickLoginButton();

    Thread.sleep(3000);

    assertEquals("Invalid credentials", loginPage.getErrorMsgText());
}

@Tag("TC-004")
@Tag("login")
@Tag("regression")
@DisplayName("Login username correct et password incorrect")
@Test
public void test4() throws InterruptedException{
    testURL();

    loginPage.fillUsername("Admin");
    loginPage.fillPassword("wrongpassword");
    loginPage.clickLoginButton();

    Thread.sleep(3000);

    assertEquals("Invalid credentials", loginPage.getErrorMsgText());
}

@Tag("TC-005")
@Tag("login")
@Tag("regression")
@DisplayName("Login username incorrect et password incorrect")
@Test
public void test5() throws InterruptedException{
    testURL();

    loginPage.fillUsername("wrongusername");
    loginPage.fillPassword("wrongpassword");
    loginPage.clickLoginButton();

    Thread.sleep(3000);

    assertEquals("Invalid credentials", loginPage.getErrorMsgText());
}

@Tag("TC-006")
@Tag("login")
@Tag("regression")
@DisplayName("Login username rempli et password vide")
@Test
public void test6() throws InterruptedException{
        testURL();

        loginPage.fillUsername("Admin");
        loginPage.fillPassword("");
        loginPage.clickLoginButton();

        Thread.sleep(3000);

        assertEquals("Required", loginPage.getRequiredMsgText());
    }

@Tag("TC-007")
@Tag("login")
@Tag("regression")
@DisplayName("Login username vide et password rempli")
@Test
public void test7() throws InterruptedException{
        testURL();

        loginPage.fillUsername("");
        loginPage.fillPassword("admin123");
        loginPage.clickLoginButton();

        Thread.sleep(3000);

        assertEquals("Required", loginPage.getRequiredMsgText());
    }

    @Tag("TC-008")
    @Tag("login")
    @Tag("regression")
@DisplayName("Login username vide et password vide")
@Test
public void test8() throws InterruptedException{
        testURL();

        loginPage.fillUsername("Admin");
        loginPage.fillPassword("");
        loginPage.clickLoginButton();

        Thread.sleep(3000);

        assertEquals("Required", loginPage.getRequiredMsgText());
    }


}
