package steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import pages.PrepCourseListPage;

public class PrepCourseListPageSteps {

    @Inject
    public PrepCourseListPage prepCourseListPage;

    @Пусть("Пользователь переходит в раздел предварительных курсов")
    public void open() {
        prepCourseListPage.open();
    }
}
