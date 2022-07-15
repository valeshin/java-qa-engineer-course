package components.popups;

import com.google.inject.Inject;
import common.GuiceScoped;
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

    @Inject
    public AnnoyingChat(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public Consumer<WebElement> closeChat = closeButton -> closeButton.click();
}
