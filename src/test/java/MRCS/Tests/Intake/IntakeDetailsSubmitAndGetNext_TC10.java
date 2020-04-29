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
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class IntakeDetailsSubmitAndGetNext_TC10 extends TestBase {
    LoginOut objLoginOut=new LoginOut();
    WaitTool objWait=new WaitTool();
    Retrieval objRetrieval=new Retrieval();
    Clinical objClinical=new Clinical();

    @Test(description = "Intake Details - Submit",groups = {"Intake"})
    public void VerifyIntakeDetails() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR to Get Data");
        Common.ClickElement(ClinicalRepo.MRR,"MRR Link");
        sleep(10000);
        String ChaseId=$(IntakeRepo.MrrFirstChaseId).getText();
        Intake.NavigateToDocIntakePage();
        Intake.LowestPageNumber();
        String DocName=$x("//h3[@class='container-title']").getText();
        logTestStep("Document before clicked on SUBMIT & GET NEXT button:"+" "+DocName);
        Common.RefreshPage();
        Common.ClickElement(IntakeRepo.CoverLetter,"Cover Letter");
        sleep(1000);
        $(IntakeRepo.CoverBegPage).sendKeys("1");
        sleep(1000);
        $(IntakeRepo.CoverEndPage).sendKeys("1");
        sleep(1000);
        $(IntakeRepo.CoverChaseId).sendKeys(ChaseId);
        sleep(1000);
        Intake.VerifySuccessfulAssign();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();",$x("//div[contains(text(),'DOCUMENTS SECTION')]"));
        sleep(2000);
        String ActualFileName=$x("(//div[@class='filename'])[1]").getText();
        sleep(2000);
        String ExpectedFileName="Chase"+" "+ChaseId+" "+"CoverSheet (pg 1 - 1)";
        sleep(2000);
        assertText(ExpectedFileName,ActualFileName);
        Intake.ViewPage();
        $x("//span[contains(text(),'SUBMIT & GET NEXT')]").click();
        sleep(2000);
        if($(IntakeRepo.YesButton).isDisplayed())
        {
            $(IntakeRepo.YesButton).click();
        }
        else{
            logTestStep("popup not found");
        }
        sleep(5000);
        String NewDocName=$x("//h3[@class='container-title']").getText();
        logTestStep("Document after clicked on SUBMIT & GET NEXT button:"+" "+NewDocName);
        if(DocName!=NewDocName)
        {
            logTestStep("Document get submitted and next document is presented for user");
        }else{
          Assert.fail("Document get submitted and but next document is not presented for user");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
