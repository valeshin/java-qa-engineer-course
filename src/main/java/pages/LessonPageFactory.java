package pages;

import com.google.inject.Inject;
import common.GuiceScoped;
import pages.lessons.CoursePage;
import pages.lessons.LessonPage;
import pages.lessons.SpecializationPage;

public class LessonPageFactory {

    public GuiceScoped guiceScoped;

    @Inject
    public LessonPageFactory(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    public LessonPage getPage() {
        if (guiceScoped.driver.getCurrentUrl().contains("specializ")) {
            return new SpecializationPage(guiceScoped);
        } else {
            return new CoursePage(guiceScoped);
        }
    }
}
