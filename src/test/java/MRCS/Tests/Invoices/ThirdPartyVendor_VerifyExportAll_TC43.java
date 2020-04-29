package MRCS.Tests.Invoices;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class ThirdPartyVendor_VerifyExportAll_TC43 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify export all functionality.", groups = {"Invoices"})
    public void ThirdPartyVendor_VerifyExportAll_TC43() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        sleep(2000);
        $(InvoicesRepo.ThirdPartyVendorTab).click();
        Common.waitForLoader();
        sleep(5000);
        $(InvoicesRepo.ExportAll).click();
        Common.waitForLoader();
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
