package MRCS.Tests.OR2;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR2;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyFormSubmission_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify form submission.", groups = {"OR2"})
    public void VerifyFormSubmission_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonAdmin);
        Common.PopUp();
        //objWait.implicitwait();
        OR2.BulkAssignToUser();
        objcommon.SelectChaseAndOpenChart();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2017");
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[2]").setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave, "Click to save");
        sleep(2000);
        String GetMsg = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        if (GetMsg.equals("C/MR")) {
            logTestStepPass("Measure shows +ve compliance");
        } else {
            logTestStepFail("Measure not shows +ve compliance");
            Assert.fail("Measure not shows +ve compliance");
        }
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        /*ClickElement(CommonRepo.SubmitMeasure,"Clicking to submit data");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
            Assert.fail("Chase not submitted");
        }
        sleep(2000);*/
        objLoginOut.logout();
    }
}
