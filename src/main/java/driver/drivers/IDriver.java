package driver.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

public interface IDriver {

    boolean HEADLESS = Boolean.valueOf(System.getProperty("webdriver.headless"));
    boolean REMOTE = Boolean.valueOf(System.getProperty("webdriver.remote"));
    String REMOTE_URL = System.getProperty("webdriver.remote.url");

    WebDriver newDriver() throws MalformedURLException;

    default void downloadLocalWebDriver(DriverManagerType driverType) {
        String browserVersion = System.getProperty("browser.version", "");

        if (!browserVersion.isEmpty()) {
            WebDriverManager.getInstance(driverType).driverVersion(browserVersion).setup();
        } else {
            WebDriverManager.getInstance(driverType).setup();
        }
    }
}
