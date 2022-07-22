package pages.lessons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.PagePath;
import annotations.navigation.UrlTemplate;
import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlTemplate(name = "online", template = "{1}")
@PagePath("/online")
public class PrepCoursePage extends LessonPage {

    @FindBy(css = ".preparatory-intro__tooltip-text")
    private WebElement preparatoryIntro;

    @Inject
    public PrepCoursePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @Override
    public void pageOpened() {
        assertTrue(standardWaiter.waitForElementVisible(preparatoryIntro), "Страница не открылась");
        assertEquals("Подготовительный онлайн курс", preparatoryIntro.getText(), "Некорректный заголовок интро");
    }

    @Override
    public void pageTitleShouldBe(String expectedTile) {

    }

    @Override
    public void startDateShouldBe(String expectedDate) {

    }
}
