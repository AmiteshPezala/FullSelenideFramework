package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyRequiredFieldsOnDiagnosticGrid_TC30 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify required fields on diagnostic grid", groups = {"IVA HST"} )
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
        $x("//input[@id='pageNumber']").click();
        Selenide.sleep(1000);
        $x("//input[@id='Icd']").click();
        Selenide.sleep(1000);
        $x("((//label[contains(text(),'Provider')])[2]//following::label)[1]").click();
        Selenide.sleep(3000);
        $x("//h3[contains(text(),'Diagnoses')]").click();
        Selenide.sleep(2000);
        logTestStep("Verifying Required field in diagnostic section");
        String ActualPageToolTip=$x("//div[contains(text(),'Enter a page number greater than 1')]").getText();
        Selenide.sleep(1000);
        String ActualIcdToolTip=$x("//div[contains(text(),'ICD Code is required')]").getText();
        Selenide.sleep(1000);
        String ActualProvideToolTip=$x("//div[contains(text(),'Provider is required')]").getText();
        Selenide.sleep(1000);
        assertText(ActualPageToolTip,"Enter a page number greater than 1");
        assertText(ActualIcdToolTip,"ICD Code is required");
        assertText(ActualProvideToolTip,"Provider is required");
        Selenide.sleep(5000);
        objLoginOut.logout();
    }
}
