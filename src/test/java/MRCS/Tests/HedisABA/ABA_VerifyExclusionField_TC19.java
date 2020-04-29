package MRCS.Tests.HedisABA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisABA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ABA_VerifyExclusionField_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Exclusion non compliance shows only when exclusion date is in 2019 and page number is available.", groups = {"Hedis ABA"})
    public void ABA_VerifyExclusionField_TC19() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisABA.navigateToABA();
        objRisk.membervalidation();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -2);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date4 = Date1;
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal3 = Calendar.getInstance();
        try {
            cal3.setTime(sdf3.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal3.add(Calendar.YEAR, -1);
        String newDate3 = sdf3.format(cal2.getTime());
        System.out.println("new date" + newDate3);
        try {
            cal3.setTime(sdf3.parse(newDate3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        objMeasure.WeightRecorded_ABA();
        $x("//div[contains(text(),'Body Height Test')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        $x("(//button[@class='control__delete'])[1]").click();
        sleep(2000);
        $x("(//button[@class='control__delete'])[2]").click();
        sleep(2000);
        $x("//label[contains(text(),'Exclusion')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//p-dropdownitem//li//span").click();
        sleep(2000);
        $x("(//label[contains(text(),'Exclusion')]//following::input)[2]").setValue(newDate3);
        sleep(2000);
        $x("(//label[contains(text(),'Exclusion')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        String Compliance=$x("(//tr//td)[2]").getText();
        Log.info("Compliance =" + Compliance);
        sleep(2000);
        if(Compliance.equals("NC/E") || Compliance.equals("NC")) {
            logTestStepPass("Exclusion non compliance shows only when exclusion date is in 2019 and page number is available.");
        } else {
            logTestStepFail("Dates are not in range still exclusion shows.");
        }
        objLoginOut.logout();
    }
}
