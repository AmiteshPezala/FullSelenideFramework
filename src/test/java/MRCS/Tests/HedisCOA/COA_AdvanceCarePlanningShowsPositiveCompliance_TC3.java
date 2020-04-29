package MRCS.Tests.HedisCOA;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.Hedis.HedisCOA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class COA_AdvanceCarePlanningShowsPositiveCompliance_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify advance care planning shows +ve compliance when date is in 2019", groups = {"Hedis COA"} )
    public void COA_AdvanceCarePlanning() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        objRisk.membervalidation();
        HedisCOA.ClearData();
        HedisCOA.ACPShowsPositiveCompliance();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        //sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Submit messaure");
        sleep(2000);
        String GetMsg=$x("(//tr[1]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Advance care planning shows +ve compliance when  date is in MY");
        }else{
            logTestStepFail("Advance care planning not shows +ve compliance when  date is in MY");
            Assert.fail("Advance care planning not shows +ve compliance when  date is in MY");
        }
        //sleep(2000);
        objLoginOut.logout();
    }
}
