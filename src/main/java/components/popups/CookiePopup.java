package components.popups;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.function.Consumer;

@Component("div[class=\"cookies\"]")
public class CookiePopup extends AbsPopup {

    private final String acceptButton = "button";

    public CookiePopup(WebDriver driver) {
        super(driver);
    }

    public Consumer<String> acceptCookie = acceptButton -> getElement(acceptButton).click();
}
