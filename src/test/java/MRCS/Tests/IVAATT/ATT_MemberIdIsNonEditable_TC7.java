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

public class ATT_MemberIdIsNonEditable_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify member ID is a non editable field.", groups = {"IVA ATT"})
    public void ATT_MemberIdIsNonEditable_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        objRisk.membervalidation();
        sleep(2000);
        if($x("(//label[contains(text(),'Member ID')]//following::input)[1]").isEnabled()){
            logTestStepFail("Member Id field is editable.");
        }else{
            logTestStepPass("Member id field is non editable.");
        }
        objLoginOut.logout();
    }
}
