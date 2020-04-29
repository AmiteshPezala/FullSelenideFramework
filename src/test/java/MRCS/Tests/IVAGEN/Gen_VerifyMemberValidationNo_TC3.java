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

public class Gen_VerifyMemberValidationNo_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify member validation NO", groups = {"IVA GEN"} )
    public void Gen_VerifyMemberValidationNo() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        IVAGen.NavigateToGen();
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
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
