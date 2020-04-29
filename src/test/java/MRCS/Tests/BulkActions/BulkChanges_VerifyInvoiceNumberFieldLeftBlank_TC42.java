package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyInvoiceNumberFieldLeftBlank_TC42 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that if invoice number field is left blank ,field is not get updated  during bulk action", groups = {"Bulk Actions"})
    public void BulkActions_VerifyBulkPendUpdate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        BulkChanges.GettingPendIdToResolve();
        sleep(5000);
        if ($(BulkActionsRepo.FirstChaseId).isDisplayed() && $(BulkActionsRepo.SecondChaseId).isDisplayed()) {
            Log.info("Records are present");
            BulkChanges.GetChaseAndPerformPendUpdate();
            //$x("//*[@id='invoiceNumber']").setValue("12345678901");
            $(BulkActionsRepo.TextField).sendKeys("QA Automation");
            $(BulkActionsRepo.InvoiceAmount).setValue("100");
            $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(2).click();
            $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(1).click();
            $(BulkActionsRepo.ContinueToValidation).click();
            $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
            $(BulkActionsRepo.FinishBulkUpdate).click();
            sleep(2000);
                 if($(BulkActionsRepo.ContinueToValidation).isDisplayed())
                {
                logTestStepPass("If invoice number field is left blank ,field is not get updated  during bulk action");
                 }else
                {
                logTestStepFail("If invoice number field is left blank ,field is get updated  during bulk action");
                Assert.fail("If invoice number field is left blank ,field is get updated  during bulk action");
                }

        } else
        {
            logTestStep("Record not found");
            Assert.fail("Record not found");
        }
        objLoginOut.logout();
    }
}
