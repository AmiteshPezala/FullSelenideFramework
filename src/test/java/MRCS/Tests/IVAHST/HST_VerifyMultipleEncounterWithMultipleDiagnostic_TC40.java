package MRCS.Tests.IVAHST;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class HST_VerifyMultipleEncounterWithMultipleDiagnostic_TC40 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that multiple added encounters with multiple diagnostic lines with duplicate data can be saved and submitted", groups = {"IVA HST"} )
    public void HST_VerifyMultipleEncounterWithMultipleDiagnostic() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        objRisk.AddEncounter();
        sleep(2000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        sleep(2000);
        objRisk.AddDiagnoses();
        sleep(2000);
        objRisk.EnterDiagnosticDataForNewEncounter();
        logTestStep_ColorGreen("New diagnostic data line is added for New encounter");
        objRisk.AddEncounter();
        sleep(2000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        sleep(2000);
        objRisk.AddDiagnoses();
        sleep(2000);
        objRisk.EnterDiagnosticDataForNewEncounter();
        sleep(2000);
        logTestStep_ColorGreen("New diagnostic data line is added for New encounter");
        objLoginOut.logout();
    }
}
