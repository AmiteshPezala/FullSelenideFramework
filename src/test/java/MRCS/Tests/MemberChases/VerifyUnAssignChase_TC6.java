package MRCS.Tests.MemberChases;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MRRRepo.MemberChasesRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyUnAssignChase_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify unAssign chase", groups = {"Member Chases"})
    public void VerifyUnAssignChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        sleep(2000);
        MemberChases.MemberTab();
        sleep(3000);
        if($(CommonRepo.FirstChaseId).isDisplayed()) {
            Common.ClickElement(MemberChasesRepo.FirstCheckBox, "Check box");
            Common.ClickElement(MemberChasesRepo.AssignChaseButton, "Assign Member Button");
            sleep(2000);
            Members.AssignChaseIdToUser();
            sleep(5000);
            logTestStepPass("Chase get assigned to new user");
            sleep(2000);
            Common.ClickElement(MemberChasesRepo.FirstCheckBox, "Check box");
            sleep(2000);
            Common.ClickElement(MemberChasesRepo.UnAssignChase, "Un Assign Chases");
            sleep(1000);
            String getMsg = $x("//div[contains(text(),'Unassigned Successfully.')]").getText();
            Common.assertText(getMsg, "Unassigned Successfully.");
            logTestStepPass("Chase get unassigned");
        }else{
            logTestStep("Records are not available.");
        }
        objLoginOut.logout();
    }
}
