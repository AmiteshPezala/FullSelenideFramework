package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ENR_MemberValidationNo_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "User can select No option User need to select a reason. Upon submission chase is taken back to MRR.", groups = {"IVA ENR"})
    public void ENR_MemberValidationNo_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        $x("//span[contains(text(),'No')]").click();
        sleep(2000);
        logTestStep("Select option as No");
        $x("(//h3[contains(text(),'Enrollee Identification')]//preceding::input)[2]").setValue("1");
        sleep(2000);
        $x("//select[@class='input input__reasons ng-untouched ng-pristine ng-invalid']").click();
        sleep(2000);
        $x("//option[contains(text(),'Incorrect Member – Entire Chart')]").click();
        if($x("//span[contains(text(),'Submit')]").isEnabled()){
            logTestStepPass("Submit button is enabled after selecting reason");
        }else{
            logTestStepFail("Submit button is still disabled");
            Assert.fail("Submit button is still disabled");
        }
        objRisk.ChecklistForART();
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
