package steps.common;

import com.google.inject.Inject;
import common.GuiceScoped;
import data.BrowserData;
import driver.DriverFactory;
import io.cucumber.java.ru.Пусть;
import org.openqa.selenium.Dimension;
import java.util.Locale;

public class CommonPageSteps {

    @Inject
    private GuiceScoped guiceScoped;
    @Inject
    private DriverFactory driverFactory;

    @Пусть("Пользователь открывает браузер {string}")
    public void initBrowser(String browserName) {
        guiceScoped.browserName = BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT));
        guiceScoped.driver = driverFactory.getDriver();
        guiceScoped.driver.manage().window().setSize(new Dimension(1280, 1080));
    }
}
