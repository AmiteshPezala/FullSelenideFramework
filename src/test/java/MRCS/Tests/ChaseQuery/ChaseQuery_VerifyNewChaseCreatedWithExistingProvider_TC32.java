package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ChaseQueryRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.ChaseQuery;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ChaseQuery_VerifyNewChaseCreatedWithExistingProvider_TC32 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ChaseQuery objChaseQuery = new ChaseQuery();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR=new RetrievalPSR();

    @Test(description = "Verify new chase can be created with the existing provider.", groups = {"Chase Query"})
    public void ChaseQuery_VerifyNewChaseCreatedWithExistingProvider_TC32() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        sleep(2000);
        $(ThirdPartyRepo.ProviderTab).click();
        sleep(2000);
        if($x("//tr[1]//td[3]").isDisplayed()) {
            String NPI = $x("//tr[1]//td[3]").getText();
            Log.info(NPI);
            sleep(2000);
            ClickElement(ProjectsRepo.ProjectsLink,"Project link");
            Log.info("Clicked on ProjectsLink tab");
            Common.waitForPageLoadToComplete();
            sleep(2000);
            $(ProjectsRepo.ChaseQueryHEDIS).click();
            logTestStep("Click on Chase Query");
            Selenide.sleep(10000);
            $x("//span[contains(text(),'2020 HEDIS 1')]").click();
            Selenide.sleep(2000);
            $(ProjectsRepo.Update).click();
            Selenide.sleep(2000);
            logTestStep("Click on update button");
            Common.waitForPageLoadToComplete();
            Selenide.sleep(5000);
            $(ChaseQueryRepo.CreateNewChase).click();
            logTestStep("Clicked on 'Create new chase' button.");
            Selenide.sleep(2000);
            $(ChaseQueryRepo.GetStartedButton).click();
            logTestStep("Clicked on get started button.");
            Selenide.sleep(2000);
            objChaseQuery.NewChase_ProjectDetails();
            Selenide.sleep(3000);
            objChaseQuery.NewChase_CreatingNewMember();
            sleep(2000);
            objChaseQuery.NewChase_CreatingNewAddress();
            sleep(2000);
            $(ChaseQueryRepo.OptionYesForProvider).click();
            sleep(2000);
            $(ChaseQueryRepo.NPI).setValue(NPI);
            sleep(2000);
            $x("//span[contains(text(),'Search')]").click();
           // $(ChaseQueryRepo.SearchButton).click();
            sleep(2000);
            $(ChaseQueryRepo.FirstRecord).click();
            sleep(2000);
            $(ChaseQueryRepo.NextButtonForProvider).click();
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
        }else{
            logTestStep("NPI is not available.");
        }
    }
}
