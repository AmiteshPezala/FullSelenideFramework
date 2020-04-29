package MRCS.Tests.ThirdParty;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifySendEmail_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify send email functionality.", groups = {"Third party"})
    public void VerifySendEmail_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.AssigningToLoggedInUser();
        sleep(2000);
        RetrievalPSR.SendEmail();
        sleep(2000);
        //verifying that email event added in contact history
        DateFormat dateFormat = new SimpleDateFormat("M/d/YY");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Log.info(currentDate);
        Selenide.sleep(2000);
        $x("//div[contains(text(),'Contact History')]").click();
        sleep(2000);
        String EventDate=$x("//tr[1]//td[2]").getText();
        Log.info("EventDate = " + EventDate);
        if(EventDate.equals(currentDate)){
            logTestStepPass("Email event added successfully in contact history");
        }else{
            logTestStepFail("Email event not added in contact history");
        }
        sleep(2000);
        objLoginOut.logout();








    }
}
