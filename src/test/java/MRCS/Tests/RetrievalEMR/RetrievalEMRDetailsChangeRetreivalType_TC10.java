package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalEMRDetailsChangeRetreivalType_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather retrieval type is changed or not.", groups = {"Retrieval EMR"})
    public void RetrievalEMRDetailsChangeRetreivalType_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        String AID = $(RetrievalEMRRepo.FirstEMRAID).getText();
        logTestStep("Clicked on first address id");
        sleep(2000);
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID,"First Record");
        sleep(2000);
        logTestStep("Changing retrieval method");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='CHANGE RETRIEVAL METHOD'])[1]/following::span[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='To PSR'])[1]/following::span[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Notes'])[1]/following::textarea[1]").sendKeys("test");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Notes'])[1]/following::button[1]").click();
        sleep(2000);
        logTestStep("Checking weather address id is removed from the grid or not");
        Common.ClickElement(RetrievalRepo.EMR,"EMR");
        String NewAID = $(RetrievalEMRRepo.FirstEMRAID).getText();
        if(AID.equals(NewAID)){
            logTestStep("Address is not removed from the list");
        }
        else{
            logTestStep("Address is removed from the list");
        }
    }
}
