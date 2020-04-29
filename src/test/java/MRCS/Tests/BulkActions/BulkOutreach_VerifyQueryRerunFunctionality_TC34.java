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
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyQueryRerunFunctionality_TC34 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify functionality of rerun query option.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyQueryRerunFunctionality_TC34() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.FillingFormForSubmit();
        sleep(2000);
        $(BulkActionsRepo.IncludePendsYes).click();
        sleep(2000);
        $(BulkActionsRepo.SelectAll).click();
        sleep(2000);
        $(BulkActionsRepo.RunQuery).click();
        sleep(3000);
        for (int i = 0; i < 4; i++) {
            $x("(//span[@class='ui-chkbox-icon ui-clickable pi pi-check'])[" + i + 1 + "]").click();
            sleep(2000);
        }
        sleep(2000);
        ElementsCollection CountOfProject=$$x("//label[contains(text(),'SELECT STATUS(S)')]//preceding::span[@class='ui-chkbox-icon ui-clickable pi pi-check']");
        int TotalProjects=CountOfProject.size();
        Log.info("TotalProjects = " + TotalProjects);
        sleep(2000);
        $x("//span[contains(text(),'RE-RUN QUERY')]").click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(1000);
        String ProjectsOfResult=$x("//div[contains(text(),'PROJECTS:')]//span").getText();
        Log.info("ProjectsOfResult = "+ ProjectsOfResult);
        int ProjectCountOfResult=Integer.parseInt(ProjectsOfResult);
        sleep(2000);
        if(TotalProjects == ProjectCountOfResult){
            logTestStepPass("Result for Rerun query is proper ");
        }else{
            logTestStepFail("Result for Rerun query is not proper ");
        }
        objLoginOut.logout();
    }
}