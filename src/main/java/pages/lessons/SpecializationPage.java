package pages.lessons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.By;

public class SpecializationPage extends LessonPage {

    private String pageTitle = "head title";
    private String startDate = "//div[contains(@field, 'tn_text_1613568838724') and contains(text(), 'Старт')]";

    @Inject
    public SpecializationPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public boolean pageOpened() {
        return !guiceScoped.driver.findElements(By.cssSelector(pageTitle)).isEmpty();
    }

    public void pageTitleShouldBe(String expectedTile) {
        String actualTitle = guiceScoped.driver.getTitle().trim();
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
