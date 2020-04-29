package MRCS.Tests.Invoices;
import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class VerifyChaseValidation_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify Chase validation on add invoice page",groups = {"Invoices"})
    public void VerifyChaseValidation() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        String chaseId=Common.getElementText(By.xpath("//tr[1]//td[4]"),10);
        $(InvoicesRepo.addCodInvoiceButton).click();
        $(InvoicesRepo.associatedChasesText).sendKeys(chaseId);
        $(InvoicesRepo.validateButton).click();
        Common.waitForLoader();
        if($(InvoicesRepo.continueButton).isDisplayed())
        {
          logTestStepPass("A grid is available with invalid chase details and  validation error");
        }else
        {
            logTestStepFail("A grid is not available with invalid chase details and  validation error");
            Assert.fail("A grid is not available with invalid chase details and  validation error");
        }
        objLoginOut.logout();
    }
}
