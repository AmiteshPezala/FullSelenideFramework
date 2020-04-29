package MRCS.Tests.HedisCOA;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisCOARepo;
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
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class COA_VerifyChaseCanSubmitWhenComplianceNegative_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when chase shows -ve compliance", groups = {"Hedis COA"} )
    public void COA_VerifyChaseCanSubmitWhenComplianceNegative() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        int ClearIcon = $$(HedisCOARepo.ClearIcon).size();
        for(int i=1;i<=ClearIcon-1;i++)
        {
            ClickElement($x("(//button[@title='Clear'])[" +(i+0)+ "]"),"Clearing data");
            sleep(1000);
        }
        sleep(2000);
        ClickElement($x("//label[contains(text(),'NRC - Advanced Care Planning')]//following::button[1]"),"Clicking on NRC");
        ClickElement($x("//span[contains(text(),'No advanced care planning found')]"),"Selecting NRC from dropdown");

        ClickElement($x("//label[contains(text(),'NRC - Medication Review')]//following::button[1]"),"Clicking on NRC");
        ClickElement($x("//span[contains(text(),'No medication review found in 2019')]"),"Selecting NRC from dropdown");

        ClickElement($x("//label[contains(text(),'NRC - Pain Assessment')]//following::button[1]"),"Clicking on NRC");
        ClickElement($x("//span[contains(text(),'No pain assessment found in 2019')]"),"Selecting NRC from dropdown");

        ClickElement($x("//label[contains(text(),'NRC - Functional Status Assessment')]//following::button[1]"),"Clicking on NRC");
        ClickElement($x("//span[contains(text(),'No functional status assessment found in 2019')]"),"Selecting NRC from dropdown");

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("//span[contains(text(),'NC')]").getText();
        if(GetMsg.equals("NC")){
            logTestStepPass("COA shows -ve compliance");
        }else{
            logTestStepFail("COA shows +ve compliance");
            Assert.fail("COA shows +ve compliance");
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
