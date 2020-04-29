package MRCS.Utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author smartData
 * <h1>WaitTool</h1>
 * <p>Purpose: This class is used for manage waits</p>
 * It is used to handle implecity and explecity wait
 */

public class WaitTool {

    public static WebElement waitForElementPresentAndDisplay(final By by) throws Exception {
        WebElement element = null;
        try {

            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (Common.DEFAULT_WAIT / 1000));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element; // return the element
        } catch (Exception e) {
            Log.error(by.toString() + "-> element is not present and displayed");
            Log.error(e.getMessage());
            throw new Exception(by.toString() + "-> element is not present and displayed -> " + e.getMessage());
        }

    }

    public static List<WebElement> waitForElementsPresentAndDisplay(final By by) throws Exception {
        List<WebElement> element = null;
        try {
            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (Common.DEFAULT_WAIT / 1000));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return element; // return the element
        } catch (Exception e) {
            Log.error(by.toString() + "-> elements is not present and displayed");
            Log.error(e.getMessage());
            throw new Exception(by.toString() + "-> element is not present and displayed -> " + e.getMessage());
        }

    }

    public static WebElement waitForElementToBeClickable(final By by) throws Exception {
        WebElement element;
        try {
            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (Common.DEFAULT_WAIT / 1000));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));

            return element; // return the element
        } catch (Exception e) {
            Log.error(by.toString() + "-> elements is clickable");
            Log.error(e.getMessage());
            throw new Exception(by.toString() + "-> element is not clickable -> " + e.getMessage());
        }

    }

    public static void waitForPageLoadToComplete() throws Exception {
        try {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver newDriver) {
                    return ((JavascriptExecutor) newDriver).executeScript("return document.readyState").equals("complete");
                }
            };

            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (Common.DEFAULT_WAIT / 1000));
            wait.until(pageLoadCondition);
            //Log.info("Waiting for Page to load completely");
        } catch (Exception e) {
            Log.error("Page is not loaded completely");
            Log.error(e.getMessage());
            throw new Exception("Page is not loaded completely " + e.getMessage());
        }
    }

    public static boolean isElementPresentAndDisplay(By by) {
        try {
            if ($(by).isDisplayed())
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForElementToBeClickable(WebElement element) throws Exception {
        try {
            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (Common.DEFAULT_WAIT / 1000));
            element = wait.until(ExpectedConditions.elementToBeClickable(element));

        } catch (Exception e) {
            Log.error("-> elements is clickable");
            Log.error(e.getMessage());
            throw new Exception("-> element is not clickable -> " + e.getMessage());
        }

    }

    public  void  implicitwait(){

        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    }

}
