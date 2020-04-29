package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ClinicalAssignmentPendChaseSingle_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();
    Common objCommon = new Common();

    @Test(description = "Verify if pend chase is possible or not", groups = {"Clinical Assignment"})
    public void ClinicalAssignmentPendChaseSingle_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        String status = $x("//tr[1]//td[16]").getText();
        Log.info(status);
        String ABC = "Pended";
        if (status.equals(ABC)) {
            Log.info("in if loop");
            $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
            sleep(2000);
            $x("//span[contains(text(),'Pend Chase(s)')]").click();
            sleep(2000);
            $x("//*[@id=\"notes\"]").click();
            sleep(2000);
            $x("//*[@id=\"notes\"]").sendKeys("For testing purpose");
            //sleep(2000);
            $x("//span[contains(text(),'Save')]").click();
            sleep(1000);

        } else {
            Log.info("in else loop");
            $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
            sleep(2000);
            $x("//span[contains(text(),'Pend Chase(s)')]").click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Pend Code'])[26]/following::label[1]").click();
            sleep(2000);
            $x("//p-dropdownitem//li").click();
            // sleep(2000);
            $x("//textarea[@id='notes']").sendKeys("For testing purpose");
            $x("//span[contains(text(),'Save')]").click();
            sleep(1000);
        }
        String Message =$x("//div[@class='ui-toast-detail']").getText();
        assertText(Message,"Pend saved successfully");
        Selenide.sleep(3000);
        objLoginOut.logout();
    }
}
