package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonsContainer extends AbstractComponent {

    private final String component = ".container-lessons";

    @FindBy(css = component)
    private WebElement lessonsContainer;

    public LessonsContainer(WebDriver driver) {
        super(driver);
    }

    public LessonsNewItemContainer getLessonsNewItemContainer() {
        return new LessonsNewItemContainer(driver);
    }

    public LessonsContainer shouldBeVisible() {
        assertTrue(standardWaiter.waitForElementVisible(lessonsContainer), "Список курсов не отображается");

        return this;
    }
}
