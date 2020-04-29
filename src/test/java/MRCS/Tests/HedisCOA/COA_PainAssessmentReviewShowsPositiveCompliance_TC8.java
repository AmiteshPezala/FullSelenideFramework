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

public class COA_PainAssessmentReviewShowsPositiveCompliance_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify Pain assessment review shows +ve compliance when date is in 2019", groups = {"Hedis COA"} )
    public void COA_PainAssessmentReview() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        HedisCOA.ClearData();
        HedisCOA.PainAssessmentShowPositiveCompliance();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        //sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Submit measure");
        sleep(2000);
        String GetMsg=$x("//tr[3]//td[2]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Pain assessment review shows +ve compliance when date is in 2019");
        }else{
            logTestStepFail("Pain assessment review not shows +ve compliance when date is in 2019");
            Assert.fail("Pain assessment review not shows +ve compliance when date is in 2019");
        }
        //sleep(2000);
        objLoginOut.logout();
    }
}
