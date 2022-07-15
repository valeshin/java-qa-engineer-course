package pages.lessons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.By;

public class CoursePage extends LessonPage {

    private String pageTitle = ".course-header2__title";
    private String startDate = "//div[./p[contains(text(), 'Начало занятий:')]]/parent::div/following-sibling::div/div/p";

    @Inject
    public CoursePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public boolean pageOpened() {
        return !guiceScoped.driver.findElements(By.cssSelector(pageTitle)).isEmpty();
    }

    public void pageTitleShouldBe(String expectedTile) {
        String actualTitle = guiceScoped.driver.findElement(By.cssSelector(pageTitle)).getText().trim();
        assertEquals(expectedTile, actualTitle, String.format("Вместо %s открылась страница %s", expectedTile, actualTitle));
    }

    public void startDateShouldBe(String expectedDate) {
        String actualDate = guiceScoped.driver.findElement(By.xpath(startDate)).getText().trim();
        assertTrue(
                actualDate.contains(expectedDate),
                String.format("Дата %s на карточке курса отличается от даты %s на странице курса", expectedDate, actualDate)
        );
    }
}
