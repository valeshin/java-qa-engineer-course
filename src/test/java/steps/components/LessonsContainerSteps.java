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

    @Если("Открыть страницу самого дорогого курса и вывести информацию о нем в консоль")
    public void openTheMostExpensivePrepCourse() throws ComponentLocatorException {
        lessonsContainer.shouldBeVisible().getLessonsNewItemContainer().goToTheMostExpensivePrepCourse();
    }

    @Если("Открыть страницу самого дешевого курса и вывести информацию о нем в консоль")
    public void openTheMostCheapPrepCourse() throws ComponentLocatorException {
        lessonsContainer.shouldBeVisible().getLessonsNewItemContainer().goToTheMostCheapPrepCourse();
    }

    @Если("Список курсов отображается на странице")
    public void lessonsContainerShouldBeVisible() throws ComponentLocatorException {
        lessonsContainer.shouldBeVisible();
    }
}
