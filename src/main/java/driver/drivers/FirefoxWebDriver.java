package driver.drivers;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import java.util.logging.Level;

public class FirefoxWebDriver implements IDriver {
    @Override
    public WebDriver newDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.setCapability(CapabilityType.VERSION, System.getProperty("browser.version", ""));
        firefoxOptions.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "false")));
        firefoxOptions.setHeadless(HEADLESS);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        firefoxOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        try {
            downloadLocalWebDriver(DriverManagerType.FIREFOX);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new FirefoxDriver(firefoxOptions);
    }
}
