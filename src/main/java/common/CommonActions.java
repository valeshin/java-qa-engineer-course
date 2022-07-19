package common;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.StandardWaiter;

public abstract class CommonActions {

    protected WebDriver driver;
    protected StandardWaiter standardWaiter;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        standardWaiter = new StandardWaiter(driver);
    }

    public void scrollToElement(WebElement element) {
        assertNotNull(element, "scrollIntoView невозможно выполнить, т.к. элемент отсутствует на странице");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Клик реализован отдельно, чтобы работала подсветка
    public void moveToElement(WebElement element) {
        scrollToElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
