package MRCS.Tests.IVADOB;
import MRCS.Modules.Hedis.IVADob;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Dob_VerifyDOBYes_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify confirm DOB =YES", groups = {"IVA DOB"} )
    public void IVA_VerifyDOBYes() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVADob.NavigateToIVADob();
        objRisk.membervalidation();
        sleep(2000);
        $$(".ui-dropdown-trigger").filter(Condition.visible).first().click();
        sleep(1000);
        $x("//li[@aria-label='Yes']").click();
        sleep(2000);
        $x("//input[@id='MemberLastName']").click();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
            Assert.fail("Chase not submitted");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
