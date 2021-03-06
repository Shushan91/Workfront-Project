package pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static setup.DriverSetup.getDriver;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public abstract class BasePage<T> {
    Logger log = Logger.getLogger(Log.class.getName());
    protected WebDriver driver;
    public static final String BASE_URL =
            System.getProperty("selenium.url", "https://ancient-taiga-22967.herokuapp.com/login");

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void visit(String url) {
        log.info("Visiting " + url);
        driver.get(url);
    }


    public WebElement find(By locator) {
        log.info("Finding element by locator " + locator.toString());
        return driver.findElement(locator);
    }

    //public List<WebElement> findElements(By locator) {
    //log.info("Finding elements by locator " + locator.toString());
    //return driver.findElements(locator);
    //}

    public WebElement find(String cssSelector) {
        log.info("Finding element by cssSelector " + cssSelector);
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        log.info("Finding element by locator " + locator.toString());
        click(find(locator));
    }

    public void click(WebElement element) {
        log.info("Clicking on element " + element.toString());
        element.click();
    }

    public void click(String cssSelector) {
        log.info("Clicking on element " + cssSelector);
        click(find(cssSelector));
    }

    public void type(By locator, String text) {
        log.info("Typing " + text + " into element " + locator.toString());
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        log.info("Typing " + text + " into element " + element.toString());
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text) {
        log.info("Typing " + text + " into element " + cssSelector);
        type(find(cssSelector), text);
    }

    public boolean isDisplayed(WebElement element) {
        log.info("Checking element visibility " + element.toString());
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element, Integer timeout) {
        log.info("Checking element visibility of " + element.toString());
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isNotDisplayed(WebElement element, Integer timeout) {
        log.info("Checking element invisibility of " + element.toString());

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isDisplayed(By locator) {
        log.info(locator+ "is displayed");
        return isDisplayed(find(locator));
    }

    public boolean isDisplayed(String cssSelector) {
        log.info(cssSelector+ "is displayed");
        return isDisplayed(find(cssSelector));
    }

    public abstract String getUrl();

    public String getCurrentURL() {
        log.info("SignIn or SignUp is successfully done");
        return driver.getCurrentUrl();
    }







}
