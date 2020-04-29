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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MRQADetailsChartIcons_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();

    @Test(description = "MRQA detail -Chart Icon",groups = {"MRQA"})
    public void MRQADetailsChartIcons() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.NavigateToDocQA();
        MRQA.NavigateToDocumentPage();
        MRQA.VerifyDocument();
        sleep(2000);
        String docName=$(MRQARepo.ChartIcon).getText();
        if($(MRQARepo.ChartIcon).isDisplayed())
        {
            logTestStep("Chart Icon and Name:"+" "+docName);
            logTestStepPass("Chart Icon and name is displayed");
        }else
        {
            logTestStepFail("Chart Icon and name is not displayed");
            Assert.fail("Chart Icon and name is not displayed");
        }
        objLoginOut.logout();
    }
}
