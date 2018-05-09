import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public class LogInTest extends BaseTest {
    private LogInPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LogInPage();

    }

    @Test
    public void login() {
        loginPage.loginWith("shushanpoghosyan@gmail.com", "123456");
        assertTrue("Unsuccessful signIn", loginPage.getCurrentURL().contains("user/todos"));

    }

    @Test
    public void loginInvalid() {
        loginPage.loginWith("shushanpoghosyan@gmail.com", "123");
        assertTrue("Login Error: invalid email/password", loginPage.isErrorMessageDisplayed());
    }

}


