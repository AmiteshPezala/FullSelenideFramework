package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class BulkPendChase_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();
    Common objCommon = new Common();

    @Test(description = "Verify if bulk pend chase is possible or not", groups = {"Clinical Assignment"})
    public void BulkPendChase_TC9() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(5000);
        objClinical.bulkPendChase();
        sleep(2000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//tr[2]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Pend Chase(s)')]").click();
        sleep(2000);
        $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(2000);
        $x("//textarea[@id='notes']").sendKeys("For testing purpose");
        sleep(2000);
        $x("//span[contains(text(),'Save')]").click();
        sleep(2000);
        String Message =$x("//div[@class='ui-toast-detail']").getText();
        assertText(Message,"Pend saved successfully");
        Selenide.sleep(3000);
        objLoginOut.logout();

    }
}
