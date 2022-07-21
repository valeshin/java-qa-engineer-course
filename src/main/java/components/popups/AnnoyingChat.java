package components.popups;

import annotations.Component;
import com.google.inject.Inject;
import common.GuiceScoped;
import java.util.function.Consumer;

@Component("jdiv #jcont")
public class AnnoyingChat extends AbsPopup {

    private String closeButton = "#jivo_close_button";

    @Inject
    public AnnoyingChat(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public Consumer<String> closeChat = closeButton -> getElement(closeButton).click();
}
