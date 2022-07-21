package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.Component;
import com.google.inject.Inject;
import common.GuiceScoped;
import exceptions.ComponentLocatorException;

@Component(".container-lessons")
public class LessonsContainer extends AbstractComponent {

    @Inject
    public LessonsContainer(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public LessonsNewItemContainer getLessonsNewItemContainer() {
        return new LessonsNewItemContainer(guiceScoped);
    }

    public LessonsContainer shouldBeVisible() throws ComponentLocatorException {
        assertTrue(standardWaiter.waitForElementVisible(getComponentEntity()), "Список курсов не отображается");

        return this;
    }
}
