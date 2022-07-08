package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends LessonPage {

    private String pageTitle = ".course-header2__title";
    private String startDate = "//div[./p[contains(text(), 'Начало занятий:')]]/parent::div/following-sibling::div/div/p";

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public boolean pageOpened() {
        return !driver.findElements(By.cssSelector(pageTitle)).isEmpty();
    }

    public void pageTitleShouldBe(String expectedTile) {
        String actualTitle = driver.findElement(By.cssSelector(pageTitle)).getText().trim();
        assertEquals(expectedTile, actualTitle, String.format("Вместо %s открылась страница %s", expectedTile, actualTitle));
    }

    public void startDateShouldBe(String expectedDate) {
        String actualDate = driver.findElement(By.xpath(startDate)).getText().trim();
        assertTrue(
                actualDate.contains(expectedDate),
                String.format("Дата %s на карточке курса отличается от даты %s на странице курса", expectedDate, actualDate)
        );
    }
}
