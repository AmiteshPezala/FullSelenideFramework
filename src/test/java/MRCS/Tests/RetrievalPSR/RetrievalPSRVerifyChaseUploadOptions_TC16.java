package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyChaseUploadOptions_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that yes , no options can be selected for bulk option.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyChaseUploadOptions_TC16() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(2000);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]//following::span[contains(text(),'Upload')]").click();
        sleep(2000);
        $x("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]").click();
        Selenide.sleep(2000);
        $x("//span[contains(text(),'Select All: YES')]").click();
        sleep(2000);
        if($x("//div[@class='ui-button ui-widget ui-state-default ui-button-text-only ng-star-inserted ui-state-active']").isDisplayed()){
            logTestStepPass("Option yes for bulk can be selected.");
        }else{
            logTestStepFail("Option yes for bulk can not be selected.");
        }
        $x("//span[contains(text(),'Select All: NO')]").click();
        if($x("//div[@class='ui-button ui-widget ui-state-default ui-button-text-only ng-star-inserted ui-state-active']").isDisplayed()){
            logTestStepPass("Option no for bulk can be selected.");
        }else{
            logTestStepFail("Option no for bulk can not be selected.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
