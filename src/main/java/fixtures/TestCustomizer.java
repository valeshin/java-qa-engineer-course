package fixtures;

import driver.DriverFactory;
import listeners.MouseListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.net.MalformedURLException;
import java.util.Locale;

public abstract class TestCustomizer {

    protected EventFiringWebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = new DriverFactory().getDriver();
        Dimension dimension = new Dimension(1280, 1080);
        if (driver.getCapabilities().getVersion().contains("mobile")) {
            dimension = new Dimension(390, 844);
        }
        driver.manage().window().setSize(dimension);
        // driver.register(new MouseListener());
    }

    @AfterEach
    public void tearDown() {
        if (!System.getProperty("browser").toLowerCase(Locale.ROOT).equals("firefox")) driver.close();
        driver.quit();
    }
}
