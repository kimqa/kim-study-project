package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = ".//div[@class='btn-box']//button[@type ='submit']")
    private WebElement loginButton;


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
