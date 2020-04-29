package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.TestData.ReveleerTestData;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalEMREditAccessInfo_TC25 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();
    ReveleerTestData objRev=new ReveleerTestData();

    @Test(description = "Verify User can edit access info", groups = {"Retrieval EMR"})
    public void RetrievalEMREditAccessInfo() throws Exception {
        logTestStep("Log in to application");
        objRev.GetData("Retrieval");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        waitForPageLoadToComplete();
        sleep(5000);
        //$(RetrievalEMRRepo.AccessInfo).click();
        $(CommonRepo.BackwardButton).click();
        $(RetrievalEMRRepo.EditAccessInfo).click();
        sleep(2000);
        $(RetrievalEMRRepo.AdminContactName).setValue(objRev.getAdminContact());
        sleep(1000);
        $(RetrievalEMRRepo.AdminPhoneNumber).setValue(objRev.getPhone_Number());
        $(RetrievalEMRRepo.ITContactName).setValue(objRev.getIT_Contact());
        sleep(1000);
        $(RetrievalEMRRepo.ITPhoneNumber).setValue(objRev.getPhone_Number());
        $(RetrievalEMRRepo.EMRSystem).setValue(objRev.getEMR_System());
        $(RetrievalEMRRepo.EditNotes).setValue(objRev.getTextArea());
        sleep(2000);
        $x("//*[text()='SAVE']").click();
        String getMsg=Common.getElementText(RetrievalEMRRepo.ToasterMessage,10);
        Common.assertText(getMsg,"Access Information successfully edited.");
        objLoginOut.logout();
    }
}
