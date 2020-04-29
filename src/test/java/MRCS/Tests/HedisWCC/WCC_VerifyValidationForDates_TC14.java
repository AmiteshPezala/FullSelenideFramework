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

public class WCC_VerifyValidationForDates_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that positive compliance chase can be submitted.", groups = {"Hedis WCC"})
    public void WCC_VerifyValidationForDates_TC14() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisWCC.navigateToWcc();
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
        logTestStep("Varifying date validation for BMI visit module.");
        //Checking validation for BMI visit date
        $x("(//div[contains(text(),'BMI Visit')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageBMI=$x("//div[contains(text(),'BMI Visit')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageBMI, "Date between 01/01/2019 and 12/31/2019 expected; ");
        logTestStep("Varifying date validation for weight module.");
        //Checking validation for BMI visit date
        $x("(//div[contains(text(),'Weight')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageweight=$x("//div[contains(text(),'Weight')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageweight, "Date between 01/01/2019 and 12/31/2019 expected; ");
        logTestStep("Varifying date validation for Height module.");
        //Checking validation for BMI visit date
        $x("(//div[contains(text(),'Height')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageHeight=$x("//div[contains(text(),'Height')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageHeight, "Date between 01/01/2019 and 12/31/2019 expected; ");
        logTestStep("Varifying date validation for Nutrition module.");
        //Checking validation for BMI visit date
        $x("(//div[contains(text(),'Nutrition')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageNutrition=$x("//div[contains(text(),'Nutrition')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageHeight, "Date between 01/01/2019 and 12/31/2019 expected; ");
        logTestStepPass("All validation messages are displayed if dates are out of time frame.");
        objLoginOut.logout();
    }
}
