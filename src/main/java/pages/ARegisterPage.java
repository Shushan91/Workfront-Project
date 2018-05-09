package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Shush&Gar on 09-May-18.
 */
public class ARegisterPage extends BasePage {
    @FindBy(css = "input#name.input-medium")
    private WebElement naMe;

    @FindBy(css = "input#email.input-medium")
    private WebElement email;

    @FindBy(css = "input#password.input-medium")
    private WebElement password;

    @FindBy(css = "input#confirmationPassword.input-medium")
    private WebElement confirmPassword;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement signUp;

    public ARegisterPage() {
        visit(getUrl());
    }

    public String getUrl() {
        return "https://ancient-taiga-22967.herokuapp.com/register";
    }

    public void registerWith(String name, String username, String passwordSecure, String passwordConfirmation) {

        type(naMe, name);
        type(email, username);
        type(password, passwordSecure);
        type(confirmPassword, passwordConfirmation);
        click(signUp);

    }

}
