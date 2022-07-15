package components;

import static org.junit.jupiter.api.Assertions.assertTrue;

import common.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HeaderMenu extends AbstractComponent {

    private final String component = ".header2-menu_main";

    @FindBy(css = component)
    private WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]/div/div[./p[contains(text(), 'Курсы')]]")
    private WebElement mainMenuItemCourses;

    @FindBy(css = component + " .header2-menu__item_dropdown")
    private List<WebElement> dropdownItems;

    public HeaderMenu(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void clickMenuItemCourses() {
        assertTrue(standardWaiter.waitForElementVisible(mainMenuItemCourses), "Нет такого пункта меню");
        mainMenuItemCourses.click();
    }

    public void clickAllDropdownItems() {
        assertTrue(standardWaiter.waitForElementVisible(mainMenu), "Главное меню отсутствует на странице");
        dropdownItems.stream().forEach(WebElement::click);
    }
}
