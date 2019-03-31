package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = "//div[@class='form-group']//*[@class='left-tooltip-box']//span[@class='tooltip-text']")
    private WebElement passwordFieldErrorMessage;
    @FindBy(xpath = "//div[@class='form-group email']//*[@class='left-tooltip-box']//span[@class='tooltip-text']")
    private WebElement emailFieldErrorMessage;
    @FindBy(xpath = "//button//span[@class='icon icon-eye']")
    private WebElement eyeIcon;
    @FindBy(name = "email")
    private WebElement emailAdress;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//div[@class='input-box password']")
    private WebElement inputBoxPassword;
    @FindBy(xpath = ".//div[@class='btn-box']//button[@type ='submit']")
    private WebElement loginButton;
    @FindBy(xpath = ".//*[@ng-click='showPassword = !showPassword']")
    private WebElement showPasswordButton;
    @FindBy(xpath = ".//*[@class='notification information']//div[@class='noty_message message']/span")
    private WebElement notification;
    @FindBy(xpath = "//form[@name='authForm']")
    private WebElement authForm;




    public void openLoginPage() {
        actionsWithElements.openPage(baseUrl + "/authorize");
    }

    public void enterTextInToEmailField(String email) {
        actionsWithElements.waitUntilElementIsDisplayed(authForm);
        actionsWithElements.enterTextInToElement(emailAdress, email);
    }

    public void enterPass(String pass) {
        actionsWithElements.waitUntilElementIsDisplayed(authForm);
        actionsWithElements.enterTextInToElement(password, pass);
//        Assert.assertTrue("password is not as typed", actionsWithElements.getTextFromField(showPasswordButton) == pass);
    }

    public void checkPassword(String pass) {
        actionsWithElements.waitUntilElementIsDisplayed(eyeIcon);
        actionsWithElements.clickOnElement(eyeIcon);
        Assert.assertTrue("password is not as typed", actionsWithElements.getTextFromField(password) == pass);

    }

    public void clickLoginButton() {
        actionsWithElements.clickOnElement(loginButton);

    }

    public void login(String email, String pass) {
        openLoginPage();
        enterTextInToEmailField(email);
        enterPass(pass);
//        checkPassword(pass);
        clickLoginButton();
    }

    public boolean checkInvalidEmailErrorMessage() {
        return actionsWithElements.checkTextIsDisplayed("Uh oh! This\n" + "isn’t an email", emailFieldErrorMessage);
    }
    public boolean checkEmptyEmailErrorMessage() {
        return actionsWithElements.checkTextIsDisplayed("Oops, please\n" + "enter your email", emailFieldErrorMessage);
    }
    public boolean checkEmptyPassErrorMessage() {
        return actionsWithElements.checkTextIsDisplayed("Looks like you’ve\n" +"missed this one", passwordFieldErrorMessage);
    }
    public boolean checknotification() {
        return actionsWithElements.checkTextIsDisplayed("Uh oh! Email or password is incorrect", notification);
    }
    public boolean userIsOnAuthpage() {

        return actionsWithElements.checkCurrentUrl(baseUrl + "/authorize");
    }
}
