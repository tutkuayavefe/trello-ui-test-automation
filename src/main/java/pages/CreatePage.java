package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreatePage {

    private final WebDriver driver;
    private final By boardTitle = By.xpath("//input[@type='text']");
    String pageTitle = "Boards | Trello";
    private final By createButton = By.xpath(".//button[@aria-label='Create board or Workspace']");
    private final By createBoard = By.xpath(".//button[@data-testid='header-create-board-button']");
    private final By createFinalButton = By.xpath(".//button[@data-testid='create-board-submit-button']");
    private final By addAnotherList = By.xpath(".//span[normalize-space()='Add another list']");
    private final By listField = By.xpath(".//input[@placeholder='Enter list title…']");
    private final By addListButton = By.xpath(".//input[@value='Add list']");
    private final By addCard = By.xpath(".//span[contains(text(),'Add a card')])[1]");
    private final By addCardWithXpath = By.xpath(".//div[2]/div/div/div/textarea");
    private final By enterTitleForCardField = By.xpath(".//textarea[@placeholder='Enter a title for this card…']");
    private final By addCardButton = By.xpath(".//input[@value='Add card']");
    private final By addedCard = By.className("list-card-title");
    private final By addedCardPopUpToEdit = By.className("mod-card-back-title");
    private final By saveButton = By.xpath(".//input[@value='Save']");
    private final By closeWindowButton = By.xpath("(.//a[@aria-label='Close dialog'])[1]");
    private final By secondColumn = By.xpath("(.//span[contains(text(),'Add a card')])[2]");
    private final By boardHoverOver = By.xpath("//a[@title='Project Trello (currently active)']");
    private final By menuDot = By.xpath("(.//div[@role='menu'])[3]");
    private final By closeBoardTextButton = By.xpath(".//body/div/div/section/div/div/button[@title='Close board']/span[1]");
    private final By closeButtonPopup = By.xpath("(.//button[@title='Close'])[1]");
    private final By permanentlyDeleteButton = By.xpath(".//button[@data-testid='close-board-delete-board-button']");


    public CreatePage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterBoardTitle() {
        waitUntilElementVisible(boardTitle);
        driver.findElement(boardTitle).sendKeys("Project Trello");
        waitUntilElementVisible(createFinalButton);
        driver.findElement(createFinalButton).click();
    }

    public String assertUrlContains() {
        String url;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("project-trello"));
        url = driver.getCurrentUrl();
        return url;
    }

    public String getTitleOfThePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs(pageTitle));
        return driver.getTitle();
    }

    public void creationOfBoard() {
        waitUntilElementVisible(createButton);
        driver.findElement(createButton).click();
        waitUntilElementVisible(createBoard);
        driver.findElement(createBoard).click();
    }

    public void waitUntilElementVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void addNewList() {
        waitUntilElementVisible(addAnotherList);
        driver.findElement(addAnotherList).click();
        waitUntilElementVisible(listField);
        driver.findElement(listField).sendKeys("Archived");
        waitUntilElementVisible(addListButton);
        driver.findElement(addListButton).click();
    }


    public void addCardToTheList() {
        waitUntilElementVisible(addCardWithXpath);
        driver.findElement(addCardWithXpath).click();
        waitUntilElementVisible(enterTitleForCardField);
        driver.findElement(enterTitleForCardField).sendKeys("Test Card");
        waitUntilElementVisible(addCardButton);
        driver.findElement(addCardButton).click();
    }

    public void assertIfItemVisible() {
        waitUntilElementVisible(addedCard);
    }

    public void editCardUnderList() {
        waitUntilElementVisible(addedCard);
        driver.findElement(addedCard).click();
        waitUntilElementVisible(addedCardPopUpToEdit);
        WebElement popUpManage = driver.findElement(addedCardPopUpToEdit);
        popUpManage.click();
        popUpManage.sendKeys(" edited version");
        waitUntilElementVisible(saveButton);
        driver.findElement(saveButton).click();
        waitUntilElementVisible(closeWindowButton);
        driver.findElement(closeWindowButton).click();
    }

    public void dragAndDrop() {
        waitUntilElementVisible(addedCard);
        WebElement From = driver.findElement(addedCard);
        WebElement To = driver.findElement(secondColumn);
        Actions action = new Actions(driver);
        action.dragAndDrop(From, To).build().perform();
    }

    public void deleteBoard() throws InterruptedException {
        Thread.sleep(3000);
        WebElement figure = driver.findElement(boardHoverOver);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        driver.findElement(menuDot).click();
        driver.findElement(closeBoardTextButton).click();
        driver.findElement(closeButtonPopup).click();
        waitUntilElementVisible(permanentlyDeleteButton);
        driver.findElement(permanentlyDeleteButton).click();
    }

}
