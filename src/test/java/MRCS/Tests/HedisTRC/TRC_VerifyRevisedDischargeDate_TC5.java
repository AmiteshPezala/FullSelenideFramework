package MRCS.Tests.HedisTRC;
import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class TRC_VerifyRevisedDischargeDate_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that revised discharge date must be within 30 days of admin discharge date", groups = {"Hedis TRC"} )
    public void TRC_VerifyRevisedDischargeDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        HedisTRC.ClearData();
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        if($x("//span[@class='ui-messages-icon pi pi-times']").isDisplayed()){
            logTestStepPass("Validation message displayed");
        }else{
            logTestStepFail("Validation message not displayed");
            Assert.fail("Validation message not displayed");
        }
        sleep(2000);
        $x("//i[@class='pi pi-times']").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
