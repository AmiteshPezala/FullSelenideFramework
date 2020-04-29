package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyQueryResult_TC26 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify that result of query is according to the selected data or not.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyQueryResult_TC26() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
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
        String FaxNo="1234" ;
        ElementsCollection CountOfProject=$$x("//label[contains(text(),'SELECT STATUS(S)')]//preceding::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']");
        int TotalProjects=CountOfProject.size();
        Log.info("TotalProjects = " + TotalProjects);
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(3000);
        $(BulkActionsRepo.RunQuery).click();
        sleep(2000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'SUBMIT FAX REQUEST')]"));
        sleep(2000);
        String ProjectsOfResult=$x("//div[contains(text(),'PROJECTS:')]//span").getText();
        Log.info("ProjectsOfResult = "+ ProjectsOfResult);
        int ProjectCountOfResult=Integer.parseInt(ProjectsOfResult);
        String SenderOfResult=$x("//div[contains(text(),'SENDER:')]//span").getText();
        Log.info("SenderOfResult = "+SenderOfResult);
        String FaxOfResult=$x("//div[contains(text(),'FAXING FROM #:')]//span").getText();
        Log.info("FaxOfResult = "+FaxOfResult);
        sleep(2000);
        if(TotalProjects == ProjectCountOfResult && SenderOfResult.equals(User) && FaxOfResult.equals(FaxNo)){
            logTestStepPass("Result of query is according to the selected field.");
        }else{
            logTestStepFail("Result of query is not according to the selected field.");
        }
        objLoginOut.logout();
    }
}
