package pageObjects.initializePageObjects;

import controllers.BaseController;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObjects.pages.toolsqa.elements.TextBoxPage;

public class CommonPageInitializer extends BaseController {

    @Step("Open Tools QA Landing Page")
    public static TextBoxPage toolsLandingPage() {
        openApplication();
        return PageFactory.initElements(getWebDriver(), TextBoxPage.class);
    }
}
