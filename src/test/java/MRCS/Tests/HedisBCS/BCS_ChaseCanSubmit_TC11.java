package MRCS.Tests.HedisBCS;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BCS_ChaseCanSubmit_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Chase can be submitted", groups = {"Hedis BCS"} )
    public void BCS_ChaseCanSubmit() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $(HedisBCSRepo.MammogramDate).setValue("10/01/2017");
        sleep(2000);
        $(HedisBCSRepo.MammogramPageNumber).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        String GetMsg=$(HedisBCSRepo.ChaseCompliance).getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("BCS Measure shows +ve compliance");
        }else{
            logTestStepFail("BCS Measure not shows +ve compliance");
            Assert.fail("BCS Measure not shows +ve compliance");
        }
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        ClickElement(CommonRepo.SubmitMeasure,"Clicking to clear data");
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
        sleep(2000);
        objLoginOut.logout();
    }
}
