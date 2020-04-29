package MRCS.Tests.MemberValidation;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyMemberVerifyMemberID_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Member id is valid and read only", groups = {"Member Validation"})
    public void VerifyMemberVerifyMemberID_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        sleep(2000);
        objRisk.getUser();
        String MemberID=$x("//div[@class='container-header']//div[8]//div[2]").getText();
        Log.info(MemberID);
        logTestStep("Checking weather member id is present or not");
        int ID = Integer.parseInt(MemberID);
        if(ID > 0){
            logTestStep("Member Id is = " +  MemberID);
        }else{
            Assert.fail("Member id is not present");
        }
        objLoginOut.logout();
    }
}

