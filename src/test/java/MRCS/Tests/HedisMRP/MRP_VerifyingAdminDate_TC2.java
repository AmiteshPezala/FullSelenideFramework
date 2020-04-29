package MRCS.Tests.HedisMRP;

import MRCS.Locators.HedisRepo.HedisMRPRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisMRP;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MRP_VerifyingAdminDate_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that admin date is available for discharge date ", groups = {"Hedis MRP"})
    public void MRP_VerifyingAdminDate_TC2() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisMRP.navigateToMRP();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Verifying weather admin date is available or not.");
        if($(HedisMRPRepo.AdminDate).isDisplayed()){
            logTestStepPass("Admin date is available for discharge date.");
        }else{
            logTestStepFail("Admin date is not available for discharge date.");
            Assert.fail("Admin date is not available for discharge date.");
        }
        objLoginOut.logout();
    }
}
