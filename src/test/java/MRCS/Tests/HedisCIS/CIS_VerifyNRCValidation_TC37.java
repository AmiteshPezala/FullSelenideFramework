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
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class CIS_VerifyNRCValidation_TC37 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify NRC code validation.", groups = {"Hedis CIS"})
    public void CIS_VerifyNRCValidation_TC37() throws Exception {
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
        if ($x("(//h4[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            int AdminDate = $$x("(//h4[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            $x("(//button[@class='control__add'])[position()=20]").click();
            sleep(2000);
        } else {
            $x("(//button[@class='control__add'])[position()=20]").click();
            sleep(2000);
        }
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'DtaP')]"));
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(2000);
        if($(".ui-messages-icon").isDisplayed())
        {
          logTestStepPass("Negative reason code is missing from non-compliant numerator Influenza is displayed");
        }else
        {
           logTestStepFail("Negative reason code is missing from non-compliant numerator Influenza is not displayed");
            Assert.fail("Negative reason code is missing from non-compliant numerator Influenza is not displayed");
        }
//        String AlertMessage =$x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").getText();
//        assertText(AlertMessage,"Negative reason code is missing from non-compliant numerator \"Influenza\";");
        sleep(2000);
        objLoginOut.logout();
    }
}
