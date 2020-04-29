package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyPageNoFieldIsRequired_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that validation message is displayed or not if page no is missing.", groups = {"IVA HST"})
    public void HST_VerifyPageNoFieldIsRequired_TC20() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        sleep(2000);
        //For service start date
        $x("//div[contains(text(),'Service Start Date')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        //for service end date
        $x("//div[contains(text(),'Service End Date')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service End Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service End Date')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        //for Provider
        $x("//div[contains(text(),'Provider')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]").click();
        sleep(2000);
        $x("//div[contains(text(),'Provider')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        objRisk.ChecklistForART();
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        if(WebDriverRunner.getWebDriver().getPageSource().contains("EncounterServiceDateFrom, PageNumber, Confirm must be provided")){
            logTestStepPass("Validation message displayed for 'service date from'.");
        }else {
            logTestStepFail("Validation message not displayed");
        }
        if(WebDriverRunner.getWebDriver().getPageSource().contains("EncounterServiceDateThru, PageNumber, Confirm must be provided")){
            logTestStepPass("Validation message displayed for 'service date to'.");
        }else {
            logTestStepFail("Validation message not displayed");
        }
        if(WebDriverRunner.getWebDriver().getPageSource().contains("EncounterProvider, PageNumber, Confirm must be provided")){
            logTestStepPass("Validation message displayed for 'Provider'.");
        }else {
            logTestStepFail("Validation message not displayed");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
