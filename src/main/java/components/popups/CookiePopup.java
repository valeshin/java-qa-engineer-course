package components.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.function.Consumer;

public class CookiePopup extends AbsPopup {
    private final static String POPUP = "div[class=\"cookies\"]";

    @FindBy(css = POPUP + " button")
    private WebElement acceptButton;

    public CookiePopup(WebDriver driver) {
        super(driver);
    }

    public Consumer<WebElement> acceptCookie = acceptButton -> acceptButton.click();
}
