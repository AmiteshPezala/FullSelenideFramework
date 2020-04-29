package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyDataReflectedInRespectiveEncounterRow_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that Encounter validation data is reflected in respective encounter row in encounter grid or not.", groups = {"IVA HST"})
    public void HST_VerifyDataReflectedInRespectiveEncounterRow_TC21() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        objRisk.EncountervalidationNo();
        sleep(2000);
        String ENC=$x("//tr[1]//td[5]").getText();
        Log.info(ENC);
        if(ENC.equals("N")){
            logTestStepPass("Encounter validation data is reflected in respective encounter row in encounter grid ");
        }else{
            logTestStepFail("Data is not reflecting in respective encounter row.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
