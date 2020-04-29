package MRCS.Modules.RetrievalModule;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class RetrievalPSR  {

    public static void NavigateToPSR() throws Exception {
        Retrieval objRetrieval = new Retrieval();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        logTestStep("Clicking on PSR link");
        $(RetrievalRepo.PSR).click();
        Log.info("Clicked on PSR Link");
        sleep(10000);
    }
    public static void SendEmail() throws InterruptedException {
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on first AID .");
        sleep(2000);
        $(RetrievalPSRRepo.EditAddress).click();
        sleep(2000);
        $(RetrievalPSRRepo.Emails).setValue("admin@yopmail.com");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(5000);
        logTestStep("Updating the address details.");
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        logTestStep("Selecting first chase id.");
        sleep(2000);
        $(RetrievalPSRRepo.EmailsRequest).click();
        logTestStep("Clicked on email request button.");
        sleep(3000);
        $$(RetrievalPSRRepo.SelectTemplateDropdown).filter(Condition.visible).last().click();
        sleep(2000);
        $(RetrievalPSRRepo.InitialRequest).click();
        sleep(2000);
        $(RetrievalPSRRepo.EmailButton).click();
        sleep(2000);
        String Message = Common.getElementText(By.xpath("//div[@class='ui-toast-detail']"),15);
        assertText(Message,"Email Queued for Sending.");
        sleep(2000);
    }
    public static void CreatingNewAddress() throws Exception {
        logTestStep("Creating new address.");
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
    }
    public static void ManagerApproveChaseMove() throws Exception {
        LoginOut objlogout=new LoginOut();
        ApprovalCenter objApprovalCenter=new ApprovalCenter();
        RetrievalPSR objRetrievalPSR=new RetrievalPSR();

        sleep(2000);
        String AID=$(RetrievalRepo.ContainerAID).getText();
        System.out.println(AID);
        sleep(2000);
        $$(RetrievalRepo.CheckBoxForFirstChaseId).filter(Condition.visible).last().click();
        logTestStep("Selecting first chase id");
        String ChaseID=$x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        sleep(2000);
        ClickElement(RetrievalRepo.MoveChase,"Clicking on move chase");
        logTestStep("Clicked on 'chase move' option");
        sleep(2000);
        $(RetrievalRepo.FindAddressLink).click();
        sleep(2000);
        logTestStep("Creating new address");
        objRetrievalPSR.CreatingNewAddress();
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
        objlogout.logout();
        objlogout.loginAs(LoginOut.Actor.USERNAME_Manager);
        sleep(2000);
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $x("//span[contains(text(),'Approve Chase Moves')]").click();
        logTestStep("Clicked on approve chase move option.");
        sleep(2000);
        logTestStep("Checking that chase moved is available for approval in manager user or not .");
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Chase')]").click();
        sleep(2000);
        $x("//input[@id='ChaseId']").setValue(ChaseID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        String NewChaseId=$x("//tr[1]//td[2]//a[1]").getText();
        sleep(2000);
        if(ChaseID.equals(NewChaseId)){
            logTestStepPass("Chase moved is available for approval in manager user.");
            sleep(2000);
            $x("//tr[1]//td[12]//app-button[1]//p-button[1]//button[1]//span[1]").click();
            sleep(2000);
            $x("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[@class='ui-button-text ui-clickable'][contains(text(),'Approve')]").click();
            sleep(2000);
            String Status=$x("//tr[1]//td[11]//span[2]").getText();
            if(Status.equals("Approved")){
                logTestStepPass("Chase moved is approved successfully.");
            }else{
                logTestStepFail("Chase moved is not approved .");
            }
        }else{
            logTestStepFail("Chase moved is not available for approval.");
        }
    }
    public static void PendAssociatedToChaseClosed() throws Exception {
        RetrievalPSR objRetrievalPSR = new RetrievalPSR();
        LoginOut objlogout = new LoginOut();

        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        sleep(2000);
        $(ThirdPartyRepo.PendTab).click();
        sleep(2000);
        ElementsCollection Checkbox = $$x("//tr//td[1]");
        int count = Checkbox.size();
        for (int i = 0; i <= count-1; i++) {
            String NewChaseID = $x("//tr[" + (i + 1) + "]//td[6]//span[2]").getText();
            if (ChaseID.equals(NewChaseID)) {
                logTestStepPass("chase Id is associated with pend");
                String PendID = $x("//tr[" + (i + 1) + "]//td[2]//span[2]").getText();
                $(ThirdPartyRepo.ChasesTab).click();
                objRetrievalPSR.ManagerApproveChaseMove();
                objlogout.logout();
                objlogout.loginAs(LoginOut.Actor.USERNAME_USERS);
                RetrievalPend.PendLink();
                Common.ClickElement(RetrievalPendRepo.TotalPend, "Total RetrievalPend");
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                $x("//a//span[contains(text(),'Pend ID')]").click();
                sleep(2000);
                $x("//input[@id='chasePendId']").setValue(PendID);
                sleep(2000);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                String Status =$x("//tr[1]//td[8]//span[2]").getText();
                sleep(2000);
                if(Status.equals("Closed") || Status.equals("Resolved")){
                    logTestStepPass("Pend Id associated with chase which is approved is closed.");
                }else{
                    logTestStepFail("Pend Id is nor closed.");
                }
                break;
            }
            else {
                logTestStep("Chase Id is not associated with pend ");
            }
        }
    }
    public static void VerifyChaseMoveToNewAID() throws Exception {
        RetrievalPSR objRetrievalPSR = new RetrievalPSR();
        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        sleep(2000);
        objRetrievalPSR.ManagerApproveChaseMove();
        $x("//td[6]//a[1]").click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[contains(text(),'Chase ID')]").click();
        sleep(2000);
        $x("//input[@id='chaseID']").setValue(ChaseID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        if($x("//tr[1]//td[2]").isDisplayed()){
            String NewChaseID =$x("//tr[1]//td[2]").getText();
            if(ChaseID.equals(NewChaseID)){
                logTestStepPass("chase Id moved to new AID successfully.");
            }else{
                logTestStepFail("chase Id not moved to new AID.");
            }
        }
    }
    public static void VerifyDenyChase() throws Exception {
        LoginOut objlogout = new LoginOut();
        ApprovalCenter objApprovalCenter = new ApprovalCenter();
        RetrievalPSR objRetrievalPSR = new RetrievalPSR();
        sleep(2000);
        String AID = $(RetrievalRepo.ContainerAID).getText();
        System.out.println(AID);
        sleep(2000);
        $$(RetrievalRepo.CheckBoxForFirstChaseId).filter(Condition.visible).last().click();
        logTestStep("Selecting first chase id");
        String ChaseID = $x("//tr[1]//td[2]//app-chase-grid-chase-id[1]//div[1]").getText();
        sleep(2000);
        ClickElement(RetrievalRepo.MoveChase, "Clicking on move chase");
        logTestStep("Clicked on 'chase move' option");
        sleep(2000);
        $(RetrievalRepo.FindAddressLink).click();
        sleep(2000);
        logTestStep("Creating new address");
        objRetrievalPSR.CreatingNewAddress();
        String newAID = $(RetrievalRepo.ContainerAID).getText();
        //checking weather the address id get changed or not
        System.out.println(newAID);
        logTestStep("checking whether the address id get changed or not");
        Log.info(newAID);
        if (AID.equals(newAID)) {
            Assert.fail("Address id not changed");
        } else {
            logTestStep("Address id get changed successfully");
        }
        objlogout.logout();
        objlogout.loginAs(LoginOut.Actor.USERNAME_Manager);
        sleep(2000);
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $x("//span[contains(text(),'Approve Chase Moves')]").click();
        logTestStep("Clicked on approve chase move option.");
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Chase')]").click();
        sleep(2000);
        $x("//input[@id='ChaseId']").setValue(ChaseID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        String NewChaseId = $x("//tr[1]//td[2]//a[1]").getText();
        sleep(2000);
        if (ChaseID.equals(NewChaseId)) {
            logTestStepPass("Chase moved is available to deny in manager user.");
            sleep(2000);
            $x("//tr[1]//td[12]//app-button[1]//p-button[1]//button[1]//span[1]").click();
            sleep(2000);
            $x("(//span[contains(text(),'Deny')])[2]").click();
            sleep(2000);
            String Status = $x("//tr[1]//td[11]//span[2]").getText();
            if (Status.equals("Denied")) {
                logTestStepPass("Chase Id denied successfully.");
                $x("//td[5]//a[1]").click();
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[contains(text(),'Chase ID')]").click();
                sleep(2000);
                $x("//input[@id='chaseID']").setValue(ChaseID);
                sleep(2000);
                $(ProjectsRepo.Update).click();
                sleep(2000);
                if ($x("//tr[1]//td[2]").isDisplayed()) {
                    String NewChaseID = $x("//tr[1]//td[2]").getText();
                    if (ChaseID.equals(NewChaseID)) {
                        logTestStepPass("chase Id remains with the old AID .");
                    } else {
                        logTestStepFail("chase Id not remains with the old AID.");
                    }
                } else {
                    logTestStepFail("chase Id not remains with the old AID.");
                }
            } else {
                logTestStepFail("Chase moved is not available for deny.");
            }
        }else{
            logTestStepFail("Chase moved is not available to deny in manager user.");
        }
    }

    public static void AssignAndVerifyButtonForNonManagerUser() throws Exception {
        LoginOut objLoginout=new LoginOut();
        logTestStep("Assigning record to non manager users.");
        $x("//p-tableheadercheckbox").click();
        sleep(2000);
        $x("//span[contains(text(),'Assign Address')]").click();
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys("psr employee");
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(2000);
        objLoginout.logout();
        sleep(2000);
        objLoginout.loginAs(LoginOut.Actor.USERNAME_NonManager);
        logTestStep("Logged in as a non manager user.");
        sleep(2000);
        logTestStep("Verifying the button of chase move .");
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[contains(text(),'Retrieval Type')]").click();
        sleep(2000);
        $x("//p-listbox//span[contains(text(),'PSR')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(20000);
        if($x("//tr[1]//td[1]//a[1]").isDisplayed()){
            logTestStep("Records available for PSR.");
            $x("//tr[1]//td[1]//a[1]").click();
            sleep(2000);
            $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
            sleep(2000);
            String ButtonName =$x("//app-button[4]//p-button[1]//button[1]").getText();
            Log.info("ButtonName =" +ButtonName);
            if(ButtonName.equals("REQUEST MOVE(S)")){
                logTestStepPass("Button name is 'Request Move' for non manager users.");
            }else{
                logTestStepFail("Button name is not as 'Request Move' for non manager users.");
            }
        }
        else {
            logTestStep("Records are not available for PSR.");
        }
    }

    public static void SendFax() throws Exception {
        RetrievalEMR.EditAddress();
        sleep(2000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        logTestStep("Selecting first record .");
        $x("//span[contains(text(),'Fax Request(s)')]").click();
        sleep(2000);
        logTestStep("Clicked on the option 'fax request'.");
        $x("//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//p-dropdownitem//li//span").click();
        sleep(2000);
        $x("(//span[contains(text(),'FAX')])[2]").click();
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        assertText(message, "Fax Queued for Sending.");
    }
    public static void EditFunctionalityOFChase() throws Exception {
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
                    $(RetrievalRepo.PSR).click();
                    logTestStep("Clicking on PSR link .");
                    sleep(2000);
                    $(RetrievalRepo.AIDFirstRow).click();
                    logTestStep("Clicked on first AID.");
                    //$x("//tr[3]//td[2]//a[1]").click();
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
}
