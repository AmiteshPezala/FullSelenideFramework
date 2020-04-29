package MRCS.Tests.Invoices;
import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;

public class VerifyTheCards_TC3  extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify Cards available on right top are total invoice,new,to be paid,closed paid,closed unpaid",groups = {"Invoices"})
    public void VerifyTheCards() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        assertText(InvoicesRepo.totalInvoiceCard,"Total Invoice");
        assertText(InvoicesRepo.toBePaidCard,"To Be Paid");
        assertText(InvoicesRepo.newCard,"New");
        assertText(InvoicesRepo.closedPaidCard,"Closed Paid");
        assertText(InvoicesRepo.closedUnpaidCard,"Closed Unpaid");
        objLoginOut.logout();
    }
}
