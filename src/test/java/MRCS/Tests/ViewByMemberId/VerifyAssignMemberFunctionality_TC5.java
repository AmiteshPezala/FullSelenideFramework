package MRCS.Tests.ViewByMemberId;

import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;


public class VerifyAssignMemberFunctionality_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify assign member functionality", groups = {"View By Member Id"})
    public void VerifyAssignMemberFunctionality() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        Common.ClickElement(MemberRepo.CheckBox,"Check box");
        Common.ClickElement(MemberRepo.AssignMemberChasesButton,"Assign Member Button");
        sleep(2000);
        Members.AssignChaseIdToUser();
        logTestStepPass("Chase get assigned to new user");
        objLoginOut.logout();
    }
}
