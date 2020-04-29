package MRCS.Tests.IVAGEN;

import MRCS.Modules.Hedis.IVAGen;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Gen_VerifyMemberValidationYes_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify member validation Yes", groups = {"IVA GEN"} )
    public void Gen_VerifyMemberValidationYes() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVAGen.NavigateToGen();
        objRisk.membervalidation();
        sleep(2000);
        if ($x("(//label[contains(text(),'Confirm Gender?')]//following::label)[1]").isEnabled())
        {
            logTestStepPass("Form get enabled after member validation as Yes");
        }
        else
        {
            logTestStepFail("Form not get enabled after member validation as Yes");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
