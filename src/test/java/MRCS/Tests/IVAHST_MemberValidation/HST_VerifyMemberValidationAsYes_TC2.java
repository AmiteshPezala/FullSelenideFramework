package MRCS.Tests.IVAHST_MemberValidation;

import MRCS.Modules.HST.HST_MemberValidation;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;


public class HST_VerifyMemberValidationAsYes_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify member validation Yes", groups = {"IVA HST_Member Validation"})
    public void HST_VerifyMemberValidationAsYes() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HST_MemberValidation.NavigateToHST();
        objRisk.membervalidation();
        logTestStepPass("User can select Yes option.  Rest of the form gets enable.");
        objLoginOut.logout();
    }
}
