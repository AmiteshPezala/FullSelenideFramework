package MRCS.Tests.HedisCOL;

import MRCS.Locators.HedisRepo.HedisCOLRepo;
import MRCS.Modules.Hedis.HedisCOL;
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

public class COL_VerifyColateralCancerScreeningShowsPositiveCompliance_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify colateral cancer screening shows +ve compliance  when FIT DNA in 2019   and result = yes/medical hx   and result = yes/medical hx", groups = {"Hedis COL"} )
    public void COL_VerifyColateralCancerScreeningShowsPositiveCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        objRisk.membervalidation();
//        String CurrentDate=Common.GetCurrentTimeStamp();
//        System.out.println(CurrentDate);
        $x("(//div[contains(text(),'FIT DNA in')]//following::input)[1]").setValue("12/31/2018");
        sleep(2000);
        $x("(//div[contains(text(),'FIT DNA in')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'FIT DNA in')]//following::button)[1]").click();
        sleep(2000);
        $(HedisCOLRepo.YesButton).click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("(//tr[1]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Colorectal Cancer Screening shows +ve compliance");
        }else{
            logTestStepFail("Colorectal Cancer Screening not shows +ve compliance");
            Assert.fail("Colorectal Cancer Screening not shows +ve compliance");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
