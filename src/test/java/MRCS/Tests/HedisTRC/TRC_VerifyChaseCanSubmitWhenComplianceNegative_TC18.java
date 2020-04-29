package MRCS.Tests.HedisTRC;
import MRCS.Locators.HedisRepo.HedisTRCRepo;
import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TRC_VerifyChaseCanSubmitWhenComplianceNegative_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when the compliance is +ve", groups = {"Hedis TRC"} )
    public void TRC_VerifyChaseCanSubmitWhenCompliancePositive() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        HedisTRC.ClearData();
        sleep(2000);
        $$(HedisTRCRepo.NRCDropDown).filter(Condition.visible).get(0).click();
        sleep(3000);
        $x("//span[contains(text(),'No evidence of receipt notification')]").click();
        sleep(3000);
        $$(HedisTRCRepo.NRCDropDown).filter(Condition.visible).get(2).click();
        sleep(3000);
        $x("//span[contains(text(),'Not found in 2019')]").click();
        sleep(3000);
        $$(HedisTRCRepo.NRCDropDown).filter(Condition.visible).get(3).click();
        sleep(3000);
        $x("//span[contains(text(),'Patient engagement was on date of discharge')]").click();
        sleep(3000);
        $$(HedisTRCRepo.NRCDropDown).filter(Condition.visible).get(5).click();
        sleep(3000);
        $x("//span[contains(text(),'No medication reconcilliation found in timeframe')]").click();
        sleep(3000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
            Assert.fail("Chase not submitted");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
