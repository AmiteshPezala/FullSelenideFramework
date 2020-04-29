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

public class RetrievalEMR_ProviderTabsExportFunctionality_TC34 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify export all functionality", groups = {"Retrieval EMR"})
    public void RetrievalEMR_ProviderTabsExportFunctionality() throws Exception {
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
        sleep(2000);
        $$(RetrievalEMRRepo.ExportAll).filter(Condition.visible).last().click();
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
