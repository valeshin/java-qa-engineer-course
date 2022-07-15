package pages;

import annotations.UrlPath;
import com.google.inject.Inject;
import common.CommonActions;
import common.GuiceScoped;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BasePage<T> extends CommonActions {

    @Inject
    public BasePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
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

    public String getCurrentUrl() {
        return guiceScoped.driver.getCurrentUrl();
    }

    public T open() {
        guiceScoped.driver.get(getBaseUrl() + getUrlPath());

        return (T) this;
    }
}
