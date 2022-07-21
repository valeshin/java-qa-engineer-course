package pages;

import annotations.PagePath;
import annotations.navigation.UrlTemplate;
import com.google.inject.Inject;
import common.GuiceScoped;

@UrlTemplate(name = "online", template = "{1}")
@PagePath("/online")
public class PrepCoursePage extends BasePage<PrepCourseListPage> {

    @Inject
    public PrepCoursePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }
}
