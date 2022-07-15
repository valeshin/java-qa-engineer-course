package components;

import com.google.inject.Inject;
import common.CommonActions;
import common.GuiceScoped;

public abstract class AbstractComponent extends CommonActions {

    //private final String parentSelector;

    @Inject
    public AbstractComponent(GuiceScoped guiceScoped) {
        super(guiceScoped);
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
