package MRCS.Tests.IVAHST;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyNewDiagnosticLineDataEntry_TC29 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify new diagnostic line data entry", groups = {"IVA HST"} )
    public void HST_VerifyNewDiagnosticCodeAdded() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        sleep(2000);
        objRisk.AddDiagnoses();
        sleep(2000);
        objRisk.EnterDiagnosticData();
        sleep(2000);
        String ActualIcd=$x("//span[@title='Z6832']").getText();
        sleep(2000);
        String ActualPageNumber=$x("//span[@title='3']").getText();
        sleep(2000);
        assertText(ActualIcd,"Z6832");
        logTestStep("Selected Icd code is displayed");
        assertText(ActualPageNumber,"3");
        logTestStep("Diagnostic grid data is updated");
        $x("//div[contains(text(),'×')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
