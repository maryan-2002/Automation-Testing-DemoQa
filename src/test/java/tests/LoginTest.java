package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import base.BaseTest;

import pages.LoginPage;


public class LoginTest extends BaseTest {

    LoginPage loginPage;

    //valid login
    @Test
    public void verifyLoginWithValidCredentials() {
        loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();

        loginPage.enterUsername("validUser");
        loginPage.enterPassword("Valid@123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isProfilePageDisplayed());
    }

    //invalid pass
    @Test
    public void verifyLoginFailsWithInvalidPassword() {
        loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();

        loginPage.enterUsername("validUser");
        loginPage.enterPassword("WrongPass");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message not displayed for invalid password!");
    }

    //empty fields
    @Test
    public void verifyLoginWithEmptyFields() {
        loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();

        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isFieldMarkedAsRequired(By.id("userName")),
                "Username field did NOT trigger required validation!");
        Assert.assertTrue(loginPage.isFieldMarkedAsRequired(By.id("password")),
                "Password field did NOT trigger required validation!");
    }
    //logout
    @Test
    public void verifyLogoutFunctionality() {
        loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();

        loginPage.enterUsername("validUser");
        loginPage.enterPassword("Valid@123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isProfilePageDisplayed(), "Profile page not displayed after login!");

        loginPage.clickLogout();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
                "Login button not displayed after logout, session may not be cleared!");
    }
}
