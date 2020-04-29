package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalEMRGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify if EMR grid loads", groups = {"Retrieval EMR"})
    public void RetrievalEMRTestcase1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        logTestStep("Checking weather grid is loading or not");
        String value= Common.getElementText(RetrievalEMRRepo.Count,120);//getting count form the stat .
        int num = Integer.parseInt(value);//coverting string into int
        System.out.println(num);
        //checking weather data is available in the grid
        if( num > 0){
            sleep(2000);
            String text = $x("//tr[1]//td[16]//span[2]").getText();
            assertText(text,"EMR");
            logTestStep("EMR grid loaded successfully");
        }else {
            Log.info("No records found ");
            logTestStep("No Record found");
        }
        objLoginOut.logout();
    }
}
