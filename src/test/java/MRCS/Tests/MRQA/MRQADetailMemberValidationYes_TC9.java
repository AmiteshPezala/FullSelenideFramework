package MRCS.Tests.MRQA;

import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class MRQADetailMemberValidationYes_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();

    @Test(description = "MRQA detail - Member validation/Yes",groups = {"MRQA"})
    public void VerifyMRQAGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objRetrieval.GetUserForMRQA();
        Common.ClickElement(MRQARepo.MRQAChaseId,"MRQA ");
        sleep(5000);
        MRQA.MemberValidationMRQA();
        if($x("//span[contains(text(),'THIS IS A COVER LETTER')]").isEnabled())
        {
            logTestStepPass("Page is in full edit mode & User can perform further actions");
        }else
        {
            logTestStepFail("Page is not in full edit mode & User can not perform further actions");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
