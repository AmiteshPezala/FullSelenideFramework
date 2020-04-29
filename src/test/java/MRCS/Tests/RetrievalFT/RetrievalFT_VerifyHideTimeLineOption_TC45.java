package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class RetrievalFT_VerifyHideTimeLineOption_TC45 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Hide timeline option", groups = {"Retrieval FT"})
    public void VerifyHideTimeLine() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
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
