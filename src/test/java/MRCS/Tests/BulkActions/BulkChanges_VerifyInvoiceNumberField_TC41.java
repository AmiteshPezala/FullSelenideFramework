package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyInvoiceNumberField_TC41 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that invoice number field is an integer input field", groups = {"Bulk Actions"})
    public void BulkActions_VerifyBulkPendUpdate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        BulkChanges.GettingPendIdToResolve();
        sleep(5000);
        if ($(BulkActionsRepo.FirstChaseId).isDisplayed() && $(BulkActionsRepo.SecondChaseId).isDisplayed()) {
            Log.info("Records are present");
            BulkChanges.GetChaseAndPerformPendUpdate();
            $x("//*[@id='invoiceNumber']").setValue("12345678901");
            String getErrorMessage=$(".control__header__error").getText();
            Common.assertText(getErrorMessage,"Invoice number can not be more than 10 characters.");
            logTestStepPass("Invoice number can be entered. If the entry length is more than 10 a warning message is displayed");
        } else
        {
            logTestStep("Record not found");
            Assert.fail("Record not found");
        }
        objLoginOut.logout();
    }
}
