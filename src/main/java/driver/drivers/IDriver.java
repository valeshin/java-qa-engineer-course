package driver.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public interface IDriver {

    boolean HEADLESS = Boolean.valueOf(System.getProperty("webdriver.headless"));

    WebDriver newDriver();

    default void downloadLocalWebDriver(DriverManagerType driverType) {
        String browserVersion = System.getProperty("browser.version", "");

        if (!browserVersion.isEmpty()) {
            WebDriverManager.getInstance(driverType).driverVersion(browserVersion).setup();
        } else {
            WebDriverManager.getInstance(driverType).setup();
        }
    }
}
