package pages;

import libs.ActionsWithElements;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import libs.ConfigProperties;

public class ParentPage {
    WebDriver webDriver;
    ActionsWithElements actionsWithElements;
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected static final String baseUrl = configProperties.base_url();

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
        actionsWithElements = new ActionsWithElements(webDriver);
    }
}
