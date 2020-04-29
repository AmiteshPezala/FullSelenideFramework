package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Document_VerifyFilter_TC35 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify filter functionality.",groups = {"Invoices"})
    public void Document_VerifyFilter_TC35() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        sleep(2000);
        $(InvoicesRepo.documentsTabs).click();
        sleep(2000);
        String DOCID=$x("//tr[1]//td[1]").getText();
        Log.info(DOCID);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $(InvoicesRepo.DocumentID).click();
        sleep(2000);
        $x("//input[@id='DocumentId']").setValue(DOCID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        String NewDocId=$x("//tr[1]//td[1]").getText();
        if(NewDocId.equals(DOCID)){
            logTestStepPass("Filter is working properly");
        }else{
            logTestStepFail("Filter is not working.");
        }
        objLoginOut.logout();
    }
}
