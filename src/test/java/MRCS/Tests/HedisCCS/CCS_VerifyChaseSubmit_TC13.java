package MRCS.Tests.HedisCCS;

import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Modules.Hedis.HedisCCS;
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

public class CCS_VerifyChaseSubmit_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when the compliance is -ve", groups = {"Hedis CCS"} )
    public void CCS_VerifyPAPSmearCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        objRisk.membervalidation();
        String CurrentDate=Common.GetCurrentTimeStamp();
        $(HedisCCSRepo.HPVTestDate).setValue(CurrentDate);
        sleep(2000);
        $(HedisCCSRepo.HPVTestDropDown).click();
        sleep(1000);
        $x("(//span[contains(text(),'No')])[2]").click();
        sleep(2000);
        $(HedisCCSRepo.HPVTestPageNumber).setValue("1");
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[3]").click();
        sleep(2000);
        $x("//span[contains(text(),'No hrHPV test found in 2015-2019')]").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("(//tr[1]//td[2])[1]").getText();
        if(GetMsg.equals("NC")){
            logTestStepPass("Cervical cancer screening Compliance shows +ve Pap smear fidl value is not required if member age is 34-64");
        }else{
            logTestStepFail("Cervical cancer screening Compliance shows +ve Pap smear fidl value is not required if member age is 34-64");
            Assert.fail("Cervical cancer screening Compliance shows +ve Pap smear fidl value is not required if member age is 34-64");
        }
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
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
