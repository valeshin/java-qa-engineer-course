package pages;

import org.openqa.selenium.WebDriver;

public abstract class LessonPage extends BasePage<LessonPage> {

    public LessonPage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean pageOpened();

    public abstract void pageTitleShouldBe(String expectedTile);

    public abstract void startDateShouldBe(String expectedDate);
}
