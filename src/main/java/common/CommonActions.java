package common;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.StandardWaiter;

public abstract class CommonActions {

    protected GuiceScoped guiceScoped;
    protected StandardWaiter standardWaiter;

    public CommonActions(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        PageFactory.initElements(guiceScoped.driver, this);

        standardWaiter = new StandardWaiter(guiceScoped.driver);
    }

    public void scrollToElement(WebElement element) {
        assertNotNull(element, "scrollIntoView невозможно выполнить, т.к. элемент отсутствует на странице");
        ((JavascriptExecutor)guiceScoped.driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Клик реализован отдельно, чтобы работала подсветка
    public void moveToElement(WebElement element) {
        scrollToElement(element);
        Actions actions = new Actions(guiceScoped.driver);
        actions.moveToElement(element).build().perform();
    }
}
