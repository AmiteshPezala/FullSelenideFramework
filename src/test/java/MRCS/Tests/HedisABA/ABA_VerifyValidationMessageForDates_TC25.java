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

public class ABA_VerifyValidationMessageForDates_TC25 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Field shows a validation message when the date entered is outside the timeframe.", groups = {"Hedis ABA"})
    public void ABA_VerifyValidationMessageForDates_TC25() throws Exception {
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
        cal2.add(Calendar.YEAR, -4);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Verifying date validation for BMI date module.");
        sleep(2000);
        //Checking validation for BMI date
        $x("(//div[contains(text(),'BMI')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageBMI=$x("//div[contains(text(),'BMI')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageBMI, "Date between 01/01/2017 and 12/31/2018 expected; ");
        //Checking validation for weight
        logTestStep("Varifying date validation for body weight module.");
        $x("(//div[contains(text(),'Body Weight Test')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageWeight=$x("//div[contains(text(),'Body Weight Test')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageWeight, "Date between 01/01/2017 and 12/31/2018 expected; ");
        //Checking validation for Height
        logTestStep("Varifying date validation for body height module.");
        $x("(//div[contains(text(),'Body Height Test')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        String ValidationMessageHeight=$x("//div[contains(text(),'Body Height Test')]//following::div[@class='control__header__error ng-star-inserted']").getText();
        assertText(ValidationMessageWeight, "Date between 01/01/2017 and 12/31/2018 expected; ");
        logTestStepPass("All validation messages are displayed if dates are out of time frame.");
        objLoginOut.logout();
    }
}
