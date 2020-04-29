package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyFilter_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();


    @Test(description = "Verify filter functionality.", groups = {"Clinical Assignment"})
    public void VerifyFilter_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(10000);
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(4000);
        String ChaseId=$x("//tr[1]//td[2]//div").getText();
        Log.info(ChaseId);
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").setValue(ChaseId);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        String NewChaseId=$x("//tr[1]//td[2]//div").getText();
        Log.info(NewChaseId);
        if(ChaseId.equals(NewChaseId)){
            logTestStepPass("Filter applied successfully.");
        }
        else{
            logTestStepFail("Filter not applied.");
        }
        objLoginOut.logout();
    }
}
