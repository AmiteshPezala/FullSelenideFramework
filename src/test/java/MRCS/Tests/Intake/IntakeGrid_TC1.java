package MRCS.Tests.Intake;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class IntakeGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval=new Retrieval();

    @Test(description = "Verify if Intake Grid loads",groups = {"Intake"})
    public void VerifyIntakeGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
       //objWait.implicitwait();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        logTestStep("Clicking on Doc Intake link");
        $(RetrievalRepo.DocIntake).click();
        Log.info("Clicked on Doc Intake");
        sleep(2000);
        logTestStep("Verifying Intake Grid loads");
        String count = $x("//span[@class='activeAssignedTo']").getText();
        int num = Integer.parseInt(count);
        System.out.println(num);
        if (num > 0) {
            String field = $x("//th[@title='Note']").getText();
            sleep(2000);
            assertText(field, "Note");
            logTestStep("Intake grid loaded successfully");
        } else {
            Log.info("no record found");
            logTestStep("No Record found");
        }
        objLoginOut.logout();
    }
}
