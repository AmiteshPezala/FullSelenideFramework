package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Invoices_VerifyFilterOption_TC58 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify filter option on invoice >invoices tab",groups = {"Invoices"})
    public void Invoices_VerifyFilterOption_TC58() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        $(InvoicesRepo.invoicesTabs).click();
        Common.waitForLoaderNew();
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("(//*[text()='Invoice Type'])").click();
        sleep(2000);
        $x("//*[@id='InvoiceTypeIdsAsCsv']/div/div[2]/ul/li[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        Common.waitForLoaderNew();
        ElementsCollection col=$$x("//tr//td[4]");
        Log.info("Enter into comparison");
        int count=col.size();
        Log.info("No of counts are:" +count);
        for(int i=0;i<count-1;i++){
            String type=$x("//tr[\" + (i + 1) + \"]//td[4]").getText();
            Log.info(type);
            assertText(type,"COD");
        }
        objLoginOut.logout();
    }
}
