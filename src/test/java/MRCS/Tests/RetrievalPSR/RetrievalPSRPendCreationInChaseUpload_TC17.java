package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class RetrievalPSRPendCreationInChaseUpload_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify pend creation on chase upload window.", groups = {"Retrieval PSR"})
    public void RetrievalPSRPendCreationInChaseUpload_TC17() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(2000);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        //$(RetrievalRepo.AIDFirstRow).click();
        $x("//tr[2]//td[2]").click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear, DEFAULT_WAIT);
        $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]//following::span[contains(text(),'Upload')]").click();
        sleep(2000);
        ElementsCollection RadioButtons=$$x("//tr//td[1]//p-tableradiobutton[1]//div[1]//div[2]");
        int Count=RadioButtons.size();
        sleep(2000);
        for(int i=1;i<=Count;i++){
            $x("//tr[" + (i + 0) + "]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]").click();
            Selenide.sleep(2000);
            $x("//span[contains(text(),'Select All: NO')]").click();
            sleep(2000);
            $x("//span[contains(text(),'Pend This Chase')]").click();
            sleep(2000);
            if($x("//div[@class='ui-toast-detail']").isDisplayed()){
                logTestStep("Chase id already pended.");
            }else{
                $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
                Selenide.sleep(2000);
                $$(RetrievalEMRRepo.DropDownValue).filter(Condition.visible).get(3).click();
                sleep(2000);
                $x("//textarea[@id='notes']").sendKeys("For testing purpose");
                Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
                Selenide.sleep(2000);
                String message = $x("//div[@class='ui-toast-detail']").getText();
                assertText(message, "PEND SAVED SUCCESSFULLY");
                break;
            }
        }
        objLoginOut.logout();
    }
}