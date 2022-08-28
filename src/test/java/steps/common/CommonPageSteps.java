package steps.common;

import com.google.inject.Inject;
import common.GuiceScoped;
import data.BrowserData;
import driver.DriverFactory;
import io.cucumber.java.ru.Пусть;
import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.util.Locale;

public class CommonPageSteps {

    @Inject
    private GuiceScoped guiceScoped;
    @Inject
    private DriverFactory driverFactory;

    @Пусть("Пользователь открывает браузер {string}")
    public void initBrowser(String browserName) throws MalformedURLException {
        guiceScoped.browserName = BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT));
        guiceScoped.driver = driverFactory.getDriver();
        Dimension dimension = new Dimension(1280, 1080);
        if (guiceScoped.driver.getCapabilities().getVersion().contains("mobile")) {
            dimension = new Dimension(390, 844);
        }
        guiceScoped.driver.manage().window().setSize(dimension);
    }
}
