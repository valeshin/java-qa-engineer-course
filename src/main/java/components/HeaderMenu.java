package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.Component;
import exceptions.ComponentLocatorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Component("//div[contains(@class, 'header2-menu_main')]")
public class HeaderMenu extends AbstractComponent {

    private final String mainMenuItem = ".//div[./p[contains(text(), '%s')]]";
    private final String mainMenuItemCourses = String.format(mainMenuItem, "Курсы");
    private final String dropdownItems = ".//div[contains(@class, 'header2-menu__item_dropdown')]";

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void clickMenuItemCourses() {
        assertTrue(standardWaiter.waitForElementVisible(getElement(mainMenuItemCourses)), "Нет такого пункта меню");
        getElement(mainMenuItemCourses).click();
    }

    public void clickAllDropdownItems() throws ComponentLocatorException {
        assertTrue(standardWaiter.waitForElementVisible(getComponentEntity()), "Главное меню отсутствует на странице");
        getElements(dropdownItems).forEach(WebElement::click);
    }
}
