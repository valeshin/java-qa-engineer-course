package components;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.inject.Inject;
import common.GuiceScoped;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LessonPageFactory;
import pages.lessons.LessonPage;
import utils.DateUtil;
import utils.RegexUtil;
import java.util.List;
import java.util.stream.Collectors;

public class LessonsNewItemContainer extends AbstractComponent {

    private final String component = ".lessons__new-item-container";
    private final String itemTitle = ".lessons__new-item-title";
    private final String itemBottom = ".lessons__new-item-bottom";

    @FindBy(css = component)
    private List<WebElement> itemContainers;

    private WebElement itemContainer;

    @Inject
    public LessonsNewItemContainer(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public WebElement getCourseByName(String courseName) {
        itemContainer = itemContainers.stream()
                .filter(item -> item.findElement(By.cssSelector(itemTitle)).getText().contains(courseName))
                .findAny()
                .orElse(null);
        Assumptions.assumeTrue(itemContainer != null, "Курс с указанным наименованием не найден на странице");
        return itemContainer;
    }

    public List<WebElement> getCoursesByKeyword(String keyword) {
        return itemContainers.stream()
                .filter(item -> item.findElement(By.cssSelector(itemTitle)).getText().contains(keyword))
                .collect(Collectors.toList());
    }

    public String getCourseDate(WebElement itemContainer) {
        String bottomText = itemContainer.findElement(By.cssSelector(itemBottom)).getText();
        return RegexUtil.getSubString(bottomText, "\\d{1,2}\\s[а-яА-я]+");
    }

    public WebElement getEarliestCourse() {
        itemContainer = itemContainers.stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .reduce((item1, item2) -> !DateUtil.compareCourseDate(getCourseDate(item1), getCourseDate(item2)) ? item1 : item2)
                .orElse(null);
        return itemContainer;
    }

    public WebElement getLatestCourse() {
        itemContainer = itemContainers.stream()
                .filter(item -> !getCourseDate(item).isEmpty())
                .reduce((item1, item2) -> DateUtil.compareCourseDate(getCourseDate(item1), getCourseDate(item2)) ? item1 : item2)
                .orElse(null);
        return itemContainer;
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
