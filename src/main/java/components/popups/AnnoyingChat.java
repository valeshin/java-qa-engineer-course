package components.popups;

import annotations.Component;
import org.openqa.selenium.WebDriver;

@Component("jdiv #jcont")
public class AnnoyingChat extends AbsPopup {

    private final String closeButton = "#jivo_close_button";

    public AnnoyingChat(WebDriver driver) {
        super(driver);
    }

    public void closeChat() {
        getElement(closeButton).click();
    }
}
