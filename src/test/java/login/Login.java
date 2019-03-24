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
    }

    @Test
    public void noRegisteredUserLogin() {
        homePage.openHomePage();
        homePage.openLoginPage();
        loginPage.login("test@test", "pass");
    }

    @Test
    public void invalidEmailAuth() {
        homePage.openHomePage();
        homePage.openLoginPage();
        loginPage.login("invalid@mail.com", PASSWORD);
    }

    @Test
    public void emptyFieldsLoginClick() {
        loginPage.openLoginPage();
        loginPage.login("","");
    }

    @Test
    public void logOut() {
        loginPage.login(LOGIN, "123456");
        Utils.waitABit(10);
        homePage.expandProfileBox();
        homePage.clickLogOut();
    }
}
