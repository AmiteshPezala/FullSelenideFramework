package MRCS.Tests.RetrievalFT;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.TestData.ReveleerTestData;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class RetrievalFTPendCreationChaseUpload_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();
    ReveleerTestData objRev=new ReveleerTestData();

    @Test(description = "Verify Pend creation chase upload", groups = {"Retrieval FT"})
    public void RetrievalFTPendCreationChaseUpload() throws Exception {
        logTestStep("Log in to application");
        objRev.GetData("Retrieval");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        Common.ClickElement(RetrievalFTRepo.FirstFTAID, "First Record");
        waitForPageLoadToComplete();
        sleep(5000);
        $(RetrievalRepo.Upload).click();
        $(RetrievalEMRRepo.FirstChaseInUpload).click();
        $(RetrievalEMRRepo.SelectAllNo).click();
        $(RetrievalEMRRepo.PendThisChase).click();
        //sleep(10000);
        if($(RetrievalEMRRepo.AlReadyPended).waitUntil(Condition.appear,DEFAULT_WAIT).isDisplayed())
        {
            System.out.println("If loop");
            logTestStepPass("Chase Already Pended");
        }
        else
        {
            System.out.println("else loop");
            $$(RetrievalEMRRepo.DropDownButton).filter(Condition.visible).get(0).click(); // Pend code
            $$(RetrievalEMRRepo.DropDownValue).filter(Condition.visible).get(2).click(); // selecting value from drop down
            $(RetrievalEMRRepo.TextArea).sendKeys(objRev.getTextArea());
            $(RetrievalEMRRepo.SaveButton).click();
            String Message =$(RetrievalEMRRepo.ToasterMessage).getText();
            assertText(Message,"Pend saved successfully");
            Selenide.sleep(3000);
        }
        objLoginOut.logout();
    }
}
