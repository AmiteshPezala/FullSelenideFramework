package MRCS.Tests.MRQA;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.*;

public class MRQADetailsIdentifyCoverLetter_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Clinical objClinical=new Clinical();
    Retrieval objRetrieval=new Retrieval();

    @Test(description = "Verify MRQA detail - Identify document page as cover letter",groups = {"MRQA"})
    public void MRQADetailsIdentifyCoverLetter() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR to Get Data");
        ClickElement(ClinicalRepo.MRR,"MRR");
        sleep(5000);
        String ChaseId=$x("//tr[2]//td[2]//div[1]").getText();
        sleep(2000);
        logTestStep("Clicking on First chase id");
        ClickElement(By.xpath("//tr[2]//td[2]"),"Selecting Chase id");
        logTestStep("Clicking on Chart");
        ClickElement(RetrievalRepo.Chart,"Click on Chart");
        sleep(5000);
        String DocId=$(MRQARepo.DocId).getText();
        System.out.println(DocId);
        if($x("//i[@class='pi pi-times']").isDisplayed())
        {
            $x("//i[@class='pi pi-times']").click();
        }
        else
        {
            System.out.println("else");
        }
        $(CommonRepo.BackwardButton).click();
        sleep(2000);
        logTestStep("Getting user data & clicking on Retrieval link");
        //objRetrieval.GetUserForMRQA();
        MRQA.AssignToUser();
        MRQA.NavigateToDocumentPage();
        MRQA.MemberValidationMRQA();
        sleep(2000);
        $(MRQARepo.CoverLetter).click();
        sleep(1000);
        $(MRQARepo.CoverLetterBeg).setValue("1");
        sleep(1000);
        $(MRQARepo.CoverLetterEnd).setValue("1");
        sleep(1000);
        $(MRQARepo.CoverLetterChaseId).setValue(ChaseId);
        sleep(2000);
        String DocIdMRQA=$(MRQARepo.DocId).getText();
        System.out.println(DocIdMRQA);
        $(MRQARepo.AcceptButton).click();
        sleep(2000);
        logTestStep("Clicking on Clinical link");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        logTestStep("Clicking on MRR");
        ClickElement(ClinicalRepo.MRR, "Clicking on MRR");
        logTestStep("Clicking on first record");
        waitForPageLoadToComplete();
        sleep(4000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $(ProjectsRepo.ChaseId).click();
        sleep(2000);
        $(ProjectsRepo.EnterChaseId).setValue(ChaseId);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        Common.SelectChaseAndOpenChart();
        sleep(5000);
        Common.RefreshPage();
        sleep(5000);
        String DocIdMRR=$(MRQARepo.DocId).getText();
        System.out.println(DocIdMRR);
        sleep(2000);
        if(DocIdMRQA.equals(DocIdMRR))
        {
            logTestStepPass("Selected page is assigned as a cover letter for the target chase ID.");
        }
        else {
            logTestStepFail("Selected page is not assigned as a cover letter for the target chase ID.");
            Assert.fail("Selected page is not assigned as a cover letter for the target chase ID.");
        }
        objLoginOut.logout();
    }
}
