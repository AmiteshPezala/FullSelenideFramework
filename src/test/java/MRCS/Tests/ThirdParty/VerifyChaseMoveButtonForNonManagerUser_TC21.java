package MRCS.Tests.ThirdParty;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyChaseMoveButtonForNonManagerUser_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that for non manager user button name is request move or not.", groups = {"Third party"})
    public void VerifyChaseMoveButtonForNonManagerUser_TC21() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonManager);
        Common.PopUp();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(3000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $(ThirdPartyRepo.RetrievalType).click();
        sleep(2000);
        $x("//span[contains(text(),'PSR')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        $x("//tr[1]//td[1]").click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(3000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        String ButtonName=$x("//span[contains(text(),'Request Move(s)')]").getText();
        Log.info(ButtonName);
        if(ButtonName.equals("REQUEST MOVE(S)")){
            logTestStepPass("For non manager button name is 'Request move'.");
        }else{
            logTestStepFail("For non manager button name is not 'Request move'.");
        }
         objLoginOut.logout();
    }
}
