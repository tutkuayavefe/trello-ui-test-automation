package createBoard;

import base.BaseTests;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreatePage;
import pages.LoginPage;


public class CreateBoardTests extends BaseTests {

    String email = "your email here";
    String password = "your password here";
    CreatePage createPage;

    @BeforeMethod
    public void loginAndBoardCreateFunction() {
        LoginPage loginPage = homePage.clickLoginButtonInitialPage();
        loginPage.setUserNameField(email);
        loginPage.clickContinueButton();
        loginPage.setPasswordField(password);
        createPage = loginPage.clickLoginButton();
        createPage.creationOfBoard();
        createPage.enterBoardTitle();
    }

    @Test
    public void verifyBoardIsCreatedSuccessfully() {
        String url = createPage.assertUrlContains();
        Assert.isTrue(url.contains("project-trello"), "url doesn't contain the string");
    }

    @Test
    public void verifyListIsCreatedSuccessfully() {
        createPage.addNewList();
    }

    @Test
    public void verifyCardIsCreatedUnderTodoListSuccessfully() {
        createPage.addCardToTheList();
        createPage.assertIfItemVisible();
    }

    @Test
    public void verifyCardIsEditedSuccessfully() {
        createPage.addCardToTheList();
        createPage.editCardUnderList();
        createPage.assertIfItemVisible();
    }

    @Test
    public void verifyCardIsMovedToNextColumn() {
        createPage.addCardToTheList();
        createPage.dragAndDrop();
        createPage.assertIfItemVisible();
    }

    @AfterMethod
    public void boardDeletion() throws InterruptedException {
        createPage.deleteBoard();
    }
}
