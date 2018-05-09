import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ARegisterPage;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Shush&Gar on 09-May-18.
 */
public class ARegisterTest extends BaseTest {
    private ARegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        registerPage = new ARegisterPage();

    }


    @Test
    public void register()  {
        registerPage.registerWith( "ss","shushanpoghosyan2@gmail.com", "123456", "123456");
        assertTrue(registerPage.getCurrentURL().contains("user/todos"));

    }
}
