package myProfileTest;

import org.junit.Test;
import parentTest.ParentTest;

import static libs.ConfigProperties.*;

public class MyProfileTest extends ParentTest {

    @Test
    public void openMyProfilePage() {
        loginPage.login(LOGIN, PASSWORD);
        homePage.openViewProfilePage();
        myProfilePage.clickEditEmail();
        checkAC("email is incorrect", myProfilePage.checkEmail(LOGIN), true);
    }
}
