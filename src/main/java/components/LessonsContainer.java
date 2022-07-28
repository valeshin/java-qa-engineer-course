package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.Component;
import exceptions.ComponentLocatorException;
import org.openqa.selenium.WebDriver;

@Component(".container-lessons")
public class LessonsContainer extends AbstractComponent {

    public LessonsContainer(WebDriver driver) {
        super(driver);
    }

    public LessonsNewItemContainer getLessonsNewItemContainer() {
        return new LessonsNewItemContainer(driver);
    }

    public LessonsContainer shouldBeVisible() {
        try {
            assertTrue(standardWaiter.waitForElementVisible(getComponentEntity()), "Список курсов не отображается");
        } catch (ComponentLocatorException e) {
            System.out.println(e.getMessage());
        }

        return this;
    }
}
