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
import static java.lang.Thread.sleep;

public class ThirdPartyVendor_VerifyGridData_TC42 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify third party grid.", groups = {"Invoices"})
    public void ThirdPartyVendor_VerifyGridData_TC42() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        sleep(2000);
        $(InvoicesRepo.ThirdPartyVendorTab).click();
        sleep(2000);
        String Grid1=$(InvoicesRepo.VendorNameGrid).getText();
        Log.info("Grid1 = " + Grid1);
        String Grid2=$(InvoicesRepo.VendorIdGrid).getText();
        Log.info("Grid2 ="+ Grid2);
        String Grid3=$(InvoicesRepo.TypeGrid).getText();
        Log.info("Grid3 ="+ Grid3);
        String Grid4=$(InvoicesRepo.ChasesGrid).getText();
        Log.info("Grid 4=" + Grid4);
        String Grid5=$(InvoicesRepo.InvoicesGrid).getText();
        Log.info("Grid 5"+ Grid5);
        String Grid6=$(InvoicesRepo.AmountGrid).getText();
        Log.info("Grid6 ="+ Grid6);
        assertText(Grid1, "VENDOR NAME");
        assertText(Grid2,"VENDOR ID");
        assertText(Grid3,"TYPE");
        assertText(Grid4,"CHASES");
        assertText(Grid5,"INVOICES");
        assertText(Grid6,"AMOUNT");
        sleep(2000);
        objLoginOut.logout();
    }
}
