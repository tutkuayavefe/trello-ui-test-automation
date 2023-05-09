package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("user");
    private By continueButton = By.id("login");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-submit");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void setPasswordField(String password) {
        waitUntilElementVisible(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void waitUntilElementVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    }
    public CreatePage clickLoginButton() {
        waitUntilElementVisible(loginButton);
        driver.findElement(loginButton).click();
        return new CreatePage(driver);
    }

}
