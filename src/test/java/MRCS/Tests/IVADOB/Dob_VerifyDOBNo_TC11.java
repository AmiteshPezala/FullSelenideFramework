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

public class Dob_VerifyDOBNo_TC11 extends TestBase {
    LoginOut objLoginOut=new LoginOut();
    Risk objRisk=new Risk();

    @Test(description="Verify confirm DOB =NO", groups = {"IVA DOB"} )
    public void IVA_VerifyDOBNo() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVADob.NavigateToIVADob();
        objRisk.membervalidation();
        sleep(2000);
        $$(".ui-dropdown-trigger").filter(Condition.visible).first().click();
        sleep(1000);
        $x("//li[@aria-label='No']").click();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        Risk.ChecklistForART();
        String GetText = $x("//div[contains(text(),'DateOfBirth must be confirmed')]").getText();
        if (GetText.equals("DateOfBirth must be confirmed")) {
            logTestStepPass("Upon submit  a message displayed");
        } else {
            logTestStepFail("Upon submit  a message not displayed");
            Assert.fail("Upon submit  a message not displayed");
        }
        sleep(2000);
        $x("//*[contains(text(),'Cancel')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
