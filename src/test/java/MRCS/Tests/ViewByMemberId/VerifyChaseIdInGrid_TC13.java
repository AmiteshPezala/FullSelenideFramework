package MRCS.Tests.ViewByMemberId;
import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyChaseIdInGrid_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that chase ID in grid is linked to chase detail page", groups = {"View By Member Id"})
    public void VerifyChaseIdInGrid() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        Common.ClickElement(MemberRepo.FirstExpandButton, "Expand Button");
        sleep(2000);
        Members.ChaseUnderMemberIdInGrid();
        Common.ClickElement(MemberRepo.FirstChaseIdInSubGrid,"First Chase Id In Sub Grid");
        sleep(3000);
        if($x("//div[contains(text(),'Chase Info')]").isDisplayed())
        {
            logTestStepPass("Chase detail page is displayed");
        }
        else
        {
            logTestStepFail("Chase detail page is not displayed");
            Assert.fail("Chase detail page is not displayed");
        }
        objLoginOut.logout();
    }
}
