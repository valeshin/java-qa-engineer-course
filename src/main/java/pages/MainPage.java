package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage<MainPage> {

    @Inject
    public MainPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
