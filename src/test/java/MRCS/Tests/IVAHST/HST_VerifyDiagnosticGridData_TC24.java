package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyDiagnosticGridData_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that Diagnostic data includes pg,Dos,Icd,Hcc,Vrc.", groups = {"IVA HST"})
    public void HST_VerifyDiagnosticGridData_TC24() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        sleep(2000);
        String PageNo=$x("//h3[contains(text(),'Diagnoses')]//following::label[contains(text(),'Page Number')]").getText();
        assertText(PageNo, "Page Number");
        sleep(2000);
        String DateFrom=$x("//h3[contains(text(),'Diagnoses')]//following::label[contains(text(),'Date From')]").getText();
        assertText(DateFrom, "Date From");
        sleep(2000);
        String DateThru=$x("//h3[contains(text(),'Diagnoses')]//following::label[contains(text(),'Date Thru')]").getText();
        assertText(DateThru, "Date Thru");
        sleep(2000);
        String ICD= $x("//h3[contains(text(),'Diagnoses')]//following::label[contains(text(),'ICD')]").getText();
        assertText(ICD,"ICD");
        sleep(2000);
        String Provider=$x("//h3[contains(text(),'Diagnoses')]//following::label[contains(text(),'Provider')]").getText();
        assertText(Provider,"Provider");
        sleep(2000);
        String VRC=$x("//h3[contains(text(),'Diagnoses')]//following::label[contains(text(),'VRC')]").getText();
        assertText(VRC,"VRC");
        sleep(2000);
        logTestStepPass("All fields are present in diagnosis grid.");
        objLoginOut.logout();
    }
}
