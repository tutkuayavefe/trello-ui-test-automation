package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    String pageTitle = "Boards | Trello";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButtonInitialPage() {
        clickLink("Log in");
        return new LoginPage(driver);
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public String getTitleOfThePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs(pageTitle));
        return driver.getTitle();
    }
}
