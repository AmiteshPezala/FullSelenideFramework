package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyCompaniesListed_TC47 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the companies listed", groups = {"Bulk Actions"})
    public void BulkChanges_VerifyCompaniesListed() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        BulkChanges.GettingPendIdToResolve();
        sleep(5000);
        if ($(BulkActionsRepo.FirstChaseId).isDisplayed() && $(BulkActionsRepo.SecondChaseId).isDisplayed()) {
            Log.info("Records are present");
            BulkChanges.GetChaseAndPerformPendUpdate();
            $(BulkActionsRepo.TextField).sendKeys("QA Automation");
            $(BulkActionsRepo.InvoiceTextField).setValue("411");
            $(BulkActionsRepo.InvoiceAmount).setValue("114");
            $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(2).click();
            int count= $$(BulkActionsRepo.DropDownElement).size();
            System.out.println(count);
            if(count==17){
                System.out.println("Pass");
                logTestStepPass("Companies list count is same");
            }else
            {
                logTestStepFail("Companies list count is not same");
                Assert.fail("Companies list count is not same");
            }

        } else
        {
            logTestStep("Record not found");
            Assert.fail("Record not found");
        }
        objLoginOut.logout();
    }
}
