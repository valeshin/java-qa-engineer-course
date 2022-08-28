package driver.drivers;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.logging.Level;

public class OperaWebDriver implements IDriver {
    @Override
    public WebDriver newDriver() throws MalformedURLException {
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.addArguments("--no-sandbox");
        operaOptions.addArguments("--no-first-run");
        operaOptions.addArguments("--enable-extensions");
        operaOptions.addArguments("--homepage=about:blank");
        operaOptions.addArguments("--ignore-certificate-errors");
        operaOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        operaOptions.setCapability(CapabilityType.BROWSER_NAME, "opera");
        operaOptions.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("browser.version", ""));
        operaOptions.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "true")));

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        operaOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        if (REMOTE) return new RemoteWebDriver(URI.create(REMOTE_URL).toURL(), operaOptions);

        try {
            downloadLocalWebDriver(DriverManagerType.OPERA);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new OperaDriver(operaOptions);
    }
}
