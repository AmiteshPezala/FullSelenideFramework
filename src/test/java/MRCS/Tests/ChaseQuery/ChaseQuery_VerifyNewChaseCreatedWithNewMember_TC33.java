package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ChaseQueryRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.ChaseQuery;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ChaseQuery_VerifyNewChaseCreatedWithNewMember_TC33 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ChaseQuery objChaseQuery = new ChaseQuery();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify new chase can be created with the new member.", groups = {"Chase Query"})
    public void ChaseQuery_VerifyNewChaseCreatedWithNewMember_TC33() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objChaseQuery.NewChase_GettingChaseRecordOfProject();
        sleep(2000);
        $(ChaseQueryRepo.CreateNewChase).click();
        logTestStep("Clicked on 'Create new chase' button.");
        Selenide.sleep(2000);
        $(ChaseQueryRepo.GetStartedButton).click();
        logTestStep("Clicked on get started button.");
        Selenide.sleep(2000);
        objChaseQuery.NewChase_ProjectDetails();
        sleep(2000);
        objChaseQuery.NewChase_CreatingNewMember();
        sleep(2000);
        objChaseQuery.NewChase_CreatingNewAddress();
        sleep(2000);
        objChaseQuery.NewChase_CreatingNewProvider();
        sleep(2000);
        $(ChaseQueryRepo.FinalizeButton).click();
        logTestStep("Clicked on Finalize button.");
        Common.waitForPageLoadToComplete();
        Selenide.sleep(10000);
        logTestStep("Verifying that new chase is created or not.");
        String Message = $x("//p[@class='header']").getText();
        assertText(Message, "congrats!");
        String Message2=$x("//p[@class='sub-header']").getText();
        assertText(Message2, "you've successfully created a new Chase");
        Selenide.sleep(2000);
        logTestStep("Verifying that newly created chase redirects to chase detail page or not .");
        objChaseQuery.NewChase_VerifyNewlyCreatedChase();
        Selenide.sleep(2000);
        objLoginOut.logout();
    }
}
