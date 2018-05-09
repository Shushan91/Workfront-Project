import org.testng.annotations.AfterMethod;

import static setup.DriverSetup.quitDriver;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public class BaseTest { @AfterMethod
public void tearDownBase() {
    quitDriver();
}
}

