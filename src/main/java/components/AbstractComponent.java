package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.Component;
import common.CommonActions;
import exceptions.ComponentLocatorException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class AbstractComponent extends CommonActions {

    protected String componentLocator;

    public AbstractComponent(WebDriver driver) {
        super(driver);
        try {
            validateComponent();
        } catch (ComponentLocatorException e) {
            throw new RuntimeException(e);
        }
    }

    private By getComponentLocator() throws ComponentLocatorException {
        Component component = getClass().getAnnotation(Component.class);
        if (component != null) {
            componentLocator = component.value();
            return locatorAnalyzer(component.value());
        }

        throw new ComponentLocatorException(getClass().getName());
    }

    protected WebElement getElement(String elementLocator) {
        try {
            return getComponentEntity().findElement(locatorAnalyzer(elementLocator));
        } catch (ComponentLocatorException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected List<WebElement> getElements(String elementLocator) {
        try {
            return getComponentEntity().findElements(locatorAnalyzer(elementLocator));
        } catch (ComponentLocatorException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getComponentEntity() throws ComponentLocatorException {
        return driver.findElement(getComponentLocator());
    }

    public List<WebElement> getComponentEntities() {
        try {
            return driver.findElements(getComponentLocator());
        } catch (ComponentLocatorException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void validateComponent() throws ComponentLocatorException {
        assertTrue(
                standardWaiter.waitForElementVisible(getComponentEntity()),
                "Компонент " + getClass().getName() + " отсутствует на странице"
        );
    }

    private By locatorAnalyzer(String locator) {
        if (locator.startsWith("/") || locator.startsWith("./")) {
            return By.xpath(locator);
        }
        return By.cssSelector(locator);
    }
}
