package listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import java.util.logging.Logger;

public class MouseListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue';", element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px solid blue';", element);
        } catch (StaleElementReferenceException ex) {
            Logger.getLogger(MouseListener.class.getName()).info(
                    String.format("afterClickOn не выполнен. т.к. элемент исчез со страницы")
            );
        }
    }
}
