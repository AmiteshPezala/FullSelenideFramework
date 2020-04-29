package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyEncounterGridData_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that encounter grid contains ID,DOS,provider,Enc,F2F& sig.", groups = {"IVA HST"})
    public void HST_VerifyEncounterGridData_TC3() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        String ID=$x("//th[contains(text(),'Claim ID')]").getText();
        assertText(ID, "Claim ID");
        sleep(2000);
        String DOS=$x("//th[contains(text(),'DOS')]").getText();
        assertText(DOS, "DOS");
        sleep(2000);
        String Provider=$x("//th[contains(text(),'Provider')]").getText();
        assertText(Provider, "Provider");
        sleep(2000);
        String ENC= $x("//th[contains(text(),'Enc')]").getText();
        assertText(ENC, "Enc");
        sleep(2000);
        String F2F=$x("//th[contains(text(),'F2F')]").getText();
        assertText(F2F, "F2F");
        sleep(2000);
        String Signature=$x("//th[contains(text(),'Sig')]").getText();
        assertText(Signature, "Sig");
        sleep(2000);
        logTestStepPass("All fields are present in encounter grid.");
        objLoginOut.logout();
    }
}
