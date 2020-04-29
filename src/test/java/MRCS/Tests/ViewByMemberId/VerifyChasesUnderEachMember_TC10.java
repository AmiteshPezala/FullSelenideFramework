package MRCS.Tests.ViewByMemberId;

import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyChasesUnderEachMember_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that chases under  each member is displayed in grid", groups = {"View By Member Id"})
    public void VerifyChasesUnderEachMember() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        Common.ClickElement(MemberRepo.FirstExpandButton,"Expand Button");
        sleep(2000);
        Members.ChaseUnderMemberIdInGrid();
        objLoginOut.logout();
    }
}
