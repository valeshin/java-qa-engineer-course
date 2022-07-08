package components;

import common.CommonActions;
import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent extends CommonActions {

    //private final String parentSelector;

    public AbstractComponent(WebDriver driver) {
        super(driver);
    }

    //public AbstractComponent() {
    //    this.parentSelector = "";
    //}

    //public AbstractComponent(String parentSelector) {
    //    this.parentSelector = parentSelector;
    //}

    //public final String getFullSelector(String selector) {
    //    return this.parentSelector + " " + selector;
    //}

    //public abstract String getComponentSelector();
}
