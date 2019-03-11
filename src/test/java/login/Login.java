package login;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;

public class Login extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterTextInToEmailField("ssls.automation+5@gmail.com");
        loginPage.enterPass("123456");
        loginPage.clickLoginButton();
    }
}
