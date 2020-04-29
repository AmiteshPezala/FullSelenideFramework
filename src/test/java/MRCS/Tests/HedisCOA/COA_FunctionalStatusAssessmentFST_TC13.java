package MRCS.Tests.HedisCOA;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Hedis.HedisCOA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class COA_FunctionalStatusAssessmentFST_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify FUNCTIONAL STATUS ASSESSMENT shows +ve compliance when Functional Screening Tool is in 2019", groups = {"Hedis COA"} )
    public void COA_FunctionalStatusAssessment() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        HedisCOA.ClearData();
        String text=Common.getElementText(By.xpath("//*[contains(text(),'Functional Status Assessment in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 4; i < 5; i++) {
            count = arrSplit_3[i];
            break;
        }
        $x("(//div[contains(text(),'Functional Screening Tool')]//following::input)[1]").setValue(count);
        sleep(2000);
        $x("(//div[contains(text(),'Functional Screening Tool')]//following::input)[2]").setValue("1");
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        //sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Submit measure");
        sleep(2000);
        String GetMsg=$x("//tr[4]//td[2]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("FUNCTIONAL STATUS ASSESSMENT shows +ve compliance when functional screening tool date is in 2019");
        }else{
            logTestStepFail("FUNCTIONAL STATUS ASSESSMENT not shows +ve compliance when functional screening tool date is in 2019");
            Assert.fail("FUNCTIONAL STATUS ASSESSMENT not shows +ve compliance when functional screening tool date is in 2019");
        }
        //sleep(2000);
        objLoginOut.logout();
    }
}
