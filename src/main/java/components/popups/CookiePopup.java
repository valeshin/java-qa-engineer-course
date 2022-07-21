package components.popups;

import annotations.Component;
import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.function.Consumer;

@Component("div[class=\"cookies\"]")
public class CookiePopup extends AbsPopup {

    private String acceptButton = "button";

    @Inject
    public CookiePopup(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public Consumer<String> acceptCookie = acceptButton -> getElement(acceptButton).click();
}
