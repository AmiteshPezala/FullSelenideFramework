package MRCS.Tests.IVAATT;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAATT;
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

public class ATT_VerifyMemberValidationReasons_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Necessary reason codes are listed and user can select any reason from the list.Chases go back from MRR/OR1/OR2 as per the reason selected", groups = {"IVA ATT"})
    public void ATT_VerifyMemberValidationReasons_TC4() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        $x("//span[contains(text(),'No')]").click();
        sleep(2000);
        logTestStep("Select option as No");
        $x("(//div[contains(text(),'Member Information')]//preceding::input)[2]").setValue("1");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='No'])[1]/following::select[1]").click();
        sleep(2000);
        if( $x("//option[contains(text(),'No Encounter Date of Service Matches Claim in Medical Record')]").isDisplayed()){
            logTestStepPass("All reason codes are listed in the drop down.");
        }else{
            logTestStepFail("Reason codes are not available in the drop down.");
        }
        $x("//option[contains(text(),'No Encounter Date of Service Matches Claim in Medical Record')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        $x("//span[contains(text(),'Submit')]").click();
        sleep(2000);
        String PageName=$x("//div[@class='header bold']").getText();
        assertText(PageName, "MRR");
        sleep(2000);
        logTestStep("Page successfully redirect to MRR page.");
        objLoginOut.logout();
    }
}
