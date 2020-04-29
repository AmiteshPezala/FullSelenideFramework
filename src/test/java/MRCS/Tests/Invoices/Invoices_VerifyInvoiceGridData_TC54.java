package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Invoices_VerifyInvoiceGridData_TC54 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
        WaitTool objWait = new WaitTool();

        @Test(description = "Verify Invoice > chase tab gird data",groups = {"Invoices"})
        public void VerifyInvoiceChaseTabGridData() throws Exception {
            logTestStep("Log in to application");
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            logTestStep("User login successful");
            Common.PopUp();
            InvoiceModule.navigateToInvoicesPage();
            $(InvoicesRepo.invoicesTabs).click();
        Common.waitForLoader();
        Common.assertText(InvoicesRepo.invoicesNumber,"INVOICE NUMBER");
        Common.assertText(InvoicesRepo.vendor,"VENDOR");
        Common.assertText(InvoicesRepo.invoicesType,"INVOICE TYPE");
        Common.assertText(InvoicesRepo.paymentType,"PAYMENT TYPE");
        Common.assertText(InvoicesRepo.amountInvoices,"AMOUNT");
        Common.assertText(InvoicesRepo.chasesInvoicesTabs,"CHASES");
        Common.assertText(InvoicesRepo.statusInvoicesTabs,"STATUS");
        objLoginOut.logout();

    }
}
