package components.popups;

import common.CommonActions;
import org.openqa.selenium.WebDriver;

public abstract class AbsPopup extends CommonActions {

    public AbsPopup(WebDriver driver) {
        super(driver);
    }
}
