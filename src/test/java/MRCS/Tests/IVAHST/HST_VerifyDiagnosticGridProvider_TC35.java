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
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyDiagnosticGridProvider_TC35 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that diagnostic grid is having provider field.", groups = {"IVA HST"} )
    public void HST_VerifyDiagnosticGridProvider() throws Exception {
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
        logInfoStepColored(COLOR.BLUE,"Verifying provider dropdown is available");
        if($x("(//h4[contains(text(),'ICD Information')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])").isDisplayed())
        {
            logTestStepPass("A provider dropdown is available where the encounter provider is displaying");
        }else
        {
            logTestStepFail("A provider dropdown is not available where the encounter provider is displaying");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
