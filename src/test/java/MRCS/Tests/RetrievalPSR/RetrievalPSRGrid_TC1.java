package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify if PSR grid loads", groups = {"Retrieval PSR"})
    public void RetrievalPSRTestcase1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Checking weather grid is loaded or not");
        String value= Common.getElementText(RetrievalPSRRepo.Count,120); //getting count form the stat .
        int num = Integer.parseInt(value);//coverting string into int
        if( num > 0){
            sleep(2000);
            logTestStep("Grid loaded successfully");
            Log.info("Grid loaded successfully");
        }else {
            Log.info("No records found ");
            logTestStep("No Records found");
        }
        objLoginOut.logout();
    }
}
