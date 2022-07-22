package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage<MainPage> {

    @FindBy(css = "head link + title")
    private WebElement title;

    @Inject
    public MainPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @Override
    public void pageOpened() {
        assertEquals(
                "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям",
                title.getText(),
                "Главная страница не открыта"
        );
    }
}
