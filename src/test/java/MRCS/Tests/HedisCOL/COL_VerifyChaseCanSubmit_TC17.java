package MRCS.Tests.HedisCOL;

import MRCS.Modules.Hedis.HedisCOL;
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

public class COL_VerifyChaseCanSubmit_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify colateral cancer screening shows +ve compliance CT Colonography in 2019 or 4 Years Prior  and result = yes/medical hx", groups = {"Hedis COL"} )
    public void COL_VerifyColateralCancerScreeningShowsPositiveCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        objRisk.membervalidation();
        HedisCOL.DeleteIcon();
        HedisCOL.ClearIcon();
        String text=Common.getElementText(By.xpath("//*[contains(text(),'CT Colonography in')]"),5000);
        System.out.println(text);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 3; i < 4; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
        $x("(//*[contains(text(),'CT Colonography in')]//following::input)[1]").setValue(count);
        sleep(2000);
        $x("(//*[contains(text(),'CT Colonography in')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("(//*[contains(text(),'CT Colonography in')]//following::button)[1]").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
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
        objRisk.ChecklistForART();
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
