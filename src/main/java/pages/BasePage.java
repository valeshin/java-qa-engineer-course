package pages;

import annotations.UrlPath;
import common.CommonActions;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BasePage<T> extends CommonActions {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private String getBaseUrl() {
        return System.getProperty("webdriver.base.url");
    }

    private String getUrlPath() {
        UrlPath urlAnnotation = getClass().getAnnotation(UrlPath.class);
        if (urlAnnotation != null) {
            return urlAnnotation.value();
        }

        return "";
    }

    public T open() {
        driver.get(getBaseUrl() + getUrlPath());

        return (T) page(getClass());
    }

    public <T> T page(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(WebDriver.class);

            return convertInstanceOfObject(constructor.newInstance(driver), clazz);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException e) {
            return null;
        }
    }
}
