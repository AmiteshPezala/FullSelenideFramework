package MRCS.Tests.MemberChases;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MRRRepo.MemberChasesRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAssignChaseBulk_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify assign chase bulk action", groups = {"Member Chases"})
    public void VerifyAssignChaseBulk() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        sleep(2000);
        MemberChases.MemberTab();
        Thread.sleep(3000);
        if($(CommonRepo.FirstChaseId).isDisplayed() && $(CommonRepo.SecondChaseId).isDisplayed()){
            $(ProjectsRepo.Filter).click();
        }
        else {
            if($(CommonRepo.FirstChaseId).isDisplayed()) {
                $(CommonRepo.FirstChaseId).click();
                Common.ClickElement(MemberChasesRepo.AssignChaseButton, "Assign Member Button");
                Members.AssignChaseIdToUser();
                logTestStepPass("Chase get assigned to new user");
            }else{
                logTestStep("Records are not present");
            }
        }
        objLoginOut.logout();
    }
}
