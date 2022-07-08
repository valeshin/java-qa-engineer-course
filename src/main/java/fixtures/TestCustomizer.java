package fixtures;

import driver.DriverFactory;
import listeners.MouseListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.Locale;

public abstract class TestCustomizer {

    protected EventFiringWebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new DriverFactory().getDriver();
        driver.register(new MouseListener());
    }

    @AfterEach
    public void tearDown() {
        if (!System.getProperty("browser").toLowerCase(Locale.ROOT).equals("firefox")) driver.close();
        driver.quit();
    }
}
