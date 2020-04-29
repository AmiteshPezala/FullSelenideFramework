package MRCS.Tests.MemberChases;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MRRRepo.MemberChasesRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyMemberChasesTab_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify member chases tab in chase details page", groups = {"Member Chases"})
    public void VerifyMemberChasesTab() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        sleep(2000);
        if($(MemberChasesRepo.MemberChasesTab).isDisplayed())
        {
            logTestStepPass("Chase details posses a member  chase tab");
        }
        else
        {
            logTestStepFail("Chase details not posses a member  chase tab");
            Assert.fail("Chase details not posses a member  chase tab");
        }
        objLoginOut.logout();
    }
}
