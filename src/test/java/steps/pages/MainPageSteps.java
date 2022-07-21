package steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import pages.MainPage;

public class MainPageSteps {

    @Inject
    public MainPage mainPage;

    @Пусть("Пользователь открывает главную страницу")
    public void open() {
        mainPage.open();
    }
}
