package MRCS.Tests.MRQA;

import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MRQADetailHideSource_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();

    @Test(description = "MRQA detail -Hide Source",groups = {"MRQA"})
    public void VerifyMRQAGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.NavigateToDocQA();
        MRQA.NavigateToDocumentPage();
        MRQA.VerifyDocument();
        sleep(2000);
        logTestStep("Clicking on Hide button");
        Common.ClickElement(MRQARepo.HideSource,"Hide Source");
        sleep(2000);
        if($(MRQARepo.Description).isDisplayed())
        {
            //logTestStep("Document ID and Name:"+" "+docName);
            logTestStepFail("Document ID and name is not hidden now");
            Assert.fail("Document ID and name is not hidden now");
        }else
        {
            logTestStep("Document ID and name is hidden now");
            logTestStepPass("Document ID and name is hidden now");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
