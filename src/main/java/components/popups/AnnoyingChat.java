package components.popups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.function.Consumer;

public class AnnoyingChat extends AbsPopup {

    private final static String CHAT = "jdiv #jcont";

    @FindBy(css = CHAT)
    private WebElement chatWidget;

    @FindBy(css = CHAT + " #jivo_close_button")
    private WebElement closeButton;

    public AnnoyingChat(WebDriver driver) {
        super(driver);
    }

    public Consumer<WebElement> closeChat = closeButton -> closeButton.click();
}
