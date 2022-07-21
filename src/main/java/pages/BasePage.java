package pages;

import annotations.PagePath;
import annotations.navigation.UrlTemplate;
import com.google.inject.Inject;
import common.CommonActions;
import common.GuiceScoped;
import exceptions.TemplateDataException;

public abstract class BasePage<T> extends CommonActions {

    @Inject
    public BasePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    private String getBaseUrl() {
        return System.getProperty("webdriver.base.url");
    }

    private String getPath() {
        PagePath pagePath = getClass().getAnnotation(PagePath.class);
        if (pagePath != null) {
            return pagePath.value().replaceAll("/+$", "");
        }

        return "";
    }

    private String getPageUrlTemplate(String name) {
        UrlTemplate urlTemplate = getClass().getAnnotation(UrlTemplate.class);
        if (urlTemplate != null) {
            if (urlTemplate.name().equals(name)) {
                return urlTemplate.template();
            }
        }
        return "";
    }

    public String getCurrentUrl() {
        return guiceScoped.driver.getCurrentUrl();
    }

    public T open() {
        guiceScoped.driver.get(getBaseUrl() + getPath());

        return (T) this;
    }

    public T open(String name, String... values) throws TemplateDataException {
        if(values.length == 0) {
            throw new TemplateDataException(name);
        }
        String template = getPageUrlTemplate(name);
        String pathFromTemplate = "";
        for(int i =0; i < values.length; i++) {
            pathFromTemplate = template.replace(String.format("{%s}", i + 1), values[i]);
        }

        String hostname = getBaseUrl().replace("/+$", "");

        if(!getPath().isEmpty()) {
            guiceScoped.driver.get(hostname + getPath() + "/" + pathFromTemplate);
        } else {
            guiceScoped.driver.get(hostname + "/" + pathFromTemplate);
        }

        return (T) this;
    }
}
