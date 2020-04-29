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
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class COA_VerifyChaseCanSubmitWhenCompliancePositive_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when the compliance is +ve", groups = {"Hedis COA"} )
    public void COA_AdvanceCarePlanning() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        String CurrentDate=Common.GetCurrentTimeStamp();
        System.out.println(CurrentDate);
        /** Advanced Care Planning shows positive compliance **/
        HedisCOA.ACPShowsPositiveCompliance();
        /** Medication reviews show positive compliance **/
        HedisCOA.MRShowsPositiveCompliance();
        sleep(1000);
        /** Pain assessment shows positive compliance **/
        HedisCOA.PainAssessmentShowPositiveCompliance();
        /** Functional assessment shows positive compliance**/
        HedisCOA.FSA();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        sleep(2000);
        int ChaseStatus=$$x("//tr//td[2]").size();
        for(int i=1;i<=ChaseStatus-1;i++)
        {
            String ActualChaseStatus=$x("//tr[ "+(i+0)+" ]//td[2]").getText();
            assertText(ActualChaseStatus,"C/MR");
        }
        sleep(2000);
        ClickElement(CommonRepo.SubmitMeasure,"Clicking to clear data");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
            Assert.fail("Chase not submitted");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
