package components.popups;

import annotations.Component;
import com.google.inject.Inject;
import common.GuiceScoped;

@Component("div[class=\"cookies\"]")
public class CookiePopup extends AbsPopup {

    private String acceptButton = "button";

    @Inject
    public CookiePopup(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void acceptCookie() {
        getElement(acceptButton).click();
    }
}
