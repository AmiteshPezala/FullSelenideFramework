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

public class HST_VerifyFirstEncounterGridSelected_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that by default first encounter grid is selected.", groups = {"IVA HST"})
    public void HST_VerifyFirstEncounterGridSelected_TC2() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        String ClaimIdOfGrid=$x("//tr[1]//td[2]").getText();
        Log.info("ClaimIdOfGrid : " + ClaimIdOfGrid);
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Claim ID')]//following::input"));
        sleep(2000);
        String ClaimId=$x("//label[contains(text(),'Claim ID')]//following::input").getValue();
        Log.info("ClaimId : " + ClaimId);
        sleep(2000);
        if(ClaimIdOfGrid.equals(ClaimId)){
            logTestStepPass("By default first encounter grid is selected.");
        }else{
            logTestStepFail("First encounter grid is not selected.");
        }
        objLoginOut.logout();
    }
}
