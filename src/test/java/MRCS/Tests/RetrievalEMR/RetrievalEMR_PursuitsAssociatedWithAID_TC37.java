package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalEMR_PursuitsAssociatedWithAID_TC37 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify pursuits related to the AID chases are available in pursuit tab", groups = {"Retrieval EMR"})
    public void RetrievalEMR_PursuitsAssociatedWithAID() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
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
