package MRCS.Tests.ThirdParty;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyPrintRequest_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify print request functionality.", groups = {"Third party"})
    public void VerifyPrintRequest_TC12() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.AssigningToLoggedInUser();
        sleep(2000);
        logTestStep("Clicked on address id");
        $(RetrievalRepo.AIDFirstRow).click();
        $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
        Selenide.sleep(2000);
        logTestStep("Selecting first chase id");
        $(RetrievalRepo.PrintRequest).click();
        logTestStep("Clicked on Print request option");
        Selenide.sleep(3000);
        $x("//label[contains (text(),'SELECT TEMPLATE')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//span[contains(text(),'Initial Request')]").click();
        sleep(2000);
        $x("//span[contains(text(),'SUBMIT')]").click();
        sleep(2000);
        if($x("//div[@class='ui-toast-detail']").isDisplayed())
        {
            String PrintMsg=$x("//div[@class='ui-toast-detail']").getText();
            Selenide.sleep(2000);
            String Expected="No provider packet available for download.";
            assertText(PrintMsg,Expected);
            logTestStep("No document found to print");
        }
        else
        {
            Selenide.sleep(2000);
            Common.DownloadPdfDocument();
        }
        objLoginOut.logout();
    }
}
