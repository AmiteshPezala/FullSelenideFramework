package MRCS.Tests.MemberValidation;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MemberValidationVerifyMRDOBfield_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "User can enter member DOB ", groups = {"Member Validation"})
    public void VerifyMemberValidationYes_TC2() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        sleep(2000);
        objRisk.getUser();
        objRisk.membervalidation();
        DateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        String DOB = $x("//input[@id='MedicalRecordDob']").getText();
        Log.info(DOB);
        sleep(2000);
        $x("//input[@id='MedicalRecordDob']").sendKeys(Date1);
        sleep(3000);
        logTestStep("DOB entered successfully");
        objLoginOut.logout();
    }
}
