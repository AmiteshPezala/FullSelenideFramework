package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class VerifyBulkAddressAssign_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify bulk address assign.", groups = {"Retrieval Assignment"})
    public void VerifyBulkAddressAssign_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        ClickElement(LoginOutRepo.UatAdmin,"UatAdmin");
        ClickElement($x("//div[@class='menu--item'][contains(.,'My Profile')]"),"My Profile");
        sleep(2000);
        String FirstName=$(By.id("firstName")).getValue();
        sleep(2000);
        String LastName=$(By.id("lastName")).getValue();
        sleep(2000);
        String User= FirstName+" "+LastName;
        sleep(2000);
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        String AID1=$x("//tr[1]//td[2]").getText();
        sleep(2000);
        String AID2=$x("//tr[2]//td[2]").getText();
        sleep(2000);
        String AID3=$x("//tr[3]//td[2]").getText();
        sleep(2000);
        $x("//tr[1]//td[1]").click();
        sleep(2000);
        $x("//tr[2]//td[1]").click();
        sleep(2000);
        $x("//tr[3]//td[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Assign Address')]").click();
        sleep(5000);
        $x("//input[@id='assignToUsers']").setValue(User);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Assigned Successfully.");
        Selenide.sleep(5000);
        String NewAID1=$x("//tr[1]//td[2]").getText();
        sleep(2000);
        String NewAID2=$x("//tr[2]//td[2]").getText();
        sleep(2000);
        String NewAID3=$x("//tr[3]//td[2]").getText();
        sleep(2000);
        if(AID1 != NewAID1){
            logTestStepPass("AID 1 assigned successfully and removed from grid.");
        }else{
            logTestStepFail("AID 1 not assigned and removed from grid.");
        }
        if(AID2 != NewAID2){
            logTestStepPass("AID 2 assigned successfully and removed from grid.");
        }else{
            logTestStepFail("AID 2 not assigned and removed from grid.");
        }
        if(AID3 != NewAID3){
            logTestStepPass("AID 3 assigned successfully and removed from grid.");
        }else{
            logTestStepFail("AID 3 not assigned and removed from grid.");
        }
        objLoginOut.logout();
    }
}
