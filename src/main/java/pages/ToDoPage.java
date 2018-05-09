package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public class ToDoPage extends BasePage {
    @FindBy(xpath = "//a[@href='/user/todos/new']")
    private WebElement createToDo;

    @FindBy(css = "input#title")
    private WebElement title;

    @FindBy(css = "**")
    private WebElement date;

    @FindBy(css = ".**")
    private WebElement priority;

    @FindBy(css = "button.btn.btn-primary")    //correct css element
    private WebElement create;

    @FindBy(css = "table.table-bordered.table-striped")
    private WebElement toDoListTable;

    @FindBy(css = "input#email")
    private WebElement email;

    @FindBy(css = "input#password")
    private WebElement password;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement signIn;

    @FindBy(css = "span.badge.badge-inverse")
    private WebElement total;


    public ToDoPage() {
        visit(getUrl());
    }

    public String getUrl() {
        return "https://ancient-taiga-22967.herokuapp.com/user/todos";
    }

    public void loginWith(String username, String passwordSecure) {
        type(email, username);
        type(password, passwordSecure);
        click(signIn);

    }

    public void createList(String titleText) throws InterruptedException {

        Thread.sleep(500);
        click(createToDo);
        type(title, titleText);
        Thread.sleep(10000);
        click(create);

    }


}
