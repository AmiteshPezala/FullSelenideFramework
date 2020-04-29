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

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ATT_VerifyMemberValidation_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Memeber validation options YES and NO is available. User is required to select one of the options.  Rest of the form is disbale until validation submitted", groups = {"IVA ATT"})
    public void ATT_VerifyMemberValidation_TC1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        $x("(//button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(2000);
        if ($x("(//label[contains(text(),'Edge Enrollee ID')]//following::input)[1]").isEnabled()) {
        logTestStepFail("Member validation is not required");
        }else{
            logTestStepPass("Member validation is required");
        }
        objRisk.membervalidation();
        sleep(2000);
        $x("(//div[contains (text(),'Encounter Details')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::input)[1]").isEnabled()){
            logTestStepPass("Fields are editable");
        }else{
            logTestStepFail("Fields are disabled");
        }
        objLoginOut.logout();
    }
}
