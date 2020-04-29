package MRCS.Tests.HedisWCC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisWCC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class WCC_VerifyExclusionOfNonCompliance_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Exclusion non compliance shows only when exclusion date is in 2019 and page number is available", groups = {"Hedis WCC"})
    public void WCC_VerifyExclusionOfNonCompliance_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisWCC.navigateToWcc();
        objRisk.membervalidation();
        sleep(2000);
        $x("//div[contains(text(),'BMI percentile recorded in')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Weight')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Height')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Nutrition')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        //$x("//div[contains(text(),'Physical Activity')]//following::button[@class='control__delete ng-star-inserted']").click();
        //sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_WCC();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
//        Date date = new Date();
//        String Date1 = dateFormat.format(date);
//        Log.info(Date1);
//        String Date3 = Date1;
//        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
//        Calendar cal2 = Calendar.getInstance();
//        try {
//            cal2.setTime(sdf2.parse(Date3));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        cal2.add(Calendar.YEAR, -1);
//        String newDate2 = sdf2.format(cal2.getTime());
//        System.out.println("new date" + newDate2);
//        try {
//            cal2.setTime(sdf2.parse(newDate2));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String text=Common.getElementText(By.xpath("//*[contains(text(),'BMI percentile recorded in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String date = null;
        for (int i = 4; i < 5; i++) {
            date = arrSplit_3[i];
            break;
        }
        System.out.println(date);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/"+date+"");
        Date Newdate = new Date();
        String Date1 = dateFormat.format(Newdate);
        $x("(//button[@class='control__delete'])[1]").click();
        sleep(2000);
        $x("(//button[@class='control__delete'])[2]").click();
        sleep(2000);
        $x("//label[contains(text(),'Exclusion')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
        sleep(2000);
        $x("//span[contains(text(),'Hospice service or benefit used in')]").click();
        sleep(2000);
        $x("(//label[contains(text(),'Exclusion')]//following::input)[2]").setValue(Date1);
        sleep(2000);
        $x("(//label[contains(text(),'Exclusion')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        String Compliance=$x("(//tr//td)[2]").getText();
        Log.info("Compliance =" + Compliance);
        sleep(2000);
        if(Compliance.equals("NC/E")) {
            logTestStepPass("Exclusion non compliance shows only when exclusion date is in 2019 and page number is available.");
        } else {
            logTestStepFail("Dates are not in range still exclusion shows.");
        }

        objLoginOut.logout();
    }
}
