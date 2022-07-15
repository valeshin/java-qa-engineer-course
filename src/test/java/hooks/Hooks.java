package hooks;

import com.google.inject.Inject;
import common.GuiceScoped;
import io.cucumber.java.After;

public class Hooks {

    @Inject
    private GuiceScoped guiceScoped;

    @After
    public void afterScenario() {
        if (guiceScoped.driver != null) {
            if (!guiceScoped.browserName.getName().equals("firefox")) guiceScoped.driver.close();
            guiceScoped.driver.quit();
        }
    }
}
