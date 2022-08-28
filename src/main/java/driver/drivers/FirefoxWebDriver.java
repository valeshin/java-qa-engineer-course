package driver.drivers;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.logging.Level;

public class FirefoxWebDriver implements IDriver {
    @Override
    public WebDriver newDriver() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("browser.version", ""));
        firefoxOptions.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "true")));
        firefoxOptions.setHeadless(HEADLESS);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        firefoxOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        if (REMOTE) return new RemoteWebDriver(URI.create(REMOTE_URL).toURL(), firefoxOptions);

        try {
            downloadLocalWebDriver(DriverManagerType.FIREFOX);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new FirefoxDriver(firefoxOptions);
    }
}
