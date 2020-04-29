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

public class ENR_VerifyDateValidation_TC36 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that validation message is displayed if start date is greater than end date.", groups = {"IVA ENR"})
    public void ENR_VerifyDateValidation_TC36() throws Exception {
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
        String AdminVauleDate1 =$x("(//div[contains(text(),'Enrollment From Date')]//following::input)[3]").getValue();
        Log.info(AdminVauleDate1);
        String AdminVauleDate2 =$x("(//div[contains(text(),'Enrollment Thru Date')]//following::input)[3]").getValue();
        Log.info(AdminVauleDate2);
        $x("(//div[contains(text(),'Enrollment From Date')]//following::button[@class='control__delete ng-star-inserted'])").click();
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment From Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes - With Transformation')])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment From Date')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment From Date')]//following::input)[2]").setValue(AdminVauleDate2);
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);

        $x("(//div[contains(text(),'Enrollment Thru Date')]//following::button[@class='control__delete ng-star-inserted'])").click();
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment Thru Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes - With Transformation')])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment Thru Date')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment Thru Date')]//following::input)[2]").setValue(AdminVauleDate1);
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        if (WebDriverRunner.getWebDriver().getPageSource().contains("EnrollmentEndDate, PageNumber, Confirm  must be provided")) {
            logTestStepPass("Validation message displayed");
        } else {
            logTestStepFail("Validation message not displayed");
        }
        objLoginOut.logout();
    }
}
