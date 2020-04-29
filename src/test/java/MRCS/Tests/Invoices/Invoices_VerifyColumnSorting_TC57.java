package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Invoices_VerifyColumnSorting_TC57 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify column sorting on invoice > invoices tab",groups = {"Invoices"})
    public void Invoices_VerifyExportFunctionality() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        $(InvoicesRepo.invoicesTabs).click();
        Common.waitForLoader();
        sleep(10000);
        String invoiceId=Common.getElementText($x("//tr[1]//td[2]"),5);
        int id=Integer.parseInt(invoiceId);
        $x("//tr//th[2]").click();
        Common.waitForLoaderNew();
        String invoiceIdNew=Common.getElementText($x("//tr[1]//td[2]"),5);
        int idNew=Integer.parseInt(invoiceIdNew);
        if(id!=idNew)
        {
            logTestStepPass("column sorted on invoice > chase tab");
        }else
        {
            logTestStepFail("column not sorted on invoice > chase tab");
            Assert.fail("column not sorted on invoice > chase tab");
        }
        objLoginOut.logout();
    }
}
