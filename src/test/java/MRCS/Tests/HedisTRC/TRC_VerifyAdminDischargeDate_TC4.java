package MRCS.Tests.HedisTRC;

import MRCS.Modules.Hedis.HedisTRC;
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

public class TRC_VerifyAdminDischargeDate_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify admin discharge date is available", groups = {"Hedis TRC"} )
    public void TRC_VerifyAdminAdmissionDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        if($x("(//label[contains(text(),'Discharge Date')]//following::input)[1]").isDisplayed()){
            logTestStepPass("Admin discharge date is available");
        }else{
            logTestStepFail("Admin discharge date is not available");
            Assert.fail("Admin discharge date is not available");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
