package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecializationPage extends LessonPage {

    private String pageTitle = "head title";
    private String startDate = "//div[contains(@field, 'tn_text_1613568838724') and contains(text(), 'Старт')]";

    public SpecializationPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageOpened() {
        return !driver.findElements(By.cssSelector(pageTitle)).isEmpty();
    }

    public void pageTitleShouldBe(String expectedTile) {
        String actualTitle = driver.getTitle().trim();
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
