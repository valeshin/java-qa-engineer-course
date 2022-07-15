package steps.pages;

import com.google.inject.Inject;
import components.LessonsContainer;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import pages.MainPage;

public class MainPageSteps {

    @Inject
    public MainPage mainPage;
    @Inject
    public LessonsContainer lessonsContainer;

    @Пусть("Пользователь открывает главную страницу")
    public void open() {
        mainPage.open();
    }

    @Если("Открыть страницу курса {string}")
    public void goToCourseName(String courseName) {
        lessonsContainer.shouldBeVisible().getLessonsNewItemContainer().goToCourseByName(courseName);
    }
}
