package components.popups;

import annotations.Component;
import org.openqa.selenium.WebDriver;

@Component("div[class=\"cookies\"]")
public class CookiePopup extends AbsPopup {

    private final String acceptButton = "button";

    public CookiePopup(WebDriver driver) {
        super(driver);
    }

    public void acceptCookie() {
        getElement(acceptButton).click();
    }
}
