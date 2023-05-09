package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreatePage;
import pages.LoginPage;

public class LoginTest extends BaseTests {

    String email = "your email here";
    String password = "your password here";


    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickLoginButtonInitialPage();
        loginPage.setUserNameField(email);
        loginPage.clickContinueButton();
        loginPage.setPasswordField(password);
        CreatePage createPage = loginPage.clickLoginButton();
        Assert.assertTrue(createPage.getTitleOfThePage().contains("Boards"), "title doesn't contain the text");
    }
}
