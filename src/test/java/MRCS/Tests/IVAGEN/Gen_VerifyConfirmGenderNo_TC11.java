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

public class Gen_VerifyConfirmGenderNo_TC11 extends TestBase {
    LoginOut objLoginOut=new LoginOut();
    Risk objRisk=new Risk();

    @Test(description="Verify confirm Gender =NO", groups = {"IVA GEN"} )
    public void Gen_VerifyConfirmGenderNo() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVAGen.NavigateToGen();
        objRisk.membervalidation();
        sleep(2000);
        $(".ui-dropdown-trigger").click();
        sleep(1000);
        $x("//li[@aria-label='No']").click();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        String GetText = $x("//div[contains(text(),'Gender must be confirmed')]").getText();
        sleep(1000);
        if (GetText.equals("Gender must be confirmed")) {
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
