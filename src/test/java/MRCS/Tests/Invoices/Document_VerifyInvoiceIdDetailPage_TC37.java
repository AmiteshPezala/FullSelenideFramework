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
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Document_VerifyInvoiceIdDetailPage_TC37 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that after clicked on invoice document ID page redirect to invoice detail page or not.", groups = {"Invoices"})
    public void Document_VerifyInvoiceIdDetailPage_TC37() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        sleep(2000);
        $(InvoicesRepo.documentsTabs).click();
        sleep(2000);
        $x("//a[@class='ui-column-value ng-star-inserted']").click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(2000);
        if($x("//h4[contains(text(),'INVOICE')]").isDisplayed()){
            logTestStepPass("Page redirect to invoice detail page.");
        }else{
            logTestStepFail("Page not redirect to invoice detail page.");
        }
        objLoginOut.logout();
    }
}
