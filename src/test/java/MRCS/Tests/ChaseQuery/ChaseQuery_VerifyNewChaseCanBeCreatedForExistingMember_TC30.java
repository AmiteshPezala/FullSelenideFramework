package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ChaseQueryRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.ChaseQuery;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ChaseQuery_VerifyNewChaseCanBeCreatedForExistingMember_TC30 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ChaseQuery objChaseQuery = new ChaseQuery();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify new chase can be created with the existing member.", groups = {"Chase Query"})
    public void ChaseQuery_VerifyNewChaseCanBeCreatedForExistingMember_TC30() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objChaseQuery.NewChase_GettingChaseRecordOfProject();
        String MemberFirstName=$x("//tr[1]//td[9]//span[2]").getText();
        Log.info("Member First Name =" +MemberFirstName);
        sleep(2000);
        $(ChaseQueryRepo.CreateNewChase).click();
        logTestStep("Clicked on 'Create new chase' button.");
        sleep(2000);
        $(ChaseQueryRepo.GetStartedButton).click();
        logTestStep("Clicked on get started button.");
        sleep(2000);
        objChaseQuery.NewChase_ProjectDetails();
        sleep(3000);
        $(ChaseQueryRepo.OptionYes).click();
        logTestStep("Clicked on option yes to find existing member details .");
        sleep(3000);
        $(ChaseQueryRepo.FirstName).setValue(MemberFirstName);
        logTestStep("Finding record of the member by first name.");
        sleep(2000);
        $(ChaseQueryRepo.SearchButton).click();
        logTestStep("Clicked on search button.");
        sleep(3000);
        $(ChaseQueryRepo.FirstRecord).click();
        logTestStep("Selecting first record.");
        sleep(2000);
        $(ChaseQueryRepo.NextButtonForMember).click();
        logTestStep("Clicked on next button.");
        sleep(5000);
        objChaseQuery.NewChase_CreatingNewAddress();
        sleep(5000);
        objChaseQuery.NewChase_CreatingNewProvider();
        sleep(5000);
        $(ChaseQueryRepo.FinalizeButton).click();
        logTestStep("Clicked on Finalize button.");
        Common.waitForPageLoadToComplete();
        sleep(10000);
        logTestStep("Verifying that new chase is created or not.");
        String Message = $x("//p[@class='header']").getText();
        assertText(Message, "congrats!");
        String Message2=$x("//p[@class='sub-header']").getText();
        assertText(Message2, "you've successfully created a new Chase");
        sleep(2000);
        logTestStep("Verifying that newly created chase redirects to chase detail page or not .");
        objChaseQuery.NewChase_VerifyNewlyCreatedChase();
        sleep(2000);
        objLoginOut.logout();
    }
}
