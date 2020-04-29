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


public class RetrievalEMR_ProviderAssociatedWithAID_TC32 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify the providers associated with the AID is listed in provider tab", groups = {"Retrieval EMR"})
    public void RetrievalEMR_ProviderAssociatedWithAID() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        Common.waitForLoader();
        $(RetrievalEMRRepo.providersTab).click();
        Common.waitForLoader();
        if($$x("//tr[1]//td[3]").filter(Condition.visible).last().isDisplayed())
        {
            logTestStepPass("All the providers associated with the AID is available on this tab");
        }else
        {
            logTestStepFail("All the providers associated with the AID is not available on this tab");
        }
        objLoginOut.logout();
    }
}
