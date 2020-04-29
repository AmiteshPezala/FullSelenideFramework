package MRCS.Tests.HedisCIS;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisCIS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CIS_PositiveChaseSubmitted_TC34 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Positive compliance chase get submitted .", groups = {"Hedis CIS"})
    public void CIS_PositiveChaseSubmitted_TC34() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCIS.navigateToCIS();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_CIS();
        sleep(2000);
        objMeasure.DataforDtap_CIS();
        sleep(2000);
        objMeasure.DataForIPV_CIS();
        sleep(2000);
        objMeasure.DataForHEPA_CIS();
        sleep(2000);
        objMeasure.DataForHepB_CIS();
        sleep(2000);
        objMeasure.DataForHIB_CIS();
        sleep(2000);
        objMeasure.DataForMMR_CIS();
        sleep(2000);
        objMeasure.DataForVZV_CIS();
        sleep(2000);
        objMeasure.DataForPCV_CIS();
        sleep(2000);
        objMeasure.DataFor2Rotavirus_CIS();
        sleep(2000);
        objMeasure.DataFor3Rotavirus_CIS();
        sleep(2000);
        objMeasure.DataForInfluenza_CIS();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'DtaP')]"));
        sleep(2000);
        objMeasure.PositiveComplianceDtap_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceIPV_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceHepA_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceHepB_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceHIB_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceMMR_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceVZV_CIS();
        sleep(2000);
        objMeasure.PositiveCompliancePCV_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceDoseRotavirus_CIS();
        sleep(2000);
        objMeasure.PositiveComplianceInfluenza_CIS();
        sleep(2000);
        objRisk.ChecklistForART();
        /*$x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "SUBMISSION SUCCEEDED!");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);*/
        objLoginOut.logout();
    }
}
