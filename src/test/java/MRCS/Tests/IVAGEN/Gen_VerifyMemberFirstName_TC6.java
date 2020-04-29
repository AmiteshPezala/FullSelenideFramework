package MRCS.Tests.IVAGEN;
import MRCS.Modules.Hedis.IVAGen;
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

public class Gen_VerifyMemberFirstName_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test(description = "Verify member first name field", groups = {"IVA GEN"} )
    public void Gen_VerifyMemberFirstName() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVAGen.NavigateToGen();
        objRisk.membervalidation();
        sleep(2000);
        if ($x("//input[@id='MemberFirstName']").isEnabled())
        {
            logTestStepFail("Members first name field is editable  with data displayed");
            Assert.fail("Members first name field is editable  with data displayed");
        }
        else
        {
            logTestStepPass("Members first name field is non editable  with data displayed");

        }
        sleep(2000);
        objLoginOut.logout();
    }
}
