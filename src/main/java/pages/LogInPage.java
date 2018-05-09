package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Shush&Gar on 06-May-18.
 */
public class LogInPage extends BasePage {
    @FindBy(css = "input#email")
    private WebElement email;

    @FindBy(css = "input#password")
    private WebElement password;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement signIn;

    @FindBy(css = "div.alert.alert-error")
    private WebElement errorAlert;


    public LogInPage() {
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL;
    }

    public void loginWith(String username, String passwordSecure) {
        type(email, username);
        type(password, passwordSecure);
        click(signIn);

    }

    public String getCurrentUrl() {
        return getCurrentURL();

    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorAlert);
    }

//    public void registration() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
//        RequestBody body = RequestBody.create(mediaType, "ci_session=q9ghj9pkt20705lr1gho17djthr4an8p");
//        Request request = new Request.Builder()
//                .url("https://ancient-taiga-22967.herokuapp.com/register.do?name=ss&email=shushanpoghosyan@gmail.com&password=123456&confirmationPassword=123456")
//                .build();
//
//        Response response = client.newCall(request).execute();
//    }

}


