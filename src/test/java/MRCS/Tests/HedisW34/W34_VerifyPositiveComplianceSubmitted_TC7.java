package MRCS.Tests.HedisW34;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisW34;
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

public class W34_VerifyPositiveComplianceSubmitted_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that positive compliance chase can be submitted", groups = {"Hedis W34"})
    public void VerifyPositiveComplianceSubmitted_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisW34.navigateToW34();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.FillAllDetails_W34();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.PositiveCompliance_ABA();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "SUBMISSION SUCCEEDED!");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        objLoginOut.logout();
    }
}
