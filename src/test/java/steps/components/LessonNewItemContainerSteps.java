package steps.components;

import com.google.inject.Inject;
import components.LessonsNewItemContainer;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LessonNewItemContainerSteps {

    @Inject
    public LessonsNewItemContainer lessonsNewItemContainer;

    @Тогда("Найти все курсы, начинающиеся {string} или позже, и вывести информацию о них консоль")
    public void findCoursesByDateOrAfter(String date) {
        List<WebElement> courses = lessonsNewItemContainer.getCoursesByDate(date);
        if (courses.isEmpty()) {
            courses = lessonsNewItemContainer.getCoursesAfterDate(date);
        }
        if (!courses.isEmpty()) {
            lessonsNewItemContainer.printCoursesInfo(courses);
        } else {
            System.out.println("Курсов, начинающихся " + date + " или позже, нет на странице");
        }

    }
}
