package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ENR_PremiumAmoutRequiredForSubscriberYes_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that premium amount is required when subscriber =Yes.", groups = {"IVA ENR"})
    public void ENR_PremiumAmoutRequiredForSubscriberYes_TC24() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        objRisk.membervalidation();
        sleep(2000);
        String SubscriberType=$x("(//label[contains(text(),'Subscriber Type')]//following::input)[1]").getValue();
        Log.info(SubscriberType);
        if(SubscriberType.contains("S")){
            logTestStep("Subscriber type = " + SubscriberType);
            objMeasure.MemberId_ENR();
            objMeasure.FirstName_ENR();
            objMeasure.LastNameENR();
            objMeasure.DOB_ENR();
            objMeasure.Gender_ENR();
            objMeasure.PlanID_ENR();
            objMeasure.EnrollmentFromDate_ENR();
            objMeasure.EnrollmentThruDate_ENR();
            sleep(2000);
            $x("(//div[contains(text(),'Premium Amount')]//following::button[@class='control__delete ng-star-inserted'])").click();
            sleep(2000);
            objRisk.ChecklistForART();
            sleep(2000);
            $x("(//span[contains(text(),'Submit')])[2]").click();
            sleep(2000);
            if (WebDriverRunner.getWebDriver().getPageSource().contains("Premium amount, PageNumber, Confirm  must be provided")) {
                logTestStepPass("Validation message displayed");
            } else {
                logTestStepFail("Validation message not displayed");
            }

        }else{
            logTestStep("Subscriber type = " + SubscriberType);
        }
        objLoginOut.logout();
    }
}
