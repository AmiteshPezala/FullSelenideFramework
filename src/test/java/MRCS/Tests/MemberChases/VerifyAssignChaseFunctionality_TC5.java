package MRCS.Tests.MemberChases;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MRRRepo.MemberChasesRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAssignChaseFunctionality_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify assign chase functionality", groups = {"Member Chases"})
    public void VerifyAssignChaseFunctionality() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        //$(CommonRepo.FirstChaseId).shouldBe(Condition.visible).click();
        MemberChases.MemberTab();
        sleep(3000);
        if($(CommonRepo.FirstChaseId).isDisplayed()) {
            Common.ClickElement(MemberChasesRepo.FirstCheckBox, "Check box");
            Common.ClickElement(MemberChasesRepo.AssignChaseButton, "Assign Member Button");
            sleep(2000);
            Members.AssignChaseIdToUser();
            logTestStepPass("Chase get assigned to new user");
        }else{
            logTestStep("Records are not present");
        }
        objLoginOut.logout();
    }
}
