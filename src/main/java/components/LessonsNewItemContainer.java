package components;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.opentest4j.TestAbortedException;
import pages.CoursePage;
import pages.LessonPage;
import pages.SpecializationPage;
import utils.DateUtil;
import utils.RegexUtil;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component(".lessons__new-item-container")
public class LessonsNewItemContainer extends AbstractComponent {

    private final String itemTitle = ".lessons__new-item-title";
    private final String itemBottom = ".lessons__new-item-bottom";

    public LessonsNewItemContainer(WebDriver driver) {
        super(driver);
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
                .reduce((item1, item2) -> !DateUtil.compareCourseDate(getCourseDate(item1), getCourseDate(item2)) ? item1 : item2)
                .orElse(null);
    }

    public WebElement getLatestCourse() {
        return getComponentEntities().stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .reduce((item1, item2) -> DateUtil.compareCourseDate(getCourseDate(item1), getCourseDate(item2)) ? item1 : item2)
                .orElse(null);
    }

    public LessonPage goToCourse(WebElement course) {
        moveToElement(course);
        course.click();

        CoursePage coursePage = new CoursePage(driver);
        return coursePage.pageOpened() ? coursePage : new SpecializationPage(driver);
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
