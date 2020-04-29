package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalAssignment_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify if assignment grid loads", groups = {"Retrieval Assignment"})
    public void RetrievalEMRTC1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        String AID = $x("//tr[1]//td[2]").getText();
        int num = Integer.parseInt(AID);
        if( num > 0 )
        {
            logTestStep("Grids Loaded Sucessfully");
        }else{
            logTestStep("No records available");
        }
    }
}
