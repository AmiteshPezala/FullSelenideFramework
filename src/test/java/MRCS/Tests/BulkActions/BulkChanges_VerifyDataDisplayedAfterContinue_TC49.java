package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Modules.BulkActionsModule.BulkChanges;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class BulkChanges_VerifyDataDisplayedAfterContinue_TC49 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the data displayed on grid after user click on  continue validation", groups = {"Bulk Actions"})
    public void BulkChanges_VerifyDataDisplayedAfterContinue() throws Exception {
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
            $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(1).click();
            $(BulkActionsRepo.ContinueToValidation).click();
            String PendText=Common.getElementText(BulkActionsRepo.PendText,10);
            String OldInvoiceText=Common.getElementText(BulkActionsRepo.OldInvoiceNumberText,10);
            String OldInvoiceAmountText=Common.getElementText(BulkActionsRepo.OldInvoiceAmountText,10);
            String OldCompanyText=Common.getElementText(BulkActionsRepo.OldCompanyText,10);
            String ValidationStatusText=Common.getElementText(BulkActionsRepo.ValidationMessageText,10);
            String Message=Common.getElementText(BulkActionsRepo.MessageText,10);

            Common.assertText(PendText,"Pend");
            Common.assertText(OldInvoiceText,"Old Invoice Number");
            Common.assertText(OldInvoiceAmountText,"Old Invoice Amount");
            Common.assertText(OldCompanyText,"Old Company");
            Common.assertText(ValidationStatusText,"ValidationStatus");
            Common.assertText(Message,"Message");


        } else
        {
            logTestStep("Record not found");
            Assert.fail("Record not found");
        }
        objLoginOut.logout();
    }
}
