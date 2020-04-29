package MRCS.Tests.MemberValidation;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyMemberVerifyEDGEEnrolleID_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Edge enrolle Id is valid and read only.", groups = {"Member Validation"})
    public void VerifyMemberVerifyEDGEEnrolleID_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        sleep(2000);
        objRisk.getUser();
        String EnrollID= $x("//div[@class='container-header']//div[9]//div[2]").getText();
        if(EnrollID.equals("")){
            Assert.fail("Enrollee id is not present");
            //logTestStep("Enrollee Id is = " +  EnrollID);
        }else{
            logTestStep("Enrollee Id is = " +  EnrollID);
        }
        objLoginOut.logout();
    }
}
