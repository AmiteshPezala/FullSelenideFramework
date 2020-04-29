package MRCS.Tests.ViewByMemberId;

import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAssignUserInSubGrid_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify assign user option in sub grid", groups = {"View By Member Id"})
    public void VerifyAssignUserInSubGrid() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        Common.ClickElement(MemberRepo.FirstExpandButton, "Expand Button");
        sleep(2000);
        Common.ClickElement(MemberRepo.FirstCheckBoxInSubGrid,"CheckBox in Sub Grid");
        sleep(2000);
        Common.ClickElement(MemberRepo.AssignChaseButtonInSubGrid,"Assign Button In Sub Grid");
        sleep(2000);
        Members.AssignChaseIdToUser();
        logTestStepPass("Chase get assigned to new user");
        objLoginOut.logout();
    }
}
