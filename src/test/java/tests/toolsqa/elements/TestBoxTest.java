package tests.toolsqa.elements;

import controllers.CustomDataProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.CommonPageInitializer;

@Epic("Elements Tests")
@Feature("TestBox Tests")
public class TextBoxTest extends CommonPageInitializer {
    @Description("Test Description: Login test with different combinations of username and password")
    //@Parameters({ "userName", "userEmail", "currentAddress", "permanentAddress" })
    @Severity(SeverityLevel.CRITICAL)
    @Test(
            dataProvider = "customDataProvider",
            dataProviderClass = CustomDataProvider.class,
            attributes = {@CustomAttribute(name = "scriptDetails", values = {"TeamName", "ToolsQAProduct", "Smoke", "Critical"})},
            description = "Validate the behaviour of different combinations of text box details",
            groups = {"sanity", "smoke"})
    public void testToolsQAElementsTextBox(@Optional("bikarsha") String userName,
                                           @Optional("bik@gmail.com") String userEmail,
                                           @Optional("currentAddress") String currentAddress,
                                           @Optional("permanentAddress") String permanentAddress) {

        Assert.assertEquals(toolsLandingPage().verifyToolsQALandingPageTitle(), "ToolsQA");
        toolsLandingPage()
                .clickOnElementsNavigationLink()
                .clickOnTextBoxLink()
                .setFormFullName(userName)
                .setFormEmailId(userEmail)
                .setFormCurrentAddress(currentAddress)
                .setFormPermanentAddress(permanentAddress)
                .clickOnSubmitButton();
        //Assert.assertTrue(toolsLandingPage().verifyElementsVisibility());
    }
}
