package utils;

import controllers.BaseController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ExplicitWaits extends BaseController {

    /*Select using WebElements*/

    /**
     * To Wait Until Element to be Clickable
     */
    public static void explicitWaitElementToBeClickable(WebElement element, int seconds) {
        WebDriverWait clickableWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public static void explicitWaitElementToBeSelected(WebElement element, int seconds) {
        WebDriverWait selectableWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Element has the text
     */
    public static void explicitWaitTextToBePresentInElement(WebElement element, int seconds, String text) {
        WebDriverWait textToBePresent = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    /**
     * To Wait Until Title contains the text
     */
    public static void explicitWaitTitleContains(WebElement element, int seconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public static void explicitWaitTitleIs(WebElement element, int seconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public static void explicitWaitVisibilityOfElement(WebElement element, int seconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public static void explicitWaitSelectionStateToBe(WebElement element, int seconds, boolean selected) {
        WebDriverWait elementIsSelected = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait Until Elements to be Visible
     */
    public static void explicitWaitVisibilityOfElements(List<WebElement> element, int seconds) {
        WebDriverWait elementsToBeVisible = new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds));
        elementsToBeVisible.until(ExpectedConditions.visibilityOfAllElements(element));
    }

}