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

public class HST_VerifyDiagnosticDelete_TC26 extends TestBase {
        LoginOut objLoginOut = new LoginOut();
        Risk objRisk= new Risk();

        @Test( description = "Verify new diagnostic code  add", groups = {"IVA HST"} )
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
            String AddedBeforeAdd=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[6]").getText();
            sleep(2000);
            objRisk.AddDiagnoses();
            sleep(2000);
            $x("//h3[contains(text(),'Diagnoses')]//following::div[@class='button button__delete ng-star-inserted']").click();
            sleep(2000);
            String CountAfterDelete=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[6]").getText();
            sleep(2000);
            assertText(CountAfterDelete,AddedBeforeAdd);
            logTestStepPass("New added row deleted successfully");
            objLoginOut.logout();
        }
}
