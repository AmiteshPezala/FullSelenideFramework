package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Invoices_VerifyExportFunctionality_TC55 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify export all functionality on invoice > invoices tab",groups = {"Invoices"})
    public void Invoices_VerifyExportFunctionality() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        $(InvoicesRepo.invoicesTabs).click();
        Common.waitForLoader();
        sleep(5000);
        $x("//*[text()='Export All']").click();
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
