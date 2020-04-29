package MRCS.Tests.ViewByMemberId;

import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;

public class VerifyMemberIdGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the columns in member grid", groups = {"View By Member Id"})
    public void VerifyMemberIdGrid() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        objLoginOut.logout();
    }
}
