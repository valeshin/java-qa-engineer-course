package driver;

import driver.drivers.ChromeWebDriver;
import driver.drivers.FirefoxWebDriver;
import driver.drivers.OperaWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.net.MalformedURLException;
import java.util.Locale;

public class DriverFactory {

    private String browserType = System.getProperty("browser").toLowerCase(Locale.ROOT);

    public EventFiringWebDriver getDriver() throws MalformedURLException {
        switch (this.browserType) {
            case "chrome": return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
            case "firefox": return new EventFiringWebDriver(new FirefoxWebDriver().newDriver());
            case "opera": return new EventFiringWebDriver(new OperaWebDriver().newDriver());
            default: return null;
        }
    }
}
