package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "email")
    private WebElement emailAdress;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = ".//div[@class='btn-box']//button[@type ='submit']")
    private WebElement loginButton;
    @FindBy(xpath = ".//*[@ng-click='showPassword = !showPassword']")
    private WebElement showPasswordButton;

    @FindBy(xpath = ".//*[@class=''notification information']")
    private WebElement notification;

    public void openLoginPage() {
        actionsWithElements.openPage("https://www.ssls.com/authorize");
    }

    public void enterTextInToEmailField(String email) {
        actionsWithElements.enterTextInToElement(emailAdress, email);
    }

    public void enterPass(String pass) {
        actionsWithElements.enterTextInToElement(password, pass);
        Assert.assertTrue("password is not as typed", actionsWithElements.getTextFromField(showPasswordButton) == pass);
    }

    public void clickLoginButton() {
        actionsWithElements.clickOnElement(loginButton);
    }

    public void login(String email, String pass) {
        openLoginPage();
        enterTextInToEmailField(email);
        enterPass(pass);
        clickLoginButton();
    }


}
