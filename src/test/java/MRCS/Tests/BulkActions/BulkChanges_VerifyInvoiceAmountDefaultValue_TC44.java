package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyInvoiceAmountDefaultValue_TC44 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that invoice amount field is an integer input field", groups = {"Bulk Actions"})
    public void BulkActions_VerifyBulkPendUpdate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        BulkChanges.GettingPendIdToResolve();
        sleep(5000);
        if ($(BulkActionsRepo.FirstChaseId).isDisplayed() && $(BulkActionsRepo.SecondChaseId).isDisplayed()) {
            Log.info("Records are present");
            BulkChanges.GetChaseAndPerformPendUpdate();
            if($(BulkActionsRepo.InvoiceAmount).getAttribute("placeholder").equalsIgnoreCase("0.00"))
            {
                logTestStepPass("Invoice amount  default value is $0.00");
            }else
            {
                logTestStepFail("Invoice amount  default value is not $0.00");
                Assert.fail("Invoice amount  default value is not $0.00");
            }

        } else
        {
            logTestStep("Record not found");
            Assert.fail("Record not found");
        }
        objLoginOut.logout();
    }
}
