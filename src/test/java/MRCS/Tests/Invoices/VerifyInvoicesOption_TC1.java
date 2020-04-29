package MRCS.Tests.Invoices;

import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class VerifyInvoicesOption_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();


    @Test(description = "Verify Invoice option in main menu",groups = {"Invoices"})
    public void VerifyInvoicesOption() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"NavigationBar");
        logTestStep("clicked on Navigation bar");
        sleep(2000);
        String invoicesText=Common.getElementText(By.xpath("//*[text()='Invoices']"),5);
        Common.assertText(invoicesText,"Invoices");
        objLoginOut.logout();
    }
}
