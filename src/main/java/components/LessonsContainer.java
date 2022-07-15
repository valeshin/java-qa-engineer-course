package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonsContainer extends AbstractComponent {

    private final String component = ".container-lessons";

    @FindBy(css = component)
    private WebElement lessonsContainer;

    @Inject
    public LessonsContainer(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public LessonsNewItemContainer getLessonsNewItemContainer() {
        return new LessonsNewItemContainer(guiceScoped);
    }

    public LessonsContainer shouldBeVisible() {
        assertTrue(standardWaiter.waitForElementVisible(lessonsContainer), "Список курсов не отображается");

        return this;
    }
}
