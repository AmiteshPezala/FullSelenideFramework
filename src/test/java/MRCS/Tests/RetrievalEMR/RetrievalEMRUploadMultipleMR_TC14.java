package MRCS.Tests.RetrievalEMR;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalEMRUploadMultipleMR_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Upload Multiple MR", groups = {"Retrieval EMR"})
    public void RetrievalEMRUploadMultipleMR() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        logTestStep("Clicked on address id");
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID,"First Record");
        sleep(3000);
        Retrieval.MultipleUpload();
        objLoginOut.logout();
    }
}
