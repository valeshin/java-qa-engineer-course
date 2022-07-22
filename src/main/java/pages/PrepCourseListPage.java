package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.PagePath;
import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PagePath("/online")
public class PrepCourseListPage extends BasePage<PrepCourseListPage> {

    @FindBy(css = "head title")
    private WebElement title;

    @Inject
    public PrepCourseListPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    @Override
    public void pageOpened() {
        assertEquals(
                "Подготовительные онлайн-курсы, обучение в OTUS c нуля, уроки для начинающих",
                title.getText(),
                "Раздел подготовительных курсов не открыт"
        );
    }


}
