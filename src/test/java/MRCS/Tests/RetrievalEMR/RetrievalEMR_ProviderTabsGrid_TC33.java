package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class RetrievalEMR_ProviderTabsGrid_TC33 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify provider tab grid columns", groups = {"Retrieval EMR"})
    public void RetrievalEMR_ProviderTabsGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        logTestStep("Clicked on first AID");
        Common.waitForLoader();
        $(RetrievalEMRRepo.providersTab).click();
        logTestStep("Clicked on Provider Tab");
        Common.waitForLoader();
        RetrievalEMR.ProviderGridColumns();
        objLoginOut.logout();
    }
}
