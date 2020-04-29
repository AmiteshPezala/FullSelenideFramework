package MRCS.Tests.ThirdParty;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyFilterFunctionality_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify filter functionality.", groups = {"Third party"})
    public void VerifyFilterFunctionality_TC14() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.ThirdPartyLink();
        sleep(5000);
        String PreviousAID=$x("//tr[1]//td[2]").getText();
        Log.info("PreviousAID = " + PreviousAID);
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'AID')]").click();
        sleep(2000);
        $x("//label[contains(text(),'AID')]//following::input").setValue(PreviousAID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        String CurrentAID=$x("//tr[1]//td[2]").getText();
        Log.info("CurrentAID = " + CurrentAID);
        if(PreviousAID.equals(CurrentAID)){
            logTestStepPass("Filter functionality working properly.");
        }else{
            logTestStepFail("Filter functionality not working.");
        }
        objLoginOut.logout();
    }
}
