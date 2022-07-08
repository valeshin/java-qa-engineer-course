package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardWaiter implements IWaiter {

    private WebDriver driver;

    public StandardWaiter(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, IMPLICITLY_WAIT_SECOND);
        try {
            webDriverWait.until(condition);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean waitForElementVisible(WebElement element) {
        return waitForCondition(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForElementNotVisible(WebElement element) {
        return waitForCondition(ExpectedConditions.invisibilityOf(element));
    }
}
