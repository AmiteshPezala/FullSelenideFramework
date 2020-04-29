package MRCS.Modules.RetrievalModule;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ThirdParty {

    public static void ThirdPartyLink() throws Exception {
        Retrieval objRetrieval = new Retrieval();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(ThirdPartyRepo.ThirdPartyLink).click();
        logTestStep("Clicking on third party link .");
        sleep(2000);
    }

    public static void EditAddress() throws Exception {
        ClickElement($(ThirdPartyRepo.FirstAID), "AID");
        logTestStep("Clicking on first AID");
        Thread.sleep(5000);
        $(ThirdPartyRepo.EditAddress).click();
        logTestStep("Clicking edit address option .");
        Thread.sleep(2000);
        logTestStep("Editing address details");
        $(RetrievalRepo.GroupName).setValue("Test");
        $(RetrievalRepo.Email).setValue("test@yopmail.com");
        $(RetrievalRepo.Phone).setValue("8967979769");
        $(RetrievalRepo.Fax).setValue("7878787450");
        $(RetrievalRepo.ContactName).setValue("TestName");
        Thread.sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        Log.info("clicked on Apply Edit button");
        logTestStep("Comparing details successfully edited");
        String Expected = "Address Details successfully edited.";
        String Actual = Common.getElementText(By.xpath("//div[contains(text(),'Address Details successfully edited.')]"), 5);
        assertText(Actual, Expected);
    }

    public static void AssigningToLoggedInUser() throws Exception {
        ThirdParty objThirdParty = new ThirdParty();
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        Thread.sleep(2000);
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"), "My profile");
        Thread.sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        Thread.sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        Thread.sleep(1000);
        String User = FirstName + " " + LastName;
        Thread.sleep(2000);
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        String AID = $x("//tr[1]//td[2]").getText();
        Log.info("AID = " + AID);
        //assigning to logged in user
        logTestStep("Assigning record to logged in user.");
        $x("//tr//td").click();
        sleep(3000);
        $(RetrievalPSRRepo.AssignAddress).click();
        Selenide.sleep(3000);
        $(RetrievalPSRRepo.AssignToUser).click();
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(User);
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.AssignButton).click();
        logTestStep("Click on assign button");
        Selenide.sleep(2000);
        ClickElement(ProjectsRepo.Filter, "Filter");
        Thread.sleep(2000);
        $x("//span[contains(text(),'AID')]").click();
        sleep(2000);
        $x("//label[@class='control__header__label'][contains(text(),'AID')]//following::input").sendKeys(AID);
        sleep(2000);
        $x("//span[contains(text(),'Update')]").click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear, DEFAULT_WAIT);
    }

    public static void PendChase() throws Exception {
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Selecting first AID.");
        Selenide.sleep(2000);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if loop");
            RetrievalFT.PendChaseIfPended();
        }
        //If the status is other than pended then go to else loop
        else {
            System.out.println("In Else loop");
            RetrievalFT.PendChaseElsePended();
        }

    }

    public static void AddComment() {
        $(RetrievalRepo.AIDFirstRow).click();
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
        logTestStep("Checking that comment is added or not");
        Selenide.sleep(2000);
        String updatedDate = $x("//span[contains(@class,'timestamp')]").getText();
        if (Date.equals(updatedDate)) {
            logTestStep("Comment not added");
        } else {
            logTestStep("Comment added successfully");
        }
    }

    public static void AssigningToThirdParty() throws Exception {
        logTestStep("Assigning records to third party users .");
        $x("//tr[1]//td[1]").click();
        $x("//tr[2]//td[1]").click();
        Common.ClickElement(RetrievalPSRRepo.AssignAddress, "Assign");
        Selenide.sleep(3000);
        Common.ClickElement(RetrievalPSRRepo.AssignToUser, "Assign To User");
        Selenide.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys("Employee user");
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        Common.ClickElement(RetrievalPSRRepo.AssignButton, "Assign Button");
        logTestStep("Click on assign button");
        Selenide.sleep(2000);
    }

    public static void PendAssociatedWithChase() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("M/d/YY");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Log.info(currentDate);
        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        Log.info("ChaseID = " + ChaseID);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if loop");
            RetrievalFT.PendChaseIfPended();
        }
        //If the status is other than pended then go to else loop
        else {
            System.out.println("In Else loop");
            RetrievalFT.PendChaseElsePended();
        }
        $(ThirdPartyRepo.PendTab).click();
        sleep(2000);
        ElementsCollection CheckBox = $$x("//tr//td[1]");
        int Count = CheckBox.size();
        System.out.println(Count);
        for (int i = 0; i <= Count-1; i++) {
            String NewChaseId = $x("//tr[" + (i + 1) + "]//td[6]//span[2]").getText();
            Log.info(NewChaseId);
            System.out.println(i);
            sleep(2000);
            if (NewChaseId.equals(ChaseID)) {
                System.out.println(i);
                logTestStepPass("Chase Id edited successfully.");
                String TimeStamp = $x("//tr[" + (i + 1) + "]//td[9]//span[2]").getText();
                Log.info("TimeStamp=" + TimeStamp);
                if (TimeStamp.equals(currentDate)) {
                    logTestStepPass("Chase Id edited on current date.");
                } else {
                    logTestStepFail("Chase Id not edited on the current date.");
                }
                break;
            } else {
                Log.info("Chase Id not edited.");
            }
        }
    }

    public static void PendGridColumns() throws InterruptedException {
        logTestStep("Clicked on pend tab.");
        $(ThirdPartyRepo.PendTab).click();
        sleep(2000);
        String Column1 = $x("//th[2]").getText();
        Log.info(Column1);
        String Column2 = $x("//th[3]").getText();
        Log.info(Column2);
        String Column3 = $x("//th[4]").getText();
        Log.info(Column3);
        String Column4 = $x("//th[5]").getText();
        Log.info(Column4);
        String Column5 = $x("//th[6]").getText();
        Log.info(Column5);
        String Column6 = $x("//th[7]").getText();
        Log.info(Column6);
        String Column7 = $x("//th[8]").getText();
        Log.info(Column7);
        String Column8 = $x("//th[9]").getText();
        Log.info(Column8);
        if (Column1.equals("PEND ID")) {
            logTestStepPass("Pend Id column is present on the grid.");
        } else {
            logTestStepFail("Pend Id column is not present on the grid.");
        }
        if (Column2.equals("PEND CODE")) {
            logTestStepPass("Pend code column is present on the grid.");
        } else {
            logTestStepFail("Pend code column is not present on the grid.");
        }
        if (Column3.equals("MEASURE")) {
            logTestStepPass("Measure column is present on the grid.");
        } else {
            logTestStepFail("Measure column is not present on the grid.");
        }
        if (Column4.equals("PEND STATUS")) {
            logTestStepPass("Pend status column is present on the grid.");
        } else {
            logTestStepFail("Pend status column is not present on the grid.");
        }
        if (Column5.equals("CHASE ID")) {
            logTestStepPass("Chase id column is present on the grid.");
        } else {
            logTestStepFail("Pend code column is not present on the grid.");
        }
        if (Column6.equals("PROJECT")) {
            logTestStepPass("Project column is present on the grid.");
        } else {
            logTestStepFail("Project column is not present on the grid.");
        }
        if (Column7.equals("CREATION DATE")) {
            logTestStepPass("Creation date column is present on the grid.");
        } else {
            logTestStepFail("Creation date column is not present on the grid.");
        }
        if (Column8.equals("LAST UPDATED")) {
            logTestStepPass("Last updated column is present on the grid.");
        } else {
            logTestStepFail("Last updated column is not present on the grid.");
        }
    }

    public static void EditFunctionalityOfChase() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("M/d/YY");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Log.info(currentDate);
        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        Log.info("ChaseID = " + ChaseID);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if loop");
            RetrievalFT.PendChaseIfPended();
        }
        //If the status is other than pended then go to else loop
        else {
            System.out.println("In Else loop");
            RetrievalFT.PendChaseElsePended();
        }
        $(ThirdPartyRepo.PendTab).click();
        sleep(2000);
        ElementsCollection CheckBox = $$x("//tr//td[1]");
        int Count = CheckBox.size();
        System.out.println(Count);
        for (int i = 0; i <= Count; i++) {
            String NewChaseId = $x("//tr[" + (i + 1) + "]//td[6]//span[2]").getText();
            Log.info(NewChaseId);
            System.out.println(i);
            sleep(2000);
            if (NewChaseId.equals(ChaseID)) {
                System.out.println(i);
                logTestStepPass("Chase Id edited successfully.");
                String TimeStamp = $x("//tr[" + (i + 1) + "]//td[9]//span[2]").getText();
                Log.info("TimeStamp=" + TimeStamp);
                if (TimeStamp.equals(currentDate)) {
                    logTestStepPass("Chase Id edited on current date.");
                    $(ThirdPartyRepo.ChasesTab).click();
                    sleep(2000);
                    $x("//tr[" + (i + 1) + "]//td[14]").click();//click on pendcode
                    sleep(2000);
                    //doing the process of edit pend
                    logTestStep("Changing the status of pend ");
                    $x("//app-button//span[@class='fa fa-chevron-down ui-clickable ui-button-icon-left ng-star-inserted']").click();
                    sleep(2000);
                    $x("//div[contains(text(),'Status')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
                    sleep(2000);
                    $x("//li//span[contains(text(),'In Progress')]").click();
                    sleep(2000);
                    $x("//textarea[@id='pendNotes']").setValue("Testing purpose.");
                    sleep(2000);
                    $x("//button//span[contains(text(),'UPDATE PEND')]").click();
                    sleep(2000);
                    logTestStep("Verifying that the changes are reflecting in pend tab or not.");
                    $(ThirdPartyRepo.ThirdPartyLink).click();
                    logTestStep("Clicking on third party link .");
                    sleep(2000);
                    $(ThirdPartyRepo.FirstAID).click();
                    logTestStep("Clicked on first AID.");
                   // $x("//tr[3]//td[2]//a[1]").click();
                   // sleep(2000);
                    $(ThirdPartyRepo.PendTab).click();
                    sleep(2000);
                    String Status = $x("//tr[" + (i + 1) + "]//td[5]").getText();
                    if (Status.equals("In Progress")) {
                        logTestStepPass("If we edit status of pend from chase tab then it is edited successfully and reflects in pend tab.");
                    } else {
                        logTestStepFail("Status of pend tab not edited from chase tab .");
                    }
                } else {
                    logTestStepFail("Chase Id not edited on the current date.");
                }

                break;
            } else {
                Log.info("Chase Id not edited.");
            }
        }
    }
    public static void ProviderTabGridData(){
        String Column1=$x("//th[2]").getText();
        Log.info(Column1);
        String Column2=$x("//th[3]").getText();
        Log.info(Column2);
        String Column3=$x("//th[4]").getText();
        Log.info(Column3);
        String Column4=$x("//th[5]").getText();
        Log.info(Column4);
        String Column5=$x("//th[6]").getText();
        Log.info(Column5);
        String Column6=$x("//th[7]").getText();
        Log.info(Column6);

        if(Column1.equals("PROVIDER NAME")){
            logTestStepPass("Provider name column is present.");
        }else{
            logTestStepFail("Provider name column is not present.");
        }
        if(Column2.equals("NPI")){
            logTestStepPass("NPI column is present.");
        }else{
            logTestStepFail("NPI column is not present.");
        }
        if(Column3.equals("GROUP")){
            logTestStepPass("Group column is present.");
        }else{
            logTestStepFail("Group column is not present.");
        }
        if(Column4.equals("SPECIALITY")){
            logTestStepPass("Speciality column is present.");
        }else{
            logTestStepFail("Speciality column is not present.");
        }
        if(Column5.equals("TAX ID")){
            logTestStepPass("Tax ID column is present.");
        }else{
            logTestStepFail("Tax ID column is not present.");
        }
        if(Column6.equals("VALIDATION")){
            logTestStepPass("Validation column is present.");
        }else{
            logTestStepFail("Validation column is not present.");
        }
    }
    public static void PursuitTabGridData(){
        String Column1=$x("//th[2]").getText();
        Log.info(Column1);
        String Column2=$x("//th[3]").getText();
        Log.info(Column2);
        String Column3=$x("//th[4]").getText();
        Log.info(Column3);
        String Column4=$x("//th[5]").getText();
        Log.info(Column4);
        String Column5=$x("//th[6]").getText();
        Log.info(Column5);
        String Column6=$x("//th[7]").getText();
        Log.info(Column6);
        String Column7=$x("//th[8]").getText();
        Log.info(Column7);
        String Column8=$x("//th[9]").getText();
        Log.info(Column8);
        String Column9=$x("//th[10]").getText();
        Log.info(Column9);
        String Column10=$x("//th[11]").getText();
        Log.info(Column10);
        String Column11=$x("//th[12]").getText();
        Log.info(Column11);
        String Column12=$x("//th[13]").getText();
        Log.info(Column12);
        String Column13=$x("//th[14]").getText();
        Log.info(Column13);
        if(Column1.equals("CHASE ID")){
            logTestStepPass("Chase Id column is present.");
        }else{
            logTestStepFail("Chase Id column is not present.");
        }
        if(Column2.equals("FIRST")){
            logTestStepPass("First column is present.");
        }else{
            logTestStepFail("First column is not present.");
        }
        if(Column3.equals("LAST")){
            logTestStepPass("Last column is present.");
        }else{
            logTestStepFail("Last column is not present.");
        }
        if(Column4.equals("DOB")){
            logTestStepPass("DOB column is present.");
        }else{
            logTestStepFail("DOB column is not present.");
        }
        if(Column5.equals("M/F")){
            logTestStepPass("M/F column is present.");
        }else{
            logTestStepFail("Tax ID column is not present.");
        }
        if(Column6.equals("PROVIDER NAME")){
            logTestStepPass("Provider name column is present.");
        }else{
            logTestStepFail("Provider name column is not present.");
        }
        if(Column7.equals("PROJECT")){
            logTestStepPass("Project column is present.");
        }else{
            logTestStepFail("Project column is not present.");
        }
        if(Column8.equals("MEASURE")){
            logTestStepPass("Measure column is present.");
        }else{
            logTestStepFail("Measure column is not present.");
        }
        if(Column9.equals("DOC REQUEST ID")){
            logTestStepPass("Doc request ID column is present.");
        }else{
            logTestStepFail("Doc request ID column is not present.");
        }
        if(Column10.equals("STATUS")){
            logTestStepPass("Status column is present.");
        }else{
            logTestStepFail("Status column is not present.");
        }
        if(Column11.equals("COMMIT")){
            logTestStepPass("Commit column is present.");
        }else{
            logTestStepFail("Commit column is not present.");
        }
        if(Column12.equals("PEND")){
            logTestStepPass("Pend column is present.");
        }else{
            logTestStepFail("Pend column is not present.");
        }
        if(Column13.equals("PEND STATUS")){
            logTestStepPass("Pend status column is present.");
        }else{
            logTestStepFail("Pend status column is not present.");
        }
    }
    public static void PendChangesReflectsInPursuitTab() throws Exception {

        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        Log.info("ChaseID = " + ChaseID);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if loop");
            $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
            Selenide.sleep(2000);
            Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
            sleep(2000);
            $x("//label[contains(text(),'Status')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
            sleep(2000);
            $x("//label[contains(text(),'Status')]//following::span[@class='ng-star-inserted'][contains(text(),'In Progress')]").click();
            sleep(2000);
            Common.ClickElement(RetrievalFTRepo.TextArea,"Text area");
            Selenide.sleep(2000);
            $(RetrievalFTRepo.TextArea).sendKeys("For testing purpose");
            Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
            Selenide.sleep(6000);
        }
        //If the status is other than pended then go to else loop
        else {
            System.out.println("In Else loop");
            RetrievalFT.PendChaseElsePended();
            sleep(2000);
            //again doing the process of pended to change the status
            $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
            Selenide.sleep(2000);
            Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
            sleep(2000);
            $x("//label[contains(text(),'Status')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
            sleep(2000);
            $x("//label[contains(text(),'Status')]//following::span[@class='ng-star-inserted'][contains(text(),'In Progress')]").click();
            sleep(2000);
            Common.ClickElement(RetrievalFTRepo.TextArea,"Text area");
            Selenide.sleep(2000);
            $(RetrievalFTRepo.TextArea).sendKeys("For testing purpose");
            Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
            Selenide.sleep(6000);
        }
        $(ThirdPartyRepo.PursuitTab).click();
        logTestStep("clicked on pursuit tab.");
        sleep(2000);
        logTestStep("Verifying that changes done for pend id reflected in pursuit tab or not.");
        ElementsCollection CheckBox = $$x("//tr//td[1]");
        int Count = CheckBox.size();
        System.out.println(Count);
        for (int i = 0; i <= Count-1; i++) {
            String NewChaseId = $x("//tr[" + (i + 1) + "]//td[2]//span[2]").getText();
            Log.info(NewChaseId);
            System.out.println(i);
            sleep(2000);
            if (NewChaseId.equals(ChaseID)) {
                System.out.println(i);
                logTestStepPass("Chase Id edited successfully.");
                String Status = $x("//tr[" + (i + 1) + "]//td[14]//span[2]").getText();
                Log.info("Status=" + Status);
                if (Status.equals("In Progress")) {
                    logTestStepPass("Pend status which is updated in chase tab also updated in pursuit tab.");
                } else {
                    logTestStepFail("Status of pend Id not updated in the pursuit tab.");
                }
                break;
            } else {
                logTestStepFail("Chase Id not found in the pursuit tab.");
            }
        }
    }

    public static void PursuitTab_PendCodeHyperlink() throws Exception {
        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        Log.info("ChaseID = " + ChaseID);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
        Log.info(status);
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if loop");
            logTestStep("Pend code already available.");
        }
        //If the status is other than pended then go to else loop
        else {
            System.out.println("In Else loop");
            RetrievalFT.PendChaseElsePended();
        }
        $(ThirdPartyRepo.PursuitTab).click();
        logTestStep("Clicked on pursuit tab");
        sleep(2000);
        logTestStep("Verifying that changes done for pend id reflected in pursuit tab or not.");
        ElementsCollection CheckBox = $$x("//tr//td[1]");
        int Count = CheckBox.size();
        System.out.println(Count);
        for (int i = 0; i <= Count-1; i++) {
            String NewChaseId = $x("//tr[" + (i + 1) + "]//td[2]//span[2]").getText();
            Log.info(NewChaseId);
            System.out.println(i);
            sleep(2000);
            if (NewChaseId.equals(ChaseID)) {
                System.out.println(i);
                logTestStepPass("Chase Id edited successfully.");
                if ($x("//tr[" + (i + 1) + "]//td[13]//span[2]").isDisplayed()){
                    logTestStepPass("Pend code is displayed in the pursuit tab");
                    sleep(2000);
                    logTestStep("Verifying that pend code is hyperlinked or not ");
                    $x("//tr[" + (i + 1) + "]//td[13]//span[2]").click();
                    sleep(3000);
                    if($x("//h3[@class='container-title']").isDisplayed()){
                        logTestStepPass("Pend code is hyperlinked and after click on it page redirected to pend code detail page.");
                    }else{
                        logTestStepFail("Pend code is not hyperlinked.");
                    }
                } else {
                    logTestStepFail("Pend code is not displayed in the pursuit tab");
                }
                break;
            } else {
                logTestStepFail("Chase Id not found in the pursuit tab.");
            }
        }
    }
    public static void UploadMultipleMR() throws InterruptedException {
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on first AID");
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]//following::span[contains(text(),'Upload')]").click();
        sleep(2000);
        $x("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]").click();
        Selenide.sleep(2000);
        $x("//span[contains(text(),'Select All: YES')]").click();
        Selenide.sleep(2000);
        logTestStep("Uploading multiple files .");
        Common.UploadDocument();
        sleep(2000);
        //uploading second file
        File file1=new File("./src/test/resources/DocumentTypes/Test2.pdf");
        $(RetrievalPendRepo.UploadMR).uploadFile(file1);
        sleep(2000);
        SelenideElement SubmitButton =$x("//span[contains(text(),'Submit')]");
        Actions actions1=new Actions(WebDriverRunner.getWebDriver());
        Selenide.sleep(2000);
        actions1.moveToElement(SubmitButton).click().perform();
        logTestStep("File uploaded successfully");
        Selenide.sleep(2000);
        logTestStep("Verifying that both files are uploaded or not");
        $x("//span[contains(text(),'Home')]").click();
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        Selenide.sleep(20000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(5000);
        logTestStep("Clicked on notification icon");
        $x("//div[@class='notifications']").click();
        Selenide.sleep(4000);
        $x("//div[@class='ui-overlaypanel-content']/div/div[1]//a").click();
        logTestStep("Clicked on the chase Id of first notification");
        sleep(3000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(3000);
        ElementsCollection CountOfUploadedRecord=$$(ThirdPartyRepo.CountOfChart);
        int Size=CountOfUploadedRecord.size();
        System.out.println("Size of file " + Size);
        sleep(2000);
        if(Size > 1){
            logTestStepPass("Multiple MR get uploaded successfully.");
        }else{
            logTestStepFail("Multiple MR not uploaded.");
        }
    }

    public static void OptionForCoverLetter() throws InterruptedException {
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on the first AID.");
        sleep(5000);
        $(RetrievalPSRRepo.EditAddress).click();
        logTestStep("Clicked on edit address option to update the address details .");
        sleep(2000);
        $(RetrievalPSRRepo.Emails).setValue("admin@yopmail.com");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(3000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        sleep(2000);
        $(RetrievalPSRRepo.EmailsRequest).click();
        logTestStep("Clicked on email request button.");
        sleep(3000);
        $$(RetrievalPSRRepo.SelectTemplateDropdown).filter(Condition.visible).last().click();
        Selenide.sleep(2000);
        ElementsCollection options =$$x("//p-dropdownitem//li//span");
        int Count=options.size();
        System.out.println(Count);
        if(Count > 0){
            logTestStepPass("Options available for cover letter while sending mail.");
        }else{
            logTestStepFail("Options not available for cover letter while sending mail.");
        }
        $x("//div[contains(text(),'EMAIL :')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
    }

    public static void ConfirmEmailFields() throws InterruptedException {
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on the first AID.");
        sleep(5000);
        $(RetrievalPSRRepo.EditAddress).click();
        logTestStep("Clicked on the edit address option to update address details.");
        sleep(2000);
        $(RetrievalPSRRepo.Emails).setValue("admin@yopmail.com");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(3000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        sleep(2000);
        $(RetrievalPSRRepo.EmailsRequest).click();
        logTestStep("Clicked on email request option.");
        sleep(3000);
        logTestStep("Checking the fields of email field.");
        String To=$x("//div[contains(text(),'TO :')]").getText();
        String From=$x("//div[contains(text(),'FROM :')]").getText();
        String Email=$x("//div[contains(text(),'EMAIL :')]").getText();
        String TotalChases=$x("//div[contains(text(),'TOTAL CHASES :')]").getText();
        String SelectTemplate=$x("//div//label[contains(text(),'Select Template')]").getText();
        Log.info(SelectTemplate);
        if(To.equals("TO :")){
            logTestStepPass("To field is present.");
        }else{
            logTestStepFail("To field is not present.");
        }
        if(From.equals("FROM :")){
            logTestStepPass("From field is present.");
        }else{
            logTestStepFail("From field is not present.");
        }
        if(Email.equals("EMAIL :")){
            logTestStepPass("Email field is present.");
        }else{
            logTestStepFail("Email field is not present.");
        }if(TotalChases.equals("TOTAL CHASES :")){
            logTestStepPass("Total Chases field is present.");
        }else{
            logTestStepFail("Total Chases field is not present.");
        }if(SelectTemplate.equals("SELECT TEMPLATE")){
            logTestStepPass("Select Template field is present.");
        }else{
            logTestStepFail("Select Template field is not present.");
        }
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
    }
    public static void ContactHistoryGridData(){
        $(ThirdPartyRepo.ContactHistory).click();
        logTestStep("Clicked on contact history tab.");
        logTestStep("Verifying grid details contact history tab.");
        Selenide.sleep(2000);
        String Grid1=$x("//th[1]").getText();
        Log.info(Grid1);
        String Grid2=$x("//th[2]").getText();
        Log.info(Grid2);
        String Grid3=$x("//th[3]").getText();
        Log.info(Grid3);
        String Grid4=$x("//th[4]").getText();
        Log.info(Grid4);
        String Grid5=$x("//th[5]").getText();
        Log.info(Grid5);
        String Grid6=$x("//th[6]").getText();
        Log.info(Grid6);
        String Grid7=$x("//th[7]").getText();
        Log.info(Grid7);
        String Grid8=$x("//th[8]").getText();
        Log.info(Grid8);
        if(Grid1.equals("USER NAME"))
        {
            logTestStepPass(" User Name is present on the grid.");
        }else{
            logTestStepFail(" User Name is not present on the grid.");
        }
        if(Grid2.equals("CONTACT DATE")){
            logTestStepPass(" Contact Date is present on the grid.");
        }else{
            logTestStepFail(" Contact Date is not present on the grid.");
        }
        if(Grid3.equals("CONTACT DETAIL"))
        {
            logTestStepPass("Contact detail is present on the grid.");
        }else{
            logTestStepFail("Contact detail is not present on the grid.");
        }
        if(Grid4.equals("RESULT")){
            logTestStepPass("Result is present on the grid.");
        }else{
            logTestStepFail("Result is not present on the grid.");
        }if(Grid5.equals("CONTACT TYPE"))
        {
            logTestStepPass(" Contact type is present on the grid.");
        }else{
            logTestStepFail(" Contact type is not present on the grid.");
        }
        if(Grid6.equals("NOTES")){
            logTestStepPass("Notes is present on the grid.");
        }else{
            logTestStepFail("Notes is not present on the grid.");
        }
        if(Grid7.equals("REC"))
        {
            logTestStepPass("Rec is present on the grid.");
        }else{
            logTestStepFail("Rec is not present on the grid.");
        }
        if(Grid8.equals("DURATION")){
            logTestStepPass("Duration is present on the grid.");
        }else{
            logTestStepFail("Duration is not present on the grid.");
        }
    }
    public static void MemberTabGridDataIsDisabled() throws InterruptedException {
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]"));
        sleep(2000);
        $x("//div[contains(text(),'Members')]").click();
        logTestStep("Clicked on member tab to verify that grid data is read only or not.");
        sleep(2000);
        if($x("//tr[1]//td[2]").isDisplayed()) {
            logTestStep("Data is available.");
            if ($x("//tr[1]//td[2]").isEnabled()) {
                logTestStepFail("Member Id field is enabled .");
            } else {
                logTestStepPass("Member Id field is disabled .");
            }
            if ($x("//tr[1]//td[3]").isEnabled()) {
                logTestStepFail("Name field is enabled .");
            } else {
                logTestStepPass("Name field is disabled .");
            }
            if ($x("//tr[1]//td[4]").isEnabled()) {
                logTestStepFail("DOB field is enabled .");
            } else {
                logTestStepPass("DOB field is disabled .");
            }
            if ($x("//tr[1]//td[5]").isEnabled()) {
                logTestStepFail("Gender field is enabled .");
            } else {
                logTestStepPass("Gender field is disabled .");
            }
            if ($x("//tr[1]//td[6]").isEnabled()) {
                logTestStepFail("Chases field is enabled .");
            } else {
                logTestStepPass("Chases field is disabled .");
            }
            if ($x("//tr[1]//td[7]").isEnabled()) {
                logTestStepFail("Project field is enabled .");
            } else {
                logTestStepPass("Project field is disabled .");
            }
        }else{
            logTestStep("Data is not available.");
        }
        sleep(2000);
    }
}
