package steps.components;

import com.google.inject.Inject;
import components.LessonsContainer;
import exceptions.ComponentLocatorException;
import io.cucumber.java.ru.Если;

public class LessonsContainerSteps {

    @Inject
    public LessonsContainer lessonsContainer;

    @Если("Открыть страницу курса {string}")
    public void goToCourseName(String courseName) throws ComponentLocatorException {
        lessonsContainer.shouldBeVisible().getLessonsNewItemContainer().goToCourseByName(courseName);
    }
}
