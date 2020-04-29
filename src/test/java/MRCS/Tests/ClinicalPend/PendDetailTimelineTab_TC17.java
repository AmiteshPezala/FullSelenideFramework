package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendDetailTimelineTab_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ClinicalPend objPend = new ClinicalPend();
    Common objCommon = new Common();

    @Test(description = "Verify whether activity is added to timeline tab or not", groups = {"Clinical Pend"})
    public void PendDetailTimelineTab_TC17() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $(ClinicalPendRepo.pendStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.newStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.inProgressStatus).click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        logTestStep("clicked on update button");
        sleep(10000);
        logTestStep("Changing the owner and assign to new user");
        String ChaseId=$x("//tr[1]//td[9]").getText();
        logTestStep("Selecting first pend id ");
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'CHANGE OWNER & ASSIGN')]").click();
        logTestStep("Clicked on change owner and assign option");
        sleep(2000);
        $x("//*[text()='New Owner']//following::button[1]").click();
        logTestStep("Selecting new owner");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Assign to User'])[1]/following::div[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Unassigned')]").click();
        logTestStep("Selecting user from drop down");
        sleep(2000);
        $x("//textarea[@id='notes']").sendKeys("For Testing Purpose");
        logTestStep("entering notes for the pend id ");
        sleep(2000);
        $x("//span[contains(text(),'FINISH')]").click();
        logTestStep("Clicked on finish button");
        sleep(2000);
        String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(SuccessfulMessage,"Pend Reassigned successfully");
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        $x("//span[contains(text(),'Chase Id')]").click();
        sleep(2000);
        $x("//input[@id='ChaseId']").sendKeys(ChaseId);
        $(ProjectsRepo.Update).click();
        $x("//tr[1]//td[2]").click();
        logTestStep("Opening first pend id");
        sleep(2000);
        $x("//div[contains(text(),'Timeline')]").click();
        logTestStep("Clicked on timeline tab");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        sleep(2000);
        String Date = $x("//div [contains(@class,'header bold')]").getText();
        Log.info(Date);
        logTestStep("Checking weather the event is added in the timeline tab or not");
        if(Date.equals(Date1)){
            Log.info("in if loop");
            logTestStep("Event added successfully");
        }
        else{
            Log.info("in else loop");
            Assert.fail("Event not added in the timeline. ");
        }
        objLoginOut.logout();
    }
}
