package MRCS.Tests.HedisPPC;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class PPC_VerifyNonComplianceChase_TC25 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that a non compliance chase cannot be submitted if NRC's are not selected", groups = {"Hedis PPC"} )
    public void PPC_VerifyNonComplianceChase() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE, "Clearing all pre-filled data");
        $$(".control__delete").filter(Condition.visible).get(5).click();
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(2000);
        objRisk.ChecklistForART();
        ClickElement(CommonRepo.SubmitMeasure,"Click to submit");
        String ValidationMessage=$(".ui-messages-detail").getText();
        String PrenatalText="Negative reason code is missing from non-compliant numerator \"Prenatal\";";
        String PostpartumText="Negative reason code is missing from non-compliant numerator \"Postpartum\";";
        if (ValidationMessage.contains(PrenatalText) || ValidationMessage.contains(PostpartumText)) {
            logTestStepPass("A validation message displayed to select NRC if user tries to submit a non compliance chase");
        } else {
            logTestStepFail("A validation message not displayed");
            Assert.fail("A validation message not displayed");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
