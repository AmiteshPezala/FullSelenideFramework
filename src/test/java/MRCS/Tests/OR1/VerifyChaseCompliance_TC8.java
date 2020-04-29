package MRCS.Tests.OR1;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR1;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyChaseCompliance_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Clinical objClinical = new Clinical();

    @Test( description = "Review compliance for all numerators", groups = {"OR1"} )
    public void VerifyChaseCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        OR1.BulkAssignToUser();
        SelectChaseAndOpenChart();
        sleep(2000);
        objRisk.membervalidation();
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2017");
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[2]").setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        String GetMsg=$x("//span[contains(text(),'C/MR')]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Measure shows +ve compliance");
        }else{
            logTestStepFail("Measure not shows +ve compliance");
            Assert.fail("Measure not shows +ve compliance");
        }
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Mammogram')]//following::button[@class='control__delete ng-star-inserted'][1]"), "Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
