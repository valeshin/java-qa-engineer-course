package components.popups;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import java.util.function.Consumer;

@Component("jdiv #jcont")
public class AnnoyingChat extends AbsPopup {

    private final String closeButton = "#jivo_close_button";

    public AnnoyingChat(WebDriver driver) {
        super(driver);
    }

    public Consumer<String> closeChat = closeButton -> getElement(closeButton).click();
}
