package MRCS.Tests.MRQA;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.RetrievalRepo.IntakeRepo;
import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Intake;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class MRQADetailSubmit_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();
    Clinical objClinical = new Clinical();

    @Test(description = "MRQA detail - Submit", groups = {"MRQA"})
    public void VerifyMRQAGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Click On Clinical Link");
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR to Get Data");
        ClickElement(ClinicalRepo.MRR,"MRR");
        sleep(4000);
        String ChaseId = $(IntakeRepo.MrrFirstChaseId).getText();
        sleep(2000);
        Common.ClickElement(MRQARepo.BackwardButton,"Backward button");
        sleep(2000);
        logTestStep("Getting user data & clicking on Retrieval link");
//        objRetrieval.Get();
//        sleep(5000);
//        ElementsCollection rows=$$(".ui-table table tbody tr");
//        if(rows.isEmpty())
//        {
//            //No row found
//            logTestStep("No row found");
//        }
//        SelenideElement rowToClick =null;
//        int lowestPageNumberValue =5000;
//
//        for (SelenideElement row : rows) {
//            int pageNumber=Integer.parseInt(row.$("td",16).text());
//            if(pageNumber <lowestPageNumberValue){
//                rowToClick =row;
//                lowestPageNumberValue=pageNumber;
//            }
//        }
//        //At the end we have a Row with lowest page number
//
//        //Now click on chase Id
//        rowToClick.$("td",1).click();
//        sleep(5000);
//        Common.ClickElement(MRQARepo.YesButton,"Yes Button");
//        sleep(1000);
//        Common.ClickElement(MRQARepo.SubmitButton,"submit Button");
//        sleep(1000);
//        String ExpectedMemberValidation = "Member Validation Completed";
//        String ActualMemberValidation = $x("//div[contains(text(),'Member Validation Completed')]").getText();
//        sleep(1000);
//        assertText(ActualMemberValidation, ExpectedMemberValidation);
        MRQA.AssignToLowestPageNumber();
        MRQA.MemberValidationMRQA();
        sleep(2000);
        logTestStep("Entering page numbers and a chase ID ");
        //$x("//span[@class='pageId']").getText();
        Common.waitForPageLoadToComplete();
        $(MRQARepo.Invoice).click();
        sleep(3000);
        $(MRQARepo.InvoiceBeg).sendKeys("1");
        sleep(1000);
        $(MRQARepo.InvoiceEnd).sendKeys("1");
        sleep(1000);
        $(MRQARepo.InvoiceChaseId).sendKeys(ChaseId);
        sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        js.executeScript("arguments[0].scrollIntoView();", $(MRQARepo.InvoiceDropDown));
//        Select InvoiceDropDown = new Select($(MRQARepo.InvoiceDropDown));
//        InvoiceDropDown.selectByVisibleText("Invoice");
        Common.ClickElement(MRQARepo.AcceptButton,"Accept");
        sleep(2000);
        String ExpectedInvoice = "Invoice assign successful";
        sleep(1000);
        String ActualInvoice = $x("//div[contains(text(),'Invoice assign successful')]").getText();
        assertText(ActualInvoice, ExpectedInvoice);
        sleep(2000);
        Intake.ViewPage();
        sleep(2000);
        $x("(//span[contains(text(),'SUBMIT')])[1]").click();
        sleep(2000);
        if ($(MRQARepo.YesButton).isDisplayed()) {
            Common.ClickElement(MRQARepo.YesButton,"Yes Button");
        } else {
            logTestStep("popup not found");
        }
        sleep(5000);
        String ActualPage = "RETRIEVAL";
        String ExpectedPage = $x("//div[contains(text(),'RETRIEVAL')]").getText();
        assertText(ExpectedPage, ActualPage);
        sleep(2000);
        objLoginOut.logout();
    }
}

