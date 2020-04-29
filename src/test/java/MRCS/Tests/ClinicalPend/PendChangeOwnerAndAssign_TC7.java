package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendChangeOwnerAndAssign_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ClinicalPend objPend = new ClinicalPend();
    Common objCommon = new Common();

    @Test(description = "Verify whether pend owner is changed and assigned to new owner", groups = {"Clinical Pend"})
    public void PendChangeOwnerAndAssign() throws Exception {
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
        String AssignedUser = $x("//tr[1]//td[7]").getText();
        logTestStep("Currently pend is assigned to " + " " + AssignedUser);
        sleep(2000);
        String user="UnAssigned";
        logTestStep("Changing the owner and assign to new user");
        if(AssignedUser.equals(user))
        {
            Log.info("in if loop");
            logTestStep("Selecting first pend id ");
            $x("//tr[1]//td[1]").click();
            sleep(2000);
            $x("//span[contains(text(),'CHANGE OWNER & ASSIGN')]").click();
            logTestStep("Clicked on change owner and assign option");
            sleep(2000);
            $x("//*[text()='New Owner']//following::button[1]").click();
            logTestStep("Selecting new owner");
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Assign to User'])[1]/following::div[1]").click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Unassigned'])[1]/following::span[1]").click();
            sleep(2000);
            logTestStep("Selecting user from drop down");
            $x("//textarea[@id='notes']").sendKeys("For Testing Purpose");
            sleep(2000);
            logTestStep("entering notes for the pend id ");
            $x("//span[contains(text(),'FINISH')]").click();
            logTestStep("Clicked on finish button");
            sleep(2000);
            String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
            assertText(SuccessfulMessage,"Pend Reassigned successfully");
            sleep(2000);
        }else{
            Log.info("in else loop");
            logTestStep("Selecting first pend id ");
            $x("//tr[1]//td[1]").click();
            sleep(2000);
            $x("//span[contains(text(),'CHANGE OWNER & ASSIGN')]").click();
            logTestStep("Clicked on change owner and assign option");
            sleep(2000);
            $x("//*[text()='New Owner']//following::button[1]").click();
            logTestStep("Selecting new owner .");
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
        }
        objLoginOut.logout();
    }
}