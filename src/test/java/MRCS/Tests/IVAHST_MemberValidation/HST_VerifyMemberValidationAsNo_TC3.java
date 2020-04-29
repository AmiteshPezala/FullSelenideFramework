package MRCS.Tests.IVAHST_MemberValidation;

import MRCS.Modules.HST.HST_MemberValidation;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyMemberValidationAsNo_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify member validation NO", groups = {"IVA HST_Member Validation"})
    public void HST_VerifyMemberValidationAsYes() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HST_MemberValidation.NavigateToHST();
        objRisk.membervalidationNo();
        sleep(2000);
        String GetText=$x("//div[contains(text(),'MRR')]").getText();
        if (GetText.equals("MRR"))
        {
            logTestStepPass("Member validation successful");
        }
        else
        {
            logTestStepFail("Member validation not successful");
            Assert.fail("Member validation not successful");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
