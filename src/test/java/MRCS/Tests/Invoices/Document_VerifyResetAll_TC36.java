package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Document_VerifyResetAll_TC36 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify reset all functionality.", groups = {"Invoices"})
    public void Document_VerifyResetAll_TC36() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        sleep(2000);
        $(InvoicesRepo.documentsTabs).click();
        sleep(2000);
        int CountOfCheckBox=$$x("//tr//td[1]").size();
        System.out.println("CountOfCheckBox =" + CountOfCheckBox);
        sleep(2000);
        String DocId = $x("//tr[1]//td[1]").getText();
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $(InvoicesRepo.DocumentID).click();
        $(InvoicesRepo.IdInput).setValue(DocId);
        $(ProjectsRepo.Update).click();
        sleep(3000);
        String NewDocId = $x("//tr[1]//td[1]").getText();
        if (DocId.equals(NewDocId)) {
            logTestStepPass("Multiple filter is working properly");
        } else {
            logTestStepFail("Multiple filter is not working.");
        }
        $x("//div[contains(text(),'Reset All')]").click();
        sleep(3000);
        int CountOfCheckBox1=$$x("//tr//td[1]").size();
        System.out.println("CountOfCheckBox1 =" + CountOfCheckBox1);
        if(CountOfCheckBox==CountOfCheckBox1){
            logTestStepPass("Reset all functionality working properly.");
        }else{
            logTestStepFail("Reset all functionality not working.");
        }
        objLoginOut.logout();
    }
}
