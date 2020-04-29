package MRCS.Tests.Invoices;
import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyAddCodFunctionality_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify the Add COD functionality",groups = {"Invoices"})
    public void VerifyAddCodFunctionality() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        $(InvoicesRepo.addCodInvoiceButton).click();
        Common.UploadDocument();
        $(InvoicesRepo.submitButton).click();
        String msg=Common.getElementText(By.xpath("//*[contains(text(),'Invoice Uploaded successfully.')]"),15);
        Common.assertText(msg,"Invoice Uploaded successfully.");
        objLoginOut.logout();
    }
}
