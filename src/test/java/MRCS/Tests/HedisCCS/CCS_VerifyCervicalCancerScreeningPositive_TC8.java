package MRCS.Tests.HedisCCS;

import MRCS.Modules.Hedis.HedisCCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClearAndSendKeys;
import static MRCS.Utils.Common.ClickElement;
import static java.lang.Thread.sleep;

public class CCS_VerifyCervicalCancerScreeningPositive_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that cervical cancer screening is +ve", groups = {"Hedis CCS"} )
    public void CCS_MemberAge34To64() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        //sleep(5000);
        objRisk.membervalidation();
        HedisCCS.ClearData();
        HedisCCS.HPVPositiveCompliance();
        HedisCCS.VerifyPositiveCompliance();
        objLoginOut.logout();
    }
}

