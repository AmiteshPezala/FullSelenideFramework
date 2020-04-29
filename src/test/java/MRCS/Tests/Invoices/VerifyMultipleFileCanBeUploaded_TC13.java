package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class VerifyMultipleFileCanBeUploaded_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify multiple files can be uploaded as invoice",groups = {"Invoices"})
    public void VerifyMultipleFileCanBeUploaded() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        $(InvoicesRepo.addCodInvoiceButton).click();
        Common.UploadDocument();
        logTestStep("Uploading Second PDF Document");
        File file=new File("./src/test/resources/DocumentTypes/Test2.pdf");
        $(RetrievalPendRepo.UploadMR).uploadFile(file);
        Selenide.sleep(2000);
        $(InvoicesRepo.submitButton).click();
        String msg=Common.getElementText(By.xpath("//*[contains(text(),'Invoice Uploaded successfully.')]"),15);
        Common.assertText(msg,"Invoice Uploaded successfully.");
        objLoginOut.logout();
    }
}
