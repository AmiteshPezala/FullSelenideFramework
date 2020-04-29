package MRCS.Tests.HedisTRC;
import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TRC_VerifyAdminAdmissionDate_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that admin  admission date is available", groups = {"Hedis TRC"} )
    public void TRC_VerifyAdminAdmissionDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        if($x("(//label[contains(text(),'Admission Date')]//following::input)[1]").isDisplayed()){
            logTestStepPass("Admin admission date is available");
        }else{
            logTestStepFail("Admin admission date is not available");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
