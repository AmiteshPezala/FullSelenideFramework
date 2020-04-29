package MRCS.Tests.IVAHST_MemberValidation;

import MRCS.Locators.HSTRepo.HST_MemberValidationRepo;
import MRCS.Modules.HST.HST_MemberValidation;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class HST_VerifyPageNumberAndReason_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify page number and reason is required to mark member validation=NO", groups = {"IVA HST_Member Validation"})
    public void HST_VerifyPageNumberAndReason() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HST_MemberValidation.NavigateToHST();
        Common.ClickElement(HST_MemberValidationRepo.NoButton,"No button");
        sleep(2000);
        if($(HST_MemberValidationRepo.SubmitButtonNew).isEnabled()){
            logTestStepFail("Submit button is Enabled");
            Assert.fail("Submit button is Enabled");

        }else{
            logTestStepPass("Submit button is Disabled");
        }
        objLoginOut.logout();
    }
}
