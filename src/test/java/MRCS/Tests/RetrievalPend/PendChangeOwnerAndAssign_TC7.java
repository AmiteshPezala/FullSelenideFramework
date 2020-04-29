package MRCS.Tests.RetrievalPend;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
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
    RetrievalPend objPend = new RetrievalPend();
    Common objCommon = new Common();

    @Test(description = "Verify weather pend owner is changed and assigned to new owner", groups = {"Retrieval Pend"})
    public void PendChangeOwnerAndAssign_TC7() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        sleep(2000);
        $x("//a[@class='headerStatsItem ng-star-inserted']").click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::div[5]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::div[2]").click();
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
            $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
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