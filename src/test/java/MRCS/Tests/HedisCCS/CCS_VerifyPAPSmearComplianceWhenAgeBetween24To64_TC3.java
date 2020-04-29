package MRCS.Tests.HedisCCS;
import MRCS.Modules.Hedis.HedisCCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class CCS_VerifyPAPSmearComplianceWhenAgeBetween24To64_TC3 extends TestBase {
    LoginOut objLoginOut=new LoginOut();
    Risk objRisk=new Risk();

    @Test( description = "Verify that for PAP smear  field are required when age is between 24 -64", groups = {"Hedis CCS"} )
    public void CCS_VerifyPAPSmearComplianceWhenAgeBetween24To64() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        objRisk.membervalidation();
        HedisCCS.ClearData();
        HedisCCS.PapSmearPositiveCompliance();
        HedisCCS.VerifyPositiveCompliance();
        sleep(2000);
        objLoginOut.logout();
    }
}
