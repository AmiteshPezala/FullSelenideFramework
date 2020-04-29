package MRCS.Modules.MemberCentric;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.Clinical;
import MRCS.Utils.Common;
import org.testng.Assert;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Members {

    public static void NavigateToMemberTab() throws Exception {
        Clinical.ClinicalLink();
        ClickElement(ClinicalRepo.Assignment,"Assignment");
        logTestStep("Clicked on Assignment link");
        waitForPageLoadToComplete();
        String getMessage=$(MemberRepo.MemberLink).getText();
        if(getMessage.equals("Members"))
        {
            logTestStepPass("Member tab is available");
        }
        else
        {
            logTestStepFail("Member tab is not available");
            Assert.fail("Member tab is not available");
        }
        ClickElement(MemberRepo.MemberLink,"Member Link");
        logTestStep("Clicked on Member Tab");
        waitForPageLoadToComplete();
    }
    public static  void AssignChaseIdToUser() throws Exception {
        logInfoStepColored(COLOR.BLUE,"Assigning Chase Id To New User");
        sleep(5000);
        Common.ClickElement(MemberRepo.DropDown,"DropDown");
        Common.ClickElement(MemberRepo.User,"User");
        Common.ClickElement(MemberRepo.AssignButton,"Assign Button");
        sleep(2000);
        String AssignSuccessMessage=$(MemberRepo.AssignedMessage).getText();
        assertText(AssignSuccessMessage,"Assigned Successfully.");
        sleep(2000);
    }
    public static void ChaseUnderMemberIdInGrid()
    {
        if($(MemberRepo.FirstChaseIdInSubGrid).isDisplayed())
        {
            logTestStepPass("Chases under  each member is displayed in grid");
        }
        else
        {
            logTestStepFail("Chases under  each member is not displayed in grid");
            Assert.fail("Chases under  each member is not displayed in grid");
        }
    }
}
