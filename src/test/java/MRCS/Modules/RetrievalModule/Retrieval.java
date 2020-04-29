package MRCS.Modules.RetrievalModule;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.TestData.ReveleerTestData;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.*;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Retrieval {
    WaitTool objWait = new WaitTool();
    ReveleerTestData objReveleer = new ReveleerTestData();
    public void RetrievalLink() throws Exception {
        //objWait.implicitwait();
        //sleep(5000);
        waitForElementToBeClickable(LoginOutRepo.NavigationBar).click();
        Log.info("clicked on Navigation bar");
        //sleep(2000);
        waitForElementToBeClickable(RetrievalRepo.RetrievalLink).click();
        Log.info("Clicked on Retrieval Link");
        waitForPageLoadToComplete();
    }
    public void RetrievalAID() throws Exception {
        //objWait.implicitwait();
        ClickElement(RetrievalRepo.AIDFirstRow,"First row");
        sleep(2000);
        ClickElement(RetrievalRepo.EditAddress,"Edit Address");
        sleep(2000);
        $(RetrievalRepo.GroupName).setValue("Test");
        $(RetrievalRepo.Email).setValue("test@yopmail.com");
        $(RetrievalRepo.Phone).setValue("9009009009");
        $(RetrievalRepo.Fax).setValue("7878787450");
        $(RetrievalRepo.ContactName).setValue("TestName");
        ClickElement(RetrievalRepo.ApplyEdits,"Apply edit");
        Log.info("clicked on Apply Edit button");
        waitForPageLoadToComplete();
    }
    public void Appointment() throws Exception {
        //sleep(3000);
        objReveleer.GetData("Retrieval");
        ClickElement(RetrievalRepo.AvlUserDropdown,"User dropdown");
        $$(RetrievalRepo.SelectUser).filter(Condition.visible).get(2).click();
        //ClickElement(RetrievalRepo.AddAppointment,"Add Appointment");
        ClickElement(RetrievalRepo.DateDropdown,"Date drop down");
        ClickElement(RetrievalRepo.NextMonth,"Next month");
        // Selecting Date
        $$(RetrievalRepo.SelectedDate).filter(Condition.visible).get(1).click();
        sleep(2000);
        ClickElement(RetrievalRepo.StartTime,"Start time");
        sleep(2000);
        ClickElement(RetrievalRepo.SelectStartTime,"Selected time");
        sleep(2000);
        ClickElement(RetrievalRepo.EndTime,"End time");
        sleep(2000);
        ClickElement(RetrievalRepo.SelectEndTime,"Selected end time");
        sleep(2000);
        ClearAndSendKeys(RetrievalRepo.SendText,objReveleer.getTextArea(),"Send Text");
        sleep(2000);
        ClickElement(RetrievalRepo.ScheduleAppointment,"ScheduleAppointment");
        String Message =Common.getElementText(By.xpath("//div[contains(text(),'Appointment scheduled successfully.')]"),10);
        assertText(Message,"Appointment scheduled successfully.");
        sleep(5000);
    }
    public void GetUserForMRQA() throws Exception {
        Retrieval objRetrieval=new Retrieval();
        //sleep(5000);
        String user=Common.GetUserName();
        //objProject.ProjectsLink();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        logTestStep("Clicking on Doc QA link");
        ClickElement(RetrievalRepo.MRQA,"MRQA");
        Log.info("Clicked on Doc QA");
        Common.waitForLoader();
        logTestStep("Clicking on first check box");
//        ClickElement(ProjectsRepo.Filter,"Filter");
//        logTestStep("Clicking on Assigned To Filter");
//        ClickElement($x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]"),"AssignedTo");
//        sleep(2000);
//        $x("//input[@id='AssignedToUserId']").sendKeys(User);
//        sleep(2000);
//        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
//        sleep(2000);
//        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
//        sleep(2000);
//        ClickElement(ProjectsRepo.Update,"Update");
//        Common.waitForPageLoadToComplete();
//        sleep(5000);
        waitForElementToBeClickable(By.xpath("//tr[1]//th[1]//div[1]//div[2]")).click();
        waitForElementToBeClickable(CommonRepo.assignChase).click();
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(user);
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ARROW_DOWN);
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        waitForElementToBeClickable(CommonRepo.assignButton).click();
        Common.waitForLoader();
    }
    public void Get() throws Exception {
        Retrieval objRetrieval=new Retrieval();
        //sleep(5000);
        logTestStep("Getting user data");
        String User=Common.GetUserName();
        //objProject.ProjectsLink();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        logTestStep("Clicking on Doc QA link");
        ClickElement(RetrievalRepo.MRQA,"MRQA");
        Log.info("Clicked on Doc QA");
        waitForPageLoadToComplete();
        sleep(5000);
        // Assign lowest page count chase id to current user
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
        rowToClick.$("td",21).click();
        Selenide.sleep(2000);
        ClickElement($x("(//span[contains(text(),'Assign Chase(s)')])[2]"),"AssignChase");
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        ClickElement($x("//span[contains(text(),'ASSIGN')]"),"Assign");
        logTestStep("Clicking on Filter button");
        sleep(2000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        sleep(2000);
        logTestStep("Clicking on Assigned To Filter");
        ClickElement($x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]"),"Assigned To");
        ClearAndSendKeys(By.xpath("//input[@id='AssignedToUserId']"),User,"Sending user");
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        sleep(2000);
        ClickElement(ProjectsRepo.Update,"Update");
        Common.waitForPageLoadToComplete();
        sleep(10000);
    }
    public static void MoveChase() throws Exception {
        sleep(2000);
        String AID=$(RetrievalRepo.ContainerAID).getText();
        System.out.println(AID);
        sleep(2000);
        $$(RetrievalRepo.CheckBoxForFirstChaseId).filter(Condition.visible).last().click();
        logTestStep("Selecting first chase id");
        ClickElement(RetrievalRepo.MoveChase,"Clicking on move chase");
        logTestStep("Clicked on 'chase move' option");
        sleep(2000);
        $(RetrievalRepo.FindAddressLink).click();
        sleep(2000);
        logTestStep("Creating new address");
        ClickElement($(RetrievalRepo.CreateNewAddress),"Creating new address");
        sleep(2000);
        ClearAndSendKeys($(RetrievalRepo.Address1),"Testing","Sending address");
        sleep(2000);
        ClearAndSendKeys($(RetrievalRepo.ContactData),"Testing","Sending address");
        sleep(2000);
        ClearAndSendKeys($(RetrievalRepo.Address2),"Testing","Sending address");
        sleep(2000);
        ClearAndSendKeys($(RetrievalRepo.City),"texas","Sending address");
        sleep(2000);
        $$(RetrievalRepo.StateDropDown).filter(Condition.visible).last().click();
        sleep(2000);
        $$(RetrievalRepo.State).filter(Condition.visible).get(5).click();
        sleep(2000);
        ClearAndSendKeys($(RetrievalRepo.PostalCode),"12345","Sending address");
        sleep(2000);
        ClearAndSendKeys($(RetrievalRepo.EnterNotes),"testing","Sending address");
        sleep(2000);
        ClickElement($(RetrievalRepo.CreateAddressMoveChase),"Clicking element");
        sleep(2000);
        ClickElement($x("(.//*[normalize-space(text()) and normalize-space(.)='Are you sure you want to move these chases?'])[1]/following::span[2]"),"");
        sleep(2000);
        ClickElement($(RetrievalRepo.ViewThisAddress),"");
        sleep(5000);
        String newAID = $(RetrievalRepo.ContainerAID).getText();
        //checking weather the address id get changed or not
        System.out.println(newAID);
        logTestStep("checking whether the address id get changed or not");
        Log.info(newAID);
        if(AID.equals(newAID)){
            Assert.fail("Address id not changed");
        }else{
            logTestStep("Address id get changed successfully");
        }
    }
    public static void Comments()
    {
        Selenide.sleep(2000);
        $(RetrievalRepo.CommentTab).click();
        logTestStep("Clicked on Comments tab");
        Selenide.sleep(3000);
        String Date = $(RetrievalRepo.TimeLine).getText();
        Selenide.sleep(2000);
        logTestStep("Adding new comment");
        $(RetrievalRepo.TextArea).sendKeys("For testing purpose");
        Selenide.sleep(2000);
        $(RetrievalRepo.AddComment).click();
        logTestStep("Checking weather comment is added or not");
        Selenide.sleep(2000);
        String updatedDate = $x("//span[contains(@class,'timestamp')]").getText();
        if (Date.equals(updatedDate)) {
            logTestStep("Comment not added");
        } else {
            logTestStep("Comment added successfully");
        }
    }
    public static void TimeLine()
    {
        Selenide.sleep(2000);
        $(RetrievalRepo.CommentTab).click();
        Selenide.sleep(3000);
        $(RetrievalRepo.TextArea).sendKeys("For testing purpose");
        Selenide.sleep(3000);
        $(RetrievalRepo.AddComment).click();
        Selenide.sleep(3000);
        $(RetrievalRepo.TimeLine).click();
        logTestStep("Clicked on timeline tab");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Log.info(currentDate);
        Selenide.sleep(2000);
        String dateFound = $x("//div [contains(@class,'header bold')]").getText();
        Log.info(dateFound);
        logTestStep("Checking whether the event is added in the timeline tab or not");
        if (dateFound.equals(currentDate)) {
            Log.info("in if loop");
            logTestStep("Event added successfully");
        } else {
            Log.info("in else loop");
            Assert.fail("Event not added in the timeline. ");
        }
    }
    public static void MultipleUpload()
    {
        $(RetrievalRepo.Upload).click();
        Selenide.sleep(2000);
        String chaseId =$(RetrievalEMRRepo.FirstChaseInUpload).getText();
        Log.info(chaseId);
        Selenide.sleep(2000);
        $(RetrievalEMRRepo.RadioButtonToUpload).click();
        Selenide.sleep(2000);
        $(RetrievalEMRRepo.SelectAll).click();
        Selenide.sleep(2000);
        /** First pdf Doc upload **/
        Common.UploadDocument();
        /** Second pdf doc upload **/
        logTestStep("Uploading Png document");
        File file=new File("./src/test/resources/DocumentTypes/Test2.pdf");
        $(RetrievalPendRepo.UploadMR).uploadFile(file);
        Selenide.sleep(2000);
        logTestStep("Clicking on Submit button");
        SelenideElement SubmitButton =$(RetrievalEMRRepo.SubmitButton);
        Actions actions1=new Actions(WebDriverRunner.getWebDriver());
        Selenide.sleep(2000);
        actions1.moveToElement(SubmitButton).click().perform();
        //Selenide.sleep(5000);
        //checking weather the chart is uploaded or not
        if($x("//*[@class='ui-toast-detail']").waitUntil(Condition.visible,DEFAULT_WAIT).isDisplayed())
        {
            logTestStepPass("Multiple doc uploaded successfully");
        }else
        {
            logTestStepFail("Multiple doc not uploaded successfully");
            Assert.fail("Multiple doc not uploaded successfully");
        }
    }
    public static void cancelAppointment() throws Exception {
        Selenide.sleep(2000);
        WaitTool.waitForElementToBeClickable(RetrievalFTRepo.ScheduleTab).click();
        sleep(10000);
        //WaitTool.waitForElementToBeClickable(ProjectsRepo.Filter).click();
        if($x("//tr[1]//td[9]").isDisplayed()) {
            WaitTool.waitForElementToBeClickable(By.xpath("//tr[1]//td[9]")).click();
            Selenide.sleep(2000);
            $x("//*[text()='Cancel Appointment']").click();
            sleep(2000);
            $x("//*[text()='Yes']").click();
            sleep(1000);
            $x("//*[text()='Overview']").click();
            waitForPageLoadToComplete();
        }
        else
        {
            logTestStep("No schedule Appointment found to cancel");
            $x("//*[text()='Overview']").click();
            waitForPageLoadToComplete();
        }
    }
    public static void printRequest()
    {
        $(RetrievalRepo.PrintRequest).click();
        logTestStep("Clicked on Print request option");
        Selenide.sleep(3000);
        $x("//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
        Selenide.sleep(2000);
        $x("//p-dropdownitem//li//span").click();
        Selenide.sleep(2000);
        $x("//span[contains(text(),'SUBMIT')]").click();
        Selenide.sleep(2000);
    }

}
