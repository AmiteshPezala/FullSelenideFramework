package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class RetrievalEMR_VerifyHideTimeLine_TC41 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Hide timeline option", groups = {"Retrieval EMR"})
    public void RetrievalEMR_VerifyHideTimeLine() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        Common.waitForLoader();
        $x("//*[text()='HIDE TIMELINE']").click();
        if($x("//span[text()='ADDRESS TIMELINE']").waitUntil(Condition.appear,10000).isDisplayed())
        {
            logTestStepPass("Timeline section is hidden");
        }else
        {
            logTestStepFail("Timeline section is not hidden");
            Assert.fail("Timeline section is not hidden");
        }
    }
}
