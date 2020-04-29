package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Document_VerifyDocumentGrid_TC31 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that document grid loads or not .",groups = {"Invoices"})
    public void Document_VerifyDocumentGrid_TC31() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        sleep(2000);
        $x("//div[contains(text(),'Documents')]").click();
        sleep(2000);
        String Grid1=$(InvoicesRepo.InvoiceIdGrid).getText();
        Log.info("Grid1 ="+Grid1);
        String Grid2=$(InvoicesRepo.RetrievalMethodGrid).getText();
        Log.info("Grid2 ="+Grid2);
        String Grid3=$(InvoicesRepo.CaptureDateGrid).getText();
        Log.info("Grid3 ="+Grid3);
        String Grid4=$(InvoicesRepo.UploadDateGrid).getText();
        Log.info("Grid4 ="+Grid4);
        String Grid5=$(InvoicesRepo.InvoiceStatucGrid).getText();
        Log.info("Grid5 ="+Grid5);
        assertText(Grid1, "INVOICE DOCUMENT ID");
        assertText(Grid2,"CHASE ID");
        assertText(Grid3,"RETRIEVAL METHOD");
        assertText(Grid4,"UPLOAD DATE");
        assertText(Grid5,"DOC STATUS");
        sleep(2000);
        objLoginOut.logout();
    }
}
