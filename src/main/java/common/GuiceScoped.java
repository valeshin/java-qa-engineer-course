package common;

import com.google.inject.AbstractModule;
import data.BrowserData;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@ScenarioScoped
public class GuiceScoped extends AbstractModule {

    public BrowserData browserName;
    public EventFiringWebDriver driver;
}
