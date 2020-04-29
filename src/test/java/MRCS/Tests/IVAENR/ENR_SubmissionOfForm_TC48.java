package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ENR_SubmissionOfForm_TC48 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify submission of form.", groups = {"IVA ENR"})
    public void ENR_SubmissionOfForm_TC48() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.MemberId_ENR();
        objMeasure.FirstName_ENR();
        objMeasure.LastNameENR();
        objMeasure.DOB_ENR();
        objMeasure.Gender_ENR();
        objMeasure.PlanID_ENR();
        objMeasure.EnrollmentFromDate_ENR();
        objMeasure.EnrollmentThruDate_ENR();
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "SUBMISSION SUCCEEDED!");
        sleep(3000);
        Common.StopWalkThru();
        sleep(2000);
        objLoginOut.logout();
    }
}
