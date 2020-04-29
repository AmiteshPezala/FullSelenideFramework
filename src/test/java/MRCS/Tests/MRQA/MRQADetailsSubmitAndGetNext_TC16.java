package MRCS.Tests.MRQA;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.IntakeRepo;
import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Intake;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class MRQADetailsSubmitAndGetNext_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();
    Clinical objClinical=new Clinical();

    @Test(description = "MRQA detail - Submit and get next",groups = {"MRQA"})
    public void MRQADetailsSubmitAndGetNext() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR to Get Data");
        ClickElement(ClinicalRepo.MRR, "MRR");
        sleep(4000);
        String ChaseId = $(IntakeRepo.MrrFirstChaseId).getText();
        sleep(2000);
        $(CommonRepo.BackwardButton).click();
        sleep(2000);
        MRQA.AssignToLowestPageNumber();
        MRQA.MemberValidationMRQA();
        String DocName=$(MRQARepo.ContainerTitle).getText();
        logTestStep("Document before clicked on SUBMIT & GET NEXT button:"+" "+DocName);
        logTestStep("Entering page numbers and a chase ID ");
        $(MRQARepo.Invoice).click();
        sleep(2000);
        $(MRQARepo.InvoiceBeg).setValue("1");
        sleep(1000);
        $(MRQARepo.InvoiceEnd).setValue("1");
        sleep(1000);
        $(MRQARepo.InvoiceChaseId).setValue(ChaseId);
        sleep(2000);
//        Common.SelectDropdownIndex(MRQARepo.InvoiceDropDown,1);
//        sleep(2000);
        Common.ClickElement(MRQARepo.AcceptButton,"Accept");
        sleep(2000);
        String ExpectedChaseMove="Invoice assign successful";
        sleep(1000);
        String ActualChaseMove=$x("//div[contains(text(),'Invoice assign successful')]").getText();
        assertText(ActualChaseMove,ExpectedChaseMove);
        sleep(1000);
        Intake.ViewPage();
//        String value=$(MRQARepo.PageCount).getText();
//        int count=Integer.parseInt(value);
//        for(int i=1;i<=count;i++){
//            $(MRQARepo.RightForward).click();
//            sleep(5000);
//        }
        $(MRQARepo.SubmitAndNext).click();
        sleep(2000);
        if($(IntakeRepo.YesButton).isDisplayed())
        {
            $(IntakeRepo.YesButton).click();
        }
        else{
            logTestStep("popup not found");
        }
        sleep(5000);
        String NewDocName=$(MRQARepo.ContainerTitle).getText();
        logTestStep("Document after clicked on SUBMIT & GET NEXT button:"+" "+NewDocName);
        if(DocName!=NewDocName)
        {
            logTestStepPass("Document get submitted and next document is presented for user");
        }else{
            logTestStepFail("Document get submitted and but next document is not presented for user");
            Assert.fail("Document get submitted and but next document is not presented for user");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
