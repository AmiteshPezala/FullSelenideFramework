package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.TestData.ReveleerTestData;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class RetrievalEMRPendCreationChaseUpload_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();
    ReveleerTestData objRev=new ReveleerTestData();

    @Test(description = "Verify Pend creation chase upload", groups = {"Retrieval EMR"})
    public void RetrievalEMRMoveChase() throws Exception {
        logTestStep("Log in to application");
        objRev.GetData("Retrieval");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        waitForPageLoadToComplete();
        sleep(5000);
        $(RetrievalRepo.Upload).click();
        $(RetrievalEMRRepo.FirstChaseInUpload).click();
        $(RetrievalEMRRepo.SelectAllNo).click();
        $(RetrievalEMRRepo.PendThisChase).click();
        sleep(10000);
        if($(RetrievalEMRRepo.AlReadyPended).isDisplayed())
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
