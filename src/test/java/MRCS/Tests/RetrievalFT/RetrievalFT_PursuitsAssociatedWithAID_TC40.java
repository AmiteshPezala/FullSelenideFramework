package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalFT_PursuitsAssociatedWithAID_TC40 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify pursuits related to the AID chases are available in pursuit tab", groups = {"Retrieval FT"})
    public void VerifyPursuitsAssociatedWithAID() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        Common.waitForLoader();
        $(RetrievalEMRRepo.pursuitsTab).click();
        Common.waitForLoader();
        if($x("//*[contains(text(),'DOB')]").isDisplayed())
        {
            logTestStepPass("Pursuits associated with the chases are listed");
        }else
        {
            logTestStepFail("Pursuits not associated with the chases are listed");
        }
        objLoginOut.logout();
    }
}
