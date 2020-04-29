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

public class Dob_VerifyMemberLastName_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify member last name field", groups = {"IVA DOB"} )
    public void IVA_VerifyMemberLastName() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVADob.NavigateToIVADob();
        objRisk.membervalidation();
        sleep(2000);
        if ($x("//input[@id='MemberLastName']").isEnabled())
        {
            logTestStepFail("Members Last name field is editable  with data displayed");
            Assert.fail("Members Last name field is editable  with data displayed");
        }
        else
        {
            logTestStepPass("Members Last name field is non editable  with data displayed");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
