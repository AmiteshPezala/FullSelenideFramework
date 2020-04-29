package MRCS.Tests.ViewByMemberId;
import MRCS.Locators.MemberCentricRepo.MemberRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyColumnSortingFunctionality_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the column sorting functionality", groups = {"View By Member Id"})
    public void VerifyMemberIdGrid() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Members.NavigateToMemberTab();
        String RecordBeforeSorting=$(MemberRepo.RecordBeforeSorting).getText();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE,"Member Id Before Sorting:"+ RecordBeforeSorting);
        System.out.println(RecordBeforeSorting);
        ClickElement(MemberRepo.MemberIdTabColumn,"Member Id Column");
        ClickElement(MemberRepo.MemberIdTabColumn,"Member Id Column");
        sleep(4000);
        String RecordAfterSorting=$(MemberRepo.RecordBeforeSorting).getText();
        logInfoStepColored(COLOR.BLUE,"Member Id After Sorting:"+ RecordAfterSorting);

        if(RecordBeforeSorting.equals(RecordAfterSorting))
        {
            logTestStepFail("Column sorting functionality is not available");
            Assert.fail("Column sorting functionality is not available");
        }
        else
        {
            logTestStepPass("Column sorting functionality is available");
        }
        objLoginOut.logout();
    }
}
