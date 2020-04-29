package MRCS.Tests.HedisWCC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisWCC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static MRCS.Utils.TestBase.logTestStepPass;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class WCC_VerifyFieldsOfBMIVisitIsRequired_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that all fields of BMI visit field are required.", groups = {"Hedis WCC"})
    public void WCC_VerifyFieldsOfBMIVisitIsRequired_TC2() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisWCC.navigateToWcc();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Checking that page no field of BMI visit field is required or not .");
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
//        Date date = new Date();
//        String Date1 = dateFormat.format(date);
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
        $x("//div[contains(text(),'BMI percentile recorded')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        logTestStep("Fill date and percentile for BMI PERCENTILE RECORDED IN 2019 field");
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[1]").setValue(date);
        sleep(2000);
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String ValidationMessage = $x("//div[contains(text(),'BMI percentile recorded')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessage, "Empty or no value specified for a required attribute CHARTPAGENUMBER; ");
        logTestStepPass("Page no field of BMI visit field is required");
        sleep(2000);
        $x("//div[contains(text(),'BMI percentile recorded')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);

        logTestStep("Checking that date field of BMI visit field is required or not .");
        logTestStep("Fill page no and percentile for BMI PERCENTILE RECORDED IN 2019 field");
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String ValidationMessage1 = $x("//div[contains(text(),'BMI percentile recorded')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessage1, "Empty or no value specified for a required attribute BmiTestDate; ");
        logTestStepPass("Date field of BMI visit field is required");
        sleep(2000);
        objLoginOut.logout();
    }
}
