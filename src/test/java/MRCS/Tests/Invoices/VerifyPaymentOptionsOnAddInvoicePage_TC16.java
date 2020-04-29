package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class VerifyPaymentOptionsOnAddInvoicePage_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify the payment options on add invoice page",groups = {"Invoices"})
    public void VerifyPaymentOptionsOnAddInvoicePage() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateTo3rdParty();
        String validChaseIdForInvoice=InvoiceModule.getValidChaseId();
        System.out.println(validChaseIdForInvoice);
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        $(InvoicesRepo.addCodInvoiceButton).click();
        $(InvoicesRepo.associatedChasesText).sendKeys(validChaseIdForInvoice);
        $(InvoicesRepo.validateButton).click();
        Common.waitForLoader();
        $(InvoicesRepo.continueButton).click();
        objLoginOut.logout();
    }
}
