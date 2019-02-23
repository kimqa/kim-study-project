package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterTextInToEmailField(String email) {
        try {
            webDriver.findElement(By.name("email")).sendKeys(email);
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
        }
    }

    public void enterPass(String pass) {
        try {
            webDriver.findElement(By.name("password")).sendKeys(pass);
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
        }
    }

    public void clickLoginButton() {
        try {
            webDriver.findElement(By.xpath(".//div[@class='btn-box']//button[@type ='submit']")).click();
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
        }
    }
}
