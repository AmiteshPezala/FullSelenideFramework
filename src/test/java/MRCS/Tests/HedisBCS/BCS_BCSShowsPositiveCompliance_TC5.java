package MRCS.Tests.HedisBCS;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BCS_BCSShowsPositiveCompliance_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "BCS shows +ve compliance", groups = {"Hedis BCS"} )
    public void BCS_BCSShowsPositiveCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $(HedisBCSRepo.MammogramDate).setValue("10/01/2017");
        sleep(2000);
        $(HedisBCSRepo.MammogramPageNumber).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        String GetMsg=$(HedisBCSRepo.ChaseCompliance).getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Measure shows +ve compliance");
        }else{
            logTestStepFail("Measure not shows +ve compliance");
            Assert.fail("Measure not shows +ve compliance");
        }
        sleep(2000);
        ClickElement($(HedisBCSRepo.Delete), "Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
