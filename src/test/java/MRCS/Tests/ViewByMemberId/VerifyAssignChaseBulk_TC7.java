package MRCS.Tests.ViewByMemberId;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyAssignChaseBulk_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify assign chase bulk action", groups = {"View By Member Id"})
    public void VerifyAssignChaseBulk() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        $x("//tr[1]//td[2]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//tr[2]//td[2]//p-tablecheckbox[1]").click();
        sleep(2000);
        Common.ClickElement(MemberRepo.AssignMemberChasesButton,"Assign Member Button");
        sleep(2000);
        Members.AssignChaseIdToUser();
        logTestStepPass("Chase get assigned to new user");
        objLoginOut.logout();
    }
}
