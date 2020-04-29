package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyByDefaultFirstDiagnosticRowIsSelected_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that by default first diagnostic grid is selected.", groups = {"IVA HST"})
    public void HST_VerifyByDefaultFirstDiagnosticRowIsSelected_TC23() throws Exception {
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
        String ICDCodeOfFirstRow=$x("(//tr[1]//td[4])[2]").getText();
        Log.info(ICDCodeOfFirstRow);
        sleep(2000);
        String ICDCodeOfRecord=$x("(//h4[contains(text(),'ICD Information')]//following::input)[4]").getValue();
        Log.info(ICDCodeOfRecord);
        sleep(2000);
        if(ICDCodeOfFirstRow.equals(ICDCodeOfRecord)){
            logTestStepPass("By default first diagnostic grid is selected.");
        }else{
            logTestStepFail("First diagnostic grid is not selected.");
        }
        objLoginOut.logout();
    }
}
