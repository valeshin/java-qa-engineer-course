package components;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import annotations.Component;
import com.google.inject.Inject;
import common.GuiceScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.opentest4j.TestAbortedException;
import pages.LessonPageFactory;
import pages.lessons.LessonPage;
import utils.DateUtil;
import utils.RegexUtil;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component(".lessons__new-item-container")
public class LessonsNewItemContainer extends AbstractComponent {

    private final String itemTitle = ".lessons__new-item-title";
    private final String itemBottom = ".lessons__new-item-bottom";

    @Inject
    public LessonsNewItemContainer(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public WebElement getCourseByName(String courseName) {
        WebElement itemContainer = getComponentEntities().stream()
                .filter(item -> item.findElement(By.cssSelector(itemTitle)).getText().contains(courseName))
                .findAny()
                .orElse(null);
        try {
            assumeTrue(itemContainer != null, String.format("Test skipped: Курс %s не найден на странице", courseName));
        } catch (TestAbortedException ex) {
            Logger.getLogger(LessonsNewItemContainer.class.getName()).info(ex.getMessage());
            throw ex;
        }
        return itemContainer;
    }

    public List<WebElement> getCoursesByDate(String date) {
        return getComponentEntities().stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .filter(item -> DateUtil.compareCourseDate(getCourseDate(item), date) == 0)
                .collect(Collectors.toList());
    }

    public List<WebElement> getCoursesAfterDate(String date) {
        return getComponentEntities().stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .filter(item -> DateUtil.compareCourseDate(getCourseDate(item), date) > 0)
                .collect(Collectors.toList());
    }

    public void printCoursesInfo(List<WebElement> itemsList) {
        itemsList.forEach(item -> System.out.println(
                String.format("Курс '%s'. Начало курса: %s", item.findElement(By.cssSelector(itemTitle)).getText(), getCourseDate(item)))
        );
    }

    public List<WebElement> getCoursesByKeyword(String keyword) {
        return getComponentEntities().stream()
                .filter(item -> item.findElement(By.cssSelector(itemTitle)).getText().contains(keyword))
                .collect(Collectors.toList());
    }

    public String getCourseDate(WebElement itemContainer) {
        String bottomText = itemContainer.findElement(By.cssSelector(itemBottom)).getText();
        return RegexUtil.getSubString(bottomText, "\\d{1,2}\\s[а-яА-я]+");
    }

    public WebElement getEarliestCourse() {
        return getComponentEntities().stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .reduce((item1, item2) -> DateUtil.compareCourseDate(getCourseDate(item1), getCourseDate(item2)) <= 0 ? item1 : item2)
                .orElse(null);
    }

    public WebElement getLatestCourse() {
        return getComponentEntities().stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .reduce((item1, item2) -> DateUtil.compareCourseDate(getCourseDate(item1), getCourseDate(item2)) >= 0 ? item1 : item2)
                .orElse(null);
    }

    public LessonPage goToCourse(WebElement course) {
        moveToElement(course);
        course.click();

        return new LessonPageFactory(guiceScoped).getPage();
    }

    public LessonPage goToCourseByName(String courseName) {
        WebElement course = getCourseByName(courseName);
        return goToCourse(course);
    }

    public LessonPage goToEarlierCourse() {
        WebElement earlierCourse = getLatestCourse();
        return goToCourse(earlierCourse);
    }

    public LessonPage goToLatestCourse() {
        WebElement latestCourse = getLatestCourse();
        return goToCourse(latestCourse);
    }
}
