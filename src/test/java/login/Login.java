package login;

import libs.Utils;
import org.junit.Test;
import parentTest.ParentTest;
import static libs.ConfigProperties.*;
public class Login extends ParentTest {

    @Test
    public void validLogin() {
        homePage.openHomePage();
        homePage.openLoginPage();
        loginPage.enterTextInToEmailField(LOGIN);
        loginPage.enterPass(PASSWORD);
        loginPage.clickLoginButton();
        checkAC("validLogin assertion fail", homePage.emailInLoginBox().equals(LOGIN), true);
    }

    @Test
    public void noRegisteredUserLogin() {
        homePage.openHomePage();
        homePage.openLoginPage();
        loginPage.login("invalid@mail.com", "pass");
        checkAC("noRegisteredUserLogin assertion fail", loginPage.checknotification(), true);
    }

    @Test
    public void invalidEmailAuth() {
        homePage.openHomePage();
        homePage.openLoginPage();
        loginPage.login("invalid@mail", PASSWORD);
        checkAC("invalidEmailAuth assertion fail", loginPage.checkInvalidEmailErrorMessage(), true);
    }

    @Test
    public void emptyFieldsLoginClick() {
        loginPage.openLoginPage();
        loginPage.login("","");
        checkAC("emptyFieldsLoginClick - email assertion fail", loginPage.checkEmptyEmailErrorMessage(), true);
        checkAC("emptyFieldsLoginClick - pass assertion fail", loginPage.checkEmptyPassErrorMessage(), true);

    }

    @Test
    public void logOut() {
        loginPage.login(LOGIN, PASSWORD);
        homePage.expandProfileBox();
        homePage.clickLogOut();
        checkAC("logOut - assertion fail", loginPage.userIsOnAuthpage(), true);
    }
}
