package steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Тогда;
import pages.lessons.PrepCoursePage;

public class PrepCoursePageSteps {

    @Inject
    public PrepCoursePage prepCoursePage;

    @Тогда("Страница курса открыта")
    public void pageShouldBeOpened() {
        prepCoursePage.pageOpened();
    }
}
