package pages;

import com.applitools.eyes.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@ui-sref='authorize.index']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@nc-dropdown-trigger='statusOpened']")
    private WebElement expandProfileBox;
    @FindBy(xpath = "//button[@class='drop-button'][contains(text(),'Log out')]")
    private WebElement logOutButton;
    @FindBy (xpath = "//a[@ui-sref='user.certificates.list']")
    private WebElement loginBoxEmail;
    @FindBy(xpath = "//form[@name='authForm']")
    private WebElement authForm;
    @FindBy(xpath = "//a[@href='/user/profile']")
    private WebElement viewProfileUrl;

    Eyes eyes = new Eyes();
    public HomePage(WebDriver webDriver) {
        super(webDriver);
//        this.eyes = eyes;
        eyes.setApiKey("QCE4mQrZbPQ9oOSQ20WjA103EdApjVNYIGDPsQrH6zT58110");

    }

    public void openHomePage() {
        actionsWithElements.openPage(baseUrl);
        eyes.open(webDriver,"test","test");
        eyes.checkWindow("Home Page");
        eyes.close();
    }

    public void openLoginPage() {
        actionsWithElements.clickOnElement(loginButton);
        actionsWithElements.checkCurrentUrl(baseUrl + "/authorize");
    }

    public void expandProfileBox() {
        actionsWithElements.clickOnElement(expandProfileBox);
    }

    public void clickLogOut() {
        actionsWithElements.clickOnElement(logOutButton);
        actionsWithElements.waitUntilUrl("/authorize");
    }

    public String emailInLoginBox() {
        return actionsWithElements.getTextFromField(loginBoxEmail);
    }

    public void openViewProfilePage() {
        expandProfileBox();
        clickViewProfile();
    }

    private void clickViewProfile() {
        actionsWithElements.waitUntilElementIsDisplayed(viewProfileUrl);
        actionsWithElements.clickOnElement(viewProfileUrl);
    }
}
