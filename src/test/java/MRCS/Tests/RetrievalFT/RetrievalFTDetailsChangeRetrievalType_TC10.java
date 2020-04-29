package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalFTDetailsChangeRetrievalType_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather retrieval type is changed or not. ", groups = {"Retrieval FT"})
    public void RetrievalFTChangeRetrievalType() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        String AID = $(RetrievalFTRepo.FirstFTAID).getText();
        logTestStep("Clicked on address id");
        Common.ClickElement(RetrievalFTRepo.FirstFTAID,"");
        sleep(5000);
        logTestStep("Changing retrieval method");
        RetrievalFT.ChangingRetrievalMethod();
        logTestStep("Checking weather address id is removed from the grid or not");
        Common.ClickElement(RetrievalRepo.FT,"FT");
        String NewAID = $(RetrievalFTRepo.FirstFTAID).getText();
        if(AID.equals(NewAID)){
            logTestStep("Address is not removed from the list");
        }
        else{
            logTestStep("Address is removed from the list");
        }
        objLoginOut.logout();
    }
}
