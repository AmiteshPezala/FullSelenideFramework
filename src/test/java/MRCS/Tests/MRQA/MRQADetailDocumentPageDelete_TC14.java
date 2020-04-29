package MRCS.Tests.MRQA;

import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class MRQADetailDocumentPageDelete_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();
    Clinical objClinical=new Clinical();

    @Test(description = "MRQA detail - Document page delete",groups = {"MRQA"})
    public void VerifyMRQAGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Getting user data & clicking on Retrieval link");
//        objRetrieval.GetUserForMRQA();
        MRQA.AssignToUser();
        Common.ClickElement(MRQARepo.MRQAChaseId,"Chase ID");
        sleep(5000);
        MRQA.MemberValidationMRQA();
        logTestStep("Entering page numbers");
        $x("//span[contains(text(),'THIS PAGE SHOULD BE DELETED')]").click();
        sleep(3000);
        $x("//input[@formcontrolname='deleteBegPage']").sendKeys("1");
        sleep(1000);
        $x("//input[@formcontrolname='deleteEndPage']").sendKeys("1");
        sleep(4000);
        Common.ClickElement(MRQARepo.AcceptButton,"Accept");
        sleep(2000);
        String ExpectedDelete = "Delete successful";
        sleep(1000);
        String ActualDelete = $x("//div[contains(text(),'Delete successful')]").getText();
        logTestStep("Verifying chart page get deleted or not");
        assertText(ActualDelete, ExpectedDelete);
        sleep(1000);
        logTestStep("Specified chart pages gets deleted .History of available in document history section");
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'DOCUMENTS SECTION')]"));
        Common.RefreshPage();
        //sleep(2000);
        Common.ClickElement(MRQARepo.RestoreButton,"Restore");
        sleep(2000);
       // objLoginOut.logout();
    }
}
