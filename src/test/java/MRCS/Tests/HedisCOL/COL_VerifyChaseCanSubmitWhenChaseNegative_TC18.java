package MRCS.Tests.HedisCOL;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Hedis.HedisCOL;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class COL_VerifyChaseCanSubmitWhenChaseNegative_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when chase shows -ve compliance", groups = {"Hedis COL"} )
    public void COL_VerifyChaseCanSubmitWhenChaseNegative() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        objRisk.membervalidation();
        HedisCOL.DeleteIcon();
        HedisCOL.ClearIcon();
        ClickElement($x("//label[contains(text(),'NRC - Colorectal Cancer Screening')]//following::button[1]"),"Clicking on NRC");
        sleep(2000);
        ClickElement($x("//span[contains(text(),'Test ordered, no results/history')]"),"Selecting NRC from dropdown");
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("//span[contains(text(),'NC')]").getText();
        if(GetMsg.equals("NC")){
            logTestStepPass("COL shows -ve compliance");
        }else{
            logTestStepFail("COL shows +ve compliance");
        }
        sleep(2000);
        objRisk.ChecklistForART();
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
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
