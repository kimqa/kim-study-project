package login;

import org.junit.Test;
import parentTest.ParentTest;

public class Login extends ParentTest {

    @Test
    public void validLogin() {
        homePage.openHomePage();
        homePage.openLoginPage();
        loginPage.enterTextInToEmailField("ssls.automation+5@gmail.com");
        loginPage.enterPass("123456");
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
        loginPage.login("invalid@mail.com", "123456");
    }

    @Test
    public void emptyFieldsLoginClick() {
        loginPage.openLoginPage();
        loginPage.login("","");
    }
}
