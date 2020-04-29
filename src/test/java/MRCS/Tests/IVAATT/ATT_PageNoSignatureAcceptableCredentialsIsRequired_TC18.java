package MRCS.Tests.IVAATT;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAATT;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ATT_PageNoSignatureAcceptableCredentialsIsRequired_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that page number is a required field for signature credentials.", groups = {"IVA ATT"})
    public void ATT_PageNoSignatureAcceptableCredentialsIsRequired_TC18() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        objRisk.membervalidation();
        sleep(2000);
        $x("(//div[contains (text(),'Encounter Details')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        objMeasure.SignatureFirstName_ATT();
        objMeasure.SignatureLastName_ATT();
        $x("//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        objMeasure.SignatureIncludeDate_ATT();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        if(WebDriverRunner.getWebDriver().getPageSource().contains("Acceptable Signature Credentials, PageNumber  must be provided")){
            logTestStepPass("Validation message displayed");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        objLoginOut.logout();
    }
}
