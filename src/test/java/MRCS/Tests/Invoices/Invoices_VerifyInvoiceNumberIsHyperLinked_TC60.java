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

public class Invoices_VerifyInvoiceNumberIsHyperLinked_TC60 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify invoice number is hyperlinked to invoice detail page",groups = {"Invoices"})
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
        if($(InvoicesRepo.selectDocumentButton).isDisplayed())
        {
            logTestStepPass("Invoice ID is clickable and redirected to invoice detail page");
        }else
        {
            logTestStepFail("Invoice ID is not clickable");
            Assert.fail("Invoice ID is clickable");
        }
        objLoginOut.logout();
    }
}
