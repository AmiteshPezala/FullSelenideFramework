package MRCS.Tests.IVAHST_MemberValidation;

import MRCS.Modules.HST.HST_MemberValidation;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class HST_VerifyMRDob_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify MR DOB field", groups = {"IVA HST_Member Validation"})
    public void HST_VerifyMemberValidationAsYes() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HST_MemberValidation.NavigateToHST();
        objRisk.membervalidation();
        String getDob=$x("(//div[@class='value'])[3]").getText();
        System.out.println(getDob);
        $x("//input[@id='MedicalRecordDob']").sendKeys(getDob);
        logTestStepPass("User can enter member DOB");
        objLoginOut.logout();
    }
}
