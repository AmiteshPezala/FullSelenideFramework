package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyInvoiceAndCompanyField_TC40 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that upon selection of bulk update invoice and company fields are displayed", groups = {"Bulk Actions"})
    public void BulkActions_VerifyBulkPendUpdate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        BulkChanges.GettingPendIdToResolve();
        sleep(5000);
        if ($(BulkActionsRepo.FirstChaseId).isDisplayed() && $(BulkActionsRepo.SecondChaseId).isDisplayed()) {
            Log.info("Records are present");
            BulkChanges.GetChaseAndPerformPendUpdate();
                 if($x("//*[text()='Invoice Number']").isDisplayed() && $x("//*[text()='Select Company']").isDisplayed())
                {
                    logTestStepPass("Upon selection of bulk update invoice and company fields are displayed");
                }else
                 {
                     logTestStepFail("Upon selection of bulk update invoice and company fields are not displayed");
                     Assert.fail("Upon selection of bulk update invoice and company fields are not displayed");
                 }
        } else
        {
            logTestStep("Record not found");
            Assert.fail("Record not found");
        }
        objLoginOut.logout();
    }
}
