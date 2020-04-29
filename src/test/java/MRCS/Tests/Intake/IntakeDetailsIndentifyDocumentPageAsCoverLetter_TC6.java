package MRCS.Tests.Intake;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.RetrievalRepo.IntakeRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.Intake;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class IntakeDetailsIndentifyDocumentPageAsCoverLetter_TC6 extends TestBase {
    LoginOut objLoginOut=new LoginOut();
    WaitTool objWait=new WaitTool();
    Retrieval objRetrieval=new Retrieval();
    Clinical objClinical=new Clinical();

    @Test(description = "Intake Details - Indentify document page as cover letter",groups = {"Intake"})
    public void VerifyIntakeDetails() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR to Get Data");
        Common.ClickElement(ClinicalRepo.MRR,"MRR Link");
        sleep(10000);
        String ChaseId=$(IntakeRepo.MrrFirstChaseId).getText();
        Intake.NavigateToDocIntakePage();
        Common.ClickElement(IntakeRepo.IntakeFileName,"File Name");
        sleep(5000);
        Common.ClickElement(IntakeRepo.CoverLetter,"Cover Letter");
        sleep(1000);
        $(IntakeRepo.CoverBegPage).sendKeys("1");
        sleep(1000);
        $(IntakeRepo.CoverEndPage).sendKeys("1");
        sleep(1000);
        $(IntakeRepo.CoverChaseId).sendKeys(ChaseId);
        sleep(1000);
        Intake.VerifySuccessfulAssign();
        sleep(2000);
        Common.ClickElement(IntakeRepo.DeleteIcon,"Delete Icon");
        sleep(4000);
        objLoginOut.logout();
    }
}
