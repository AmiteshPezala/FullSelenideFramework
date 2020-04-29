package MRCS.Tests.IVADOB;

import MRCS.Modules.Hedis.IVADob;
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

public class Dob_VerifyMemberValidationAsNo_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify member validation NO", groups = {"IVA DOB"} )
    public void IVA_VerifyMemberValidationAsNo() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVADob.NavigateToIVADob();
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
