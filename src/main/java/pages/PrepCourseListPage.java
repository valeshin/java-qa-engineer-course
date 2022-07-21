package pages;

import annotations.PagePath;
import annotations.navigation.UrlTemplate;
import com.google.inject.Inject;
import common.GuiceScoped;

@PagePath("/online")
public class PrepCourseListPage extends BasePage<PrepCourseListPage> {

    @Inject
    public PrepCourseListPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
