package components.popups;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.function.Consumer;

public class CookiePopup extends AbsPopup {
    private final static String POPUP = "div[class=\"cookies\"]";

    @FindBy(css = POPUP + " button")
    private WebElement acceptButton;

    @Inject
    public CookiePopup(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public Consumer<WebElement> acceptCookie = acceptButton -> acceptButton.click();
}
