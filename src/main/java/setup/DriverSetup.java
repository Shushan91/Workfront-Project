package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "D:/Desktop/workfront-project/chromedriver_win32/chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    driver = new ChromeDriver();
                    driver.manage().window().fullscreen();
                    break;

                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "D:/Desktop/workfront-project/geckodriver-v0.19.1-win64/geckodriver");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().fullscreen();
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            if(BROWSER.equals("firefox")){
                driver.close();
                driver = null;
            } else if (BROWSER.equals("chrome")) {
                driver.close();
                driver.quit();
                driver = null;
            }
        }
    }
}
