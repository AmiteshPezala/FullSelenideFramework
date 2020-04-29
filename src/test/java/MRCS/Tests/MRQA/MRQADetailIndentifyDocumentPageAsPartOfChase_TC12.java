package MRCS.Tests.MRQA;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.IntakeRepo;
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

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class MRQADetailIndentifyDocumentPageAsPartOfChase_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();
    Clinical objClinical=new Clinical();

    @Test(description = "MRQA detail- Indentify document page as part of chase",groups = {"MRQA"})
    public void VerifyMRQAGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR to Get Data");
        ClickElement(ClinicalRepo.MRR,"MRR");
        sleep(4000);
        String ChaseId=$(IntakeRepo.MrrFirstChaseId).getText();
        sleep(2000);
        $(CommonRepo.BackwardButton).click();
        sleep(2000);
        logTestStep("Getting user data & clicking on Retrieval link");
        objRetrieval.GetUserForMRQA();
        Common.ClickElement(MRQARepo.MRQAChaseId,"Chase ID");
        sleep(5000);
        MRQA.MemberValidationMRQA();
        logTestStep("Entering page numbers and a chase ID ");
        $x("//span[contains(text(),'THIS PAGE IS PART OF A CHASE')]").click();
        sleep(3000);
        $x("//input[@formcontrolname='chaseBegPage']").sendKeys("1");
        sleep(1000);
        $x("//input[@formcontrolname='chaseEndPage']").sendKeys("1");
        sleep(1000);
        $x("//input[@formcontrolname='assignChaseId']").sendKeys(ChaseId);
        sleep(4000);
        Common.ClickElement(MRQARepo.AcceptButton,"Accept");
        sleep(2000);
        String ExpectedChaseMove="Chase move successful";
        sleep(1000);
        String ActualChaseMove=$x("//div[contains(text(),'Chase move successful')]").getText();
        assertText(ActualChaseMove,ExpectedChaseMove);
        sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();",$x("//div[contains(text(),'DOCUMENTS SECTION')]"));
        sleep(2000);
        Common.ClickElement(MRQARepo.RestoreButton,"Restore");
        sleep(2000);
        //objLoginOut.logout();
    }
}
