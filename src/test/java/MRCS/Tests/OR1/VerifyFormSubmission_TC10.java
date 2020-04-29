package MRCS.Tests.OR1;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR1;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyFormSubmission_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Clinical objClinical = new Clinical();

    @Test( description = "System allow submission without errors", groups = {"OR1"} )
    public void VerifyFormSubmission() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_Manager);
        logTestStep("Log in to application");
        Common.PopUp();
        OR1.BulkAssignToUser();
        SelectChaseAndOpenChart();
        objRisk.membervalidation();
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2017");
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[2]").setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        String GetMsg=$x("//span[contains(text(),'C/MR')]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Measure shows +ve compliance");
        }else{
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
        }*/
        objLoginOut.logout();
    }
}
