package driver;

import com.google.inject.Inject;
import common.GuiceScoped;
import driver.drivers.ChromeWebDriver;
import driver.drivers.FirefoxWebDriver;
import driver.drivers.OperaWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.Locale;

public class DriverFactory {

    public GuiceScoped guiceScoped;

    @Inject
    public DriverFactory(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    public EventFiringWebDriver getDriver() {
        switch (guiceScoped.browserName) {
            case CHROME: return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
            case FIREFOX: return new EventFiringWebDriver(new FirefoxWebDriver().newDriver());
            case OPERA: return new EventFiringWebDriver(new OperaWebDriver().newDriver());
            default: return null;
        }
    }
}
