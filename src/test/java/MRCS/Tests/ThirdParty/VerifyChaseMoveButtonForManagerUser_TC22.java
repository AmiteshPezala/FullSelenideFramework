package MRCS.Tests.ThirdParty;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyChaseMoveButtonForManagerUser_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that for manager user button name is chase move or not.", groups = {"Third party"})
    public void VerifyChaseMoveButtonForManagerUser_TC22() throws Exception {
        logTestStep("Log in as a manager user to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_Manager);
        Common.PopUp();
        $(CommonRepo.Loader).waitUntil(Condition.disappear, DEFAULT_WAIT);
        sleep(3000);
        RetrievalPSR.NavigateToPSR();
        $(CommonRepo.Loader).waitUntil(Condition.disappear, DEFAULT_WAIT);
        sleep(3000);
        logTestStep("Clicked on the first AID.");
        $x("//tr[1]//td[2]").click();
        sleep(2000);
        logTestStep("Selecting the first chase ID.");
        $x("//tr[1]//td[1]").click();
        sleep(2000);
        logTestStep("Verifying the button of 'move chase'.");
        String ButtonName=$x("//span[contains(text(),'Move Chase(s)')]").getText();
        Log.info(ButtonName);
        if(ButtonName.equals("MOVE CHASE(S)")){
            logTestStepPass("For manager button name is 'Move chase'.");
        }else{
            logTestStepFail("For manager button name is not 'Move chase'.");
        }
        objLoginOut.logout();
    }
}
