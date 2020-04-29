package MRCS.Tests.RetrievalFT;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalFTUploadMultipleMR_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Upload Multiple MR", groups = {"Retrieval FT"})
    public void RetrievalFTUploadMultipleMR() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        logTestStep("Clicked on address id");
        Common.ClickElement(RetrievalFTRepo.FirstFTAID,"First Record");
        sleep(3000);
        Retrieval.MultipleUpload();
        objLoginOut.logout();
    }
}
