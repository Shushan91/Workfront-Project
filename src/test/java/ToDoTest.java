import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ToDoPage;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public class ToDoTest extends BaseTest {
    private ToDoPage toDoPage;

    @BeforeMethod
    public void setUp() {
        toDoPage = new ToDoPage();

    }

    @Test
    public void creationList() throws InterruptedException {
        toDoPage.loginWith("shushanpoghosyan@gmail.com", "123456");
        toDoPage.createList("BlaBla");



    }
}
