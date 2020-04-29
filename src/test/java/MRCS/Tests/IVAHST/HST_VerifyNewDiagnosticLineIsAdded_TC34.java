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

public class HST_VerifyNewDiagnosticLineIsAdded_TC34 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that HCC information is present or not.", groups = {"IVA HST"})
    public void HST_VerifyNewDiagnosticLineIsAdded_TC34() throws Exception {
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
        String PreviousCount=$x("(//h3[contains(text(),'Diagnoses')]//following::span[@class='font-size-2 bold ng-star-inserted'])[3]").getText();
        Log.info(PreviousCount);
        sleep(2000);
        $x("//h3[contains(text(),'Diagnoses')]//following::div[@class='button button__add']").click();
        sleep(5000);
        String CurrerentCount=$x("(//h3[contains(text(),'Diagnoses')]//following::span[@class='font-size-2 bold ng-star-inserted'])[3]").getText();
        Log.info(CurrerentCount);
        sleep(2000);
        if(PreviousCount.equals(CurrerentCount)){
            logTestStepFail("New diagnostic row is not added.");
        }else{
            logTestStepPass("New diagnostic row is added.");
        }
        sleep(2000);
        $x("//div[contains(text(),'×')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
