package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyQueuePriority_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify bulk address assign.", groups = {"Retrieval Assignment"})
    public void VerifyQueuePriority_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(15000);
        $x("//span[contains(text(),'QUEUE PRIORITIES')]").click();
        sleep(2000);
        $x("//label[contains(text(),'Project')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
        sleep(2000);
        $x("//*[starts-with(span,'UAT')]").click();
        sleep(2000);
        String ProjectName=$x("//label[contains(text(),'Project')]//following::label").getText();
        Log.info("Drop down ProjectName" + ProjectName);
        sleep(2000);
        $x("//span[contains(text(),'UPDATE QUEUE')]").click();
        sleep(15000);
        String Project =$x("//tr[1]//td[11]").getText();
        Log.info("Project = " + Project);
        sleep(2000);
        if(ProjectName.equals(Project)){
            logTestStepPass("Selected project is appeared on the top of the list");
        }else{
            logTestStepFail("Selected project is not appeared on the top of the list");
        }
        objLoginOut.logout();
    }
}
