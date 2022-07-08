package mainpage;

import components.HeaderMenu;
import components.LessonsContainer;
import components.LessonsNewItemContainer;
import fixtures.TestCustomizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class MainCoursesTest extends TestCustomizer {

    @Test
    public void clickHighlightDemo() {
        new MainPage(driver).open();

        new HeaderMenu(driver).clickAllDropdownItems();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Специализация Fullstack Developer", "JavaScript QA Engineer", "Специализация Machine Learning"})
    public void checkGoToCourseNamePage(String courseName) {
        new MainPage(driver).open();

        new LessonsContainer(driver)
                .shouldBeVisible()
                .getLessonsNewItemContainer()
                .goToCourseByName(courseName)
                .pageTitleShouldBe(courseName);
    }

    @Test
    public void checkGoToLatestCourse() {
        new MainPage(driver).open();

        LessonsNewItemContainer lessonsItemContainer = new LessonsContainer(driver)
                .shouldBeVisible()
                .getLessonsNewItemContainer();

        WebElement latestCourse = lessonsItemContainer.getLatestCourse();
        String courseDate = lessonsItemContainer.getCourseDate(latestCourse);

        lessonsItemContainer.goToCourse(latestCourse).startDateShouldBe(courseDate);
    }

    @Test
    public void checkGoToEarlierCourse() {
        new MainPage(driver).open();

        LessonsNewItemContainer lessonsItemContainer = new LessonsContainer(driver)
                .shouldBeVisible()
                .getLessonsNewItemContainer();

        WebElement latestCourse = lessonsItemContainer.getEarliestCourse();
        String courseDate = lessonsItemContainer.getCourseDate(latestCourse);

        lessonsItemContainer.goToCourse(latestCourse).startDateShouldBe(courseDate);
    }
}
