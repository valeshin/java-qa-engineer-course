package steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Тогда;
import pages.LessonPageFactory;
import pages.lessons.LessonPage;

public class LessonPageSteps {

    @Inject
    public LessonPageFactory lessonPageFactory;

    @Тогда("Страница курса {string} открыта")
    public void lessonPageShouldBeOpened(String courseName) {
        lessonPageFactory.getPage().pageTitleShouldBe(courseName);
    }
}
