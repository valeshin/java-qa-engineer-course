package components.popups;

import com.google.inject.Inject;
import common.CommonActions;
import common.GuiceScoped;
import org.openqa.selenium.WebDriver;

public abstract class AbsPopup extends CommonActions {

    @Inject
    public AbsPopup(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
