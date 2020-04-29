package MRCS.Tests.IVAHST;
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

public class HST_VerifyCoderCanChangeTheProvider_TC36 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify coder can change the provider at diagnostic level", groups = {"IVA HST"} )
    public void HST_VerifyCoderCanChangeTheProvider() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        objRisk.EncountervalidationYes();
        sleep(2000);
        objRisk.AddDiagnoses();
        objRisk.EnterDiagnosticData();
        logInfoStepColored(COLOR.BLUE,"Verifying provider dropdown is available");
        if($x("//h4[contains(text(),'ICD Information')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").isDisplayed())
        {
            logTestStepPass("Coder can change the provider at diagnostic level");
        }else
        {
            logTestStepFail("Coder can not change the provider at diagnostic level");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
