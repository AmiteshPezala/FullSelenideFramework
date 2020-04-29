package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;

public class VerifyInvoiceChaseTabGridData_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify Invoice > chase tab gird data",groups = {"Invoices"})
    public void VerifyInvoiceChaseTabGridData() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        assertText(InvoicesRepo.invoiceGrid,"INVOICE ID");
        assertText(InvoicesRepo.invoiceNumberGrid,"INVOICE NUMBER");
        assertText(InvoicesRepo.chaseIdGrid,"CHASE ID");
        assertText(InvoicesRepo.projectGrid,"PROJECT");
        assertText(InvoicesRepo.aidGrid,"AID");
        assertText(InvoicesRepo.groupNameGrid,"GROUP NAME");
        assertText(InvoicesRepo.vendorGrid,"VENDOR");
        assertText(InvoicesRepo.typeGrid,"TYPE");
        assertText(InvoicesRepo.thresoldAmountGrid,"THRESHOLD AMOUNT");
        assertText(InvoicesRepo.approvalStatusGrid,"APPROVAL STATUS");
        assertText(InvoicesRepo.paymentTypeGrid,"PAYMENT TYPE");
        assertText(InvoicesRepo.paymentDateGrid,"PAYMENT DATE");
        assertText(InvoicesRepo.paidByGrid,"PAID BY");
        assertText(InvoicesRepo.amountPerChaseGrid,"AMOUNT PER CHASE");
        assertText(InvoicesRepo.invoiceStatusGrid,"INVOICE STATUS");
        assertText(InvoicesRepo.uploadDateGrid,"UPLOAD DATE");
        objLoginOut.logout();
    }
}
