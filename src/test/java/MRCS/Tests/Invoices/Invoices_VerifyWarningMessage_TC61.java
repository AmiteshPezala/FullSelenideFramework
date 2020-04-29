package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Invoices_VerifyWarningMessage_TC61 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify click on cancel from invoice detail page display a warming message",groups = {"Invoices"})
    public void Invoices_VerifyInvoiceNumberIsHyperLinked() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        $(InvoicesRepo.invoicesTabs).click();
        Common.waitForLoaderNew();
        $x("//tr[1]//td[2]//a").click();
        Common.waitForLoader();
        $(InvoicesRepo.cancelButton).click();
        if($(".ui-dialog-content").isDisplayed())
        {
            logTestStepPass("Warning message displayed");
        }else
        {
            logTestStepFail("Warning message is not displayed");
            Assert.fail("Warning message is not displayed");
        }
    }
}
