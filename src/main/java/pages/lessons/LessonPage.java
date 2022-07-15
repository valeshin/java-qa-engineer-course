package pages.lessons;

import com.google.inject.Inject;
import common.GuiceScoped;
import pages.BasePage;

public abstract class LessonPage extends BasePage<LessonPage> {

    @Inject
    public LessonPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public abstract boolean pageOpened();

    public abstract void pageTitleShouldBe(String expectedTile);

    public abstract void startDateShouldBe(String expectedDate);
}
