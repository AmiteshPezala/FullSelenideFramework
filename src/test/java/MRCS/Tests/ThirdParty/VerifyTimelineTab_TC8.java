package MRCS.Tests.ThirdParty;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyTimelineTab_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that event is added in timeline tab or not.", groups = {"Third party"})
    public void VerifyTimelineTab_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.AssigningToLoggedInUser();
        sleep(2000);
        RetrievalPSR.SendEmail();
        sleep(2000);
        $x("//div[contains(text(),'Timeline')]").click();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Log.info(currentDate);
        String DateOfTab=$x("//div[@class='header bold']").getText();
        Log.info("DateOfTab = " + DateOfTab);
        sleep(2000);
        if(currentDate.equals(DateOfTab)){
            logTestStepPass("Current event added in the timeline tab");
        }else{
            logTestStepFail("Current event not added in the timeline tab");
        }
       objLoginOut.logout();
    }
}
