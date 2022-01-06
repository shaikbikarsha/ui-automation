package pageObjects.pages.toolsqa.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.CommonPageInitializer;
import utils.AllureAttachments;

public class TextBoxPage extends CommonPageInitializer {

    @FindBy(xpath = "//*[@class='card-body']/*[text()='Elements']")
    private WebElement elementsNavigationLink;

    @FindBy(xpath = "//*[text()='Text Box']/parent::li")
    private WebElement textBoxLink;

    @FindBy(id = "userName")
    private WebElement formFullNameField;

    @FindBy(id = "userEmail")
    private WebElement formEmailId;

    @FindBy(xpath = "//*[@id='currentAddress']")
    private WebElement formCurrentAddressTextArea;

    @FindBy(css = "#permanentAddress")
    private WebElement formPermanentAddressTextArea;

    @FindBy(css = "#submit")
    private WebElement submitButton;

    @FindBy(css = "#output")
    private WebElement outputBlock;

    @Step("Verify the Page Title of the ToolsQA Landing Page")
    public String verifyToolsQALandingPageTitle() {
        return getUrlTitle();
    }

    @Step("Click on elements link for method: {0}.")
    public TextBoxPage clickOnElementsNavigationLink() {
        AllureAttachments.saveWebElement(getWebDriver(),elementsNavigationLink);
        elementsNavigationLink.click();
        return this;
    }

    @Step("Click on text box link for method: {0}.")
    public TextBoxPage clickOnTextBoxLink() {
        AllureAttachments.saveWebElement(getWebDriver(),textBoxLink);
        textBoxLink.click();
        return this;
    }

    @Step("Enter full name: {0} for method: {method} step.")
    public TextBoxPage setFormFullName(String fullName) {
        formFullNameField.sendKeys(fullName);
        return this;
    }

    @Step("Enter email : {0} for method: {method} step.")
    public TextBoxPage setFormEmailId(String emailId) {
        formEmailId.sendKeys(emailId);
        return this;
    }

    @Step("Enter current address : {0} for method: {method} step.")
    public TextBoxPage setFormCurrentAddress(String currentAddress) {
        formCurrentAddressTextArea.sendKeys(currentAddress);
        return this;
    }

    @Step("Enter permanent address : {0} for method: {method} step.")
    public TextBoxPage setFormPermanentAddress(String permanentAddress) {
        formPermanentAddressTextArea.sendKeys(permanentAddress);
        return this;
    }

    @Step("Click on submit button for method: {method} step.")
    public TextBoxPage clickOnSubmitButton() {
        scrollDown();
        submitButton.click();
        return this;
    }

    @Step("Verify visibility of output for method: {method} step.")
    public boolean verifyElementsVisibility() {
//        scrollDown();
        return outputBlock.isEnabled();
    }
}
