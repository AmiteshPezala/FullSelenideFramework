package MRCS.Tests.HedisCOL;

import MRCS.Locators.HedisRepo.HedisCOLRepo;
import MRCS.Modules.Hedis.HedisCOL;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class COL_VerifyColateralCancerScreeningShowsPositiveCompliance_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify colateral cancer screening shows +ve compliance when Fobt in 2019   and result = yes/medical hx", groups = {"Hedis COL"} )
    public void COL_VerifyColateralCancerScreeningShowsPositiveCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        HedisCOL.ClearIcon();
//        String CurrentDate=Common.GetCurrentTimeStamp();
//        System.out.println(CurrentDate);
        String text=Common.getElementText(By.xpath("//*[contains(text(),'COLON CANCER SCREENING WITHIN')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String date = null;
        for (int i = 4; i < 11; i++) {
            date = arrSplit_3[i];
            break;
        }
        System.out.println(date);
        $x("(//div[contains(text(),'FOBT')]//following::input)[1]").setValue(date);
        sleep(2000);
        $x("(//div[contains(text(),'FOBT')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[3]").click();
        sleep(2000);
        $(HedisCOLRepo.YesButton).click();
        sleep(2000);
        $x("//button[@class='control__add']").doubleClick();
        sleep(1000);
        $x("(//div[contains(text(),'FOBT')]//following::input)[4]").setValue(date);
        sleep(2000);
        $x("(//div[contains(text(),'FOBT')]//following::input)[6]").setValue("1");
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[4]").click();
        sleep(2000);
        $(HedisCOLRepo.YesButton).click();
        sleep(2000);
        $x("(//div[contains(text(),'FOBT')]//following::input)[7]").setValue(date);
        sleep(2000);
        $x("(//div[contains(text(),'FOBT')]//following::input)[9]").setValue("1");
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[5]").click();
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
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
