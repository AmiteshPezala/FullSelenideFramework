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

import static com.codeborne.selenide.Selenide.*;

public class VerifyChaseSearchOption_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify  Chase search option on add invoice page",groups = {"Invoices"})
    public void VerifyChaseSearchOption() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        Common.waitForLoader();
        String aid=Common.getElementText(By.xpath("//tr[1]//td[6]"),10);
        $(InvoicesRepo.addCodInvoiceButton).click();
        $(InvoicesRepo.searchButton).click();
        $(InvoicesRepo.aidText).sendKeys(aid);
        $(InvoicesRepo.searchButton2).click();
        String chaseId=$x("//tr[1]//td[2]").getText();
        int chaseIdNew=Integer.parseInt(chaseId);
        System.out.println(chaseIdNew);
        $x("//tr[1]//td[1]").click();
        $(InvoicesRepo.useThisChaseButton).click();
        sleep(5000);
        String getChaseId=$(InvoicesRepo.associatedChasesText).getValue();
        int getChaseIdNew=Integer.parseInt(getChaseId);
        System.out.println(getChaseIdNew);
        if(chaseIdNew==getChaseIdNew)
        {
            logTestStepPass("Selected chase is available in associated chase field for further action");
        }else
        {
            logTestStepFail("Selected chase is not available");
            Assert.fail("Selected chase is not available");
        }
        objLoginOut.logout();
    }
}
