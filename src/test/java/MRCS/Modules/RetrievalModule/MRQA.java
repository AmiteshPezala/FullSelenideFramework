package MRCS.Modules.RetrievalModule;

import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MRQA {


    public static void NavigateToDocQA() throws Exception {
        Retrieval objRetrieval= new Retrieval();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        logTestStep("Clicking on Doc QA link");
        $(RetrievalRepo.MRQA).click();
        Log.info("Clicked on Doc QA");
        sleep(4000);
    }
    public static void NavigateToDocumentPage() throws Exception {
        Common.ClickElement(MRQARepo.MRQAChaseId,"MRQA");
        sleep(3000);

    }
    public static void VerifyDocument() throws Exception {
        Common.ClickElement(MRQARepo.ViewSource,"View Source");
        sleep(2000);
        String docName=$(MRQARepo.Description).getText();
        if($(MRQARepo.Description).isDisplayed())
        {
            logTestStep("Document ID and Name:"+" "+docName);
            logTestStepPass("Document ID and name is displayed");
        }else
        {
            logTestStepFail("Document ID and name is not displayed");
            Assert.fail("Document ID and name is not displayed");
        }
    }
    public static void MemberValidationMRQA() throws Exception {
        Common.ClickElement(MRQARepo.YesButton,"Yes Button");
        sleep(1000);
        Common.ClickElement(MRQARepo.SubmitButton,"Yes Button");
        sleep(1000);
        String ExpectedMemberValidation = "Member Validation Completed";
        String ActualMemberValidation = $x("//div[contains(text(),'Member Validation Completed')]").getText();
        sleep(1000);
        assertText(ActualMemberValidation,ExpectedMemberValidation);
        sleep(2000);
    }
    public static void AssignToUser() throws Exception {
        String User=Common.GetUserName();
        System.out.println(User);
        MRQA.NavigateToDocQA();
        sleep(2000);
        Common.ClickElement(MRQARepo.FirstCheckBox,"Selecting first checkbox");
        Common.ClickElement(MRQARepo.AssignChases,"Assign");
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(User);
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ENTER);
        sleep(2000);
        $(MRQARepo.AssignButton).click();
        String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
        Common.assertText(GetToasterMsg, "Assigned Successfully.");
        sleep(2000);
    }
    public static void UnAssignUser() throws Exception {
        sleep(2000);
        Common.ClickElement(MRQARepo.FirstCheckBox,"Selecting first checkbox");
        $(MRQARepo.UnAssign).click();
        String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
        Common.assertText(GetToasterMsg,"Unassigned Successfully.");
        sleep(2000);
    }
    public static void ReadOnlyView()
    {
        sleep(2000);
        if($(MRQARepo.ReadOnlyView).waitUntil(visible, DEFAULT_WAIT).isDisplayed())
        {
            logTestStepPass("Document is in readonly mode");
        }
        else
        {
            logTestStepFail("Document is not in readonly mode");
            Assert.fail("Document is not in readonly mode");
        }
    }
    public static void MemberValidationAsNo() throws Exception {
        Common.ClickElement(MRQARepo.NoButton,"Yes Button");
        sleep(1000);
        $(MRQARepo.PageNumber).setValue("1");
        sleep(1000);
        Common.SelectDropdownIndex(MRQARepo.DropDown,2);
        sleep(2000);
        $(MRQARepo.SubmitButton).click();
        String ExpectedMemberValidation = "Member Validation Completed";
        String ActualMemberValidation = $x("//div[contains(text(),'Member Validation Completed')]").getText();
        sleep(1000);
        assertText(ActualMemberValidation,ExpectedMemberValidation);
        sleep(2000);
    }
    public static void AssignToLowestPageNumber() throws Exception {
        String User=Common.GetUserName();
        System.out.println(User);
        MRQA.NavigateToDocQA();
        sleep(2000);
        ElementsCollection rows=$$(".ui-table table tbody tr");
        if(rows.isEmpty())
        {
            //No row found
            logTestStep("No row found");
        }
        SelenideElement rowToClick =null;
        int lowestPageNumberValue =5000;

        for (SelenideElement row : rows) {
            int pageNumber=Integer.parseInt(row.$("td",16).text());
            if(pageNumber <lowestPageNumberValue){
                rowToClick =row;
                lowestPageNumberValue=pageNumber;
            }
        }
        //At the end we have a Row with lowest page number

        //Now click on chase Id
        rowToClick.$("td",0).click();
        Selenide.sleep(2000);
        //Common.ClickElement(MRQARepo.FirstCheckBox,"Selecting first checkbox");
        Common.ClickElement(MRQARepo.AssignChases,"Assign");
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(User);
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ENTER);
        sleep(2000);
        $(MRQARepo.AssignButton).click();
        String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
        Common.assertText(GetToasterMsg, "Assigned Successfully.");
        sleep(2000);
        rowToClick.$("td",1).click();
        sleep(3000);
    }
    public static void BulkAssignToUser() throws Exception {
        String User=Common.GetUserName();
        System.out.println(User);
        MRQA.NavigateToDocQA();
        sleep(2000);
        $(".ui-chkbox-box",0).click();
        Common.ClickElement(MRQARepo.AssignChases,"Assign");
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(User);
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ENTER);
        sleep(2000);
        $(MRQARepo.AssignButton).click();
        String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
        Common.assertText(GetToasterMsg, "Assigned Successfully.");
        sleep(2000);
    }
    public static void BulkUnAssignUser() throws Exception {
        sleep(2000);
        $(".ui-chkbox-box",0).click();
        $(MRQARepo.UnAssign).click();
        String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
        Common.assertText(GetToasterMsg,"Unassigned Successfully.");
        sleep(2000);
    }
}
