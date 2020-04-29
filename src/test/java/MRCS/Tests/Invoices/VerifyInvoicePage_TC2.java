package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;

public class VerifyInvoicePage_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();


    @Test(description = "Verify Invoice page is having multiple tabs Chases,documents,third party vendors and invoices",groups = {"Invoices"})
    public void VerifyInvoicePage() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        assertText(InvoicesRepo.chasesTabs, "Chases");
        assertText(InvoicesRepo.invoicesTabs, "Invoices");
        assertText(InvoicesRepo.thirdPartyVendorsTabs, "3rd Party Vendors");
        assertText(InvoicesRepo.documentsTabs, "Documents");
        objLoginOut.logout();
    }
}
