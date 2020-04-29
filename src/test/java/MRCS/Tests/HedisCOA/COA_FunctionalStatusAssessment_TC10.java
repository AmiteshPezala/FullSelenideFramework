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

public class COA_FunctionalStatusAssessment_TC10 extends TestBase {
        LoginOut objLoginOut = new LoginOut();
        Risk objRisk= new Risk();

        @Test( description = "Verify FUNCTIONAL STATUS ASSESSMENT shows +ve compliance when 3 of the four below with valid dates to equal compliance", groups = {"Hedis COA"} )
        public void COA_FunctionalStatusAssessment() throws Exception {
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            logTestStep("Log in to application");
            Common.PopUp();
            HedisCOA.NavigateToCOA();
            //Common.waitForPageLoadToComplete();
            objRisk.membervalidation();
            HedisCOA.ClearData();
            HedisCOA.FSA();
            JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
            //sleep(2000);
            ClickElement(CommonRepo.ClickToSave,"Submit messaure");
            sleep(2000);
            String GetMsg=$x("//tr[4]//td[2]").getText();
            if(GetMsg.equals("C/MR")){
                logTestStepPass("FUNCTIONAL STATUS ASSESSMENT shows +ve compliance when 3 of the four below with valid dates to equal compliance");
            }else{
                logTestStepFail("FUNCTIONAL STATUS ASSESSMENT not shows +ve compliance when 3 of the four below with valid dates to equal compliance");
                Assert.fail("FUNCTIONAL STATUS ASSESSMENT not shows +ve compliance when 3 of the four below with valid dates to equal compliance");
            }
            //sleep(2000);
            objLoginOut.logout();
        }
}
