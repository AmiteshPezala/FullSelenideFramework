package MRCS.Tests.ThirdParty;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyChaseMove_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();
    ApprovalCenter objApprovalCenter=new ApprovalCenter();

    @Test(description = "Verify that chase can be moved from one AID to another AID.", groups = {"Third party"})
    public void VerifyChaseMove_TC15() throws Exception {
        logTestStep("Log in to application");
       objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.ThirdPartyLink();
        sleep(5000);
        String SourceAID=$x("//tr[1]//td[2]//a").getText();
        Log.info("SourceAID = " + SourceAID);
        String DestinationAID=$x("//tr[2]//td[2]//a").getText();
        Log.info("DestinationAID =" + DestinationAID);
        sleep(2000);
        //Assigning AID's to third party employee user
         objThirdParty.AssigningToThirdParty();
        //login with third party employee
        objLoginOut.logout();
        sleep(2000);
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_ThirdPartyEmployee);
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'AID')]").click();
        sleep(2000);
        $x("//label[contains(text(),'AID')]//following::input").setValue(SourceAID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        $x("//tr[1]//td[1]").click();
        sleep(5000);
        String OldChaseId=$x("//tr[1]//td[2]//div").getText();
        Log.info("OldChaseId=" +OldChaseId);
        sleep(2000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Request Move(s)')]").click();
        sleep(2000);
        $x("//label[contains(text(),'Address ID')]//following::input").setValue(DestinationAID);
        sleep(2000);
        $(RetrievalRepo.FindAddressLink).click();
        sleep(2000);
        $x("//p-tableradiobutton").click();
        $(RetrievalRepo.EnterNotes).setValue("Testing");
        $x("//span[contains(text(),'USE THIS ADDRESS')]").click();
        sleep(5000);
        $x("//span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        objLoginOut.logout();
        //login as admin
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(5000);
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        logTestStep("Clicked on approve chase move option.");
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Chase')]").click();
        sleep(2000);
        $x("//input[@id='ChaseId']").setValue(OldChaseId);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        String CurrentDestinationAID=$x("//tr[1]//td[6]//a").getText();
        Log.info("CurrentDestinationAID =" + CurrentDestinationAID);
        if(DestinationAID.equals(CurrentDestinationAID)){
            logTestStepPass("Chase Id moved from one AID to another AID successfully.");
        }else{
            logTestStepFail("Chase Id not moved from one AID to another AID.");
        }
        objLoginOut.logout();
    }
}
