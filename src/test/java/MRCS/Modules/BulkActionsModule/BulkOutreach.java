package MRCS.Modules.BulkActionsModule;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach {

    public static void BulkOutreachLink() throws Exception {
        ClickElement(BulkActionsRepo.BulkAction,"Bulk action link");
        sleep(2000);
        ClickElement(BulkActionsRepo.BulkOutreach,"Bulk outreach link");
        sleep(2000);
    }

    public static void SubmitFaxRequest() throws Exception {
        BulkOutreach objBulkOutreach = new BulkOutreach();
        String User = $(BulkActionsRepo.LoggedInUserName).getText();
        Log.info("User = " + User);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(5000);
        $(BulkActionsRepo.ActionTypeDropDown).click();
        sleep(2000);
        $(BulkActionsRepo.OptionFax).click();
        sleep(2000);
        $(BulkActionsRepo.WhoIsSendingFax).setValue(User);
        sleep(2000);
        $(BulkActionsRepo.FaxNo).setValue("1234");
        sleep(5000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        $(BulkActionsRepo.RunQuery).click();
        sleep(2000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $(BulkActionsRepo.RunQuery));
        sleep(2000);
        $(BulkActionsRepo.CoverLetterDropDown).click();
        sleep(2000);
        $(BulkActionsRepo.DropDownElement).click();
        sleep(2000);
        $(BulkActionsRepo.SubmitFax).click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(2000);
    }
    public static void FillingFormForSubmit() throws Exception {
        BulkOutreach objBulkOutreach = new BulkOutreach();
        String User = $(BulkActionsRepo.LoggedInUserName).getText();
        Log.info("User = " + User);
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        objBulkOutreach.BulkOutreachLink();
        sleep(5000);
        $(BulkActionsRepo.ActionTypeDropDown).click();
        sleep(2000);
        $(BulkActionsRepo.OptionFax).click();
        sleep(2000);
        $(BulkActionsRepo.WhoIsSendingFax).setValue(User);
        sleep(2000);
        $(BulkActionsRepo.FaxNo).setValue("1234");
        sleep(5000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
    }
}
