package MRCS.Tests.Invoices;

import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyColumnSorting_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify column sorting on invoice > chase tab",groups = {"Invoices"})
    public void VerifyColumnSorting() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        sleep(10000);
        String chaseId=Common.getElementText($x("//tr[1]//td[4]"),5);
        int id=Integer.parseInt(chaseId);
        $x("//tr//th[4]").click();
        Common.waitForLoaderNew();
        String chaseIdNew=Common.getElementText($x("//tr[1]//td[4]"),5);
        int idNew=Integer.parseInt(chaseIdNew);
        if(id!=idNew)
        {
            logTestStepPass("column sorted on invoice > chase tab");
        }else
        {
            logTestStepFail("column not sorted on invoice > chase tab");
            Assert.fail("column not sorted on invoice > chase tab");
        }
        objLoginOut.logout();
    }
}
