package MRCS.Tests.HedisAWC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisAWC;
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

public class AWC_ValidationForDates_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that validation message are displayed if dates are not in timeframe.", groups = {"Hedis AWC"})
    public void AWC_ValidationForDates_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisAWC.navigateToAWC();
        objRisk.membervalidation();
        sleep(2000);
        for (int i = 1; i <= 5; i++) {
            $x("(//div[contains(text(),'Health History')]//following::button[@class='control__delete ng-star-inserted'])[" + (i +0) + "]").click();
            sleep(2000);
        }
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
        //Checking validation for health history
        logTestStep("Varifying date validation for Health history module.");
        $x("(//div[contains(text(),'Health History')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        if($x("//div[contains(text(),'Health History')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        //Checking validation for mental heath dev history
        logTestStep("Varifying date validation for Mental Dev. History module.");
        $x("(//div[contains(text(),'Mental Dev. History')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        if($x("//div[contains(text(),'Mental Dev. History')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        //Checking validation for Physical Dev. History
        logTestStep("Varifying date validation for Physical Dev. History module.");
        $x("(//div[contains(text(),'Physical Dev. History')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        if($x("//div[contains(text(),'Physical Dev. History')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        //Checking validation for Physical Exam
        logTestStep("Varifying date validation for Physical Exam module.");
        $x("(//div[contains(text(),'Physical Exam')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        if($x("//div[contains(text(),'Physical Exam')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        //Checking validation for HealthEdAntGuidance
        logTestStep("Varifying date validation for Health Ed/Ant Guidance module.");
        $x("(//div[contains(text(),'Health Ed/Ant Guidance')]//following::input)[1]").setValue(newDate2);
        sleep(4000);
        if($x("//div[contains(text(),'Health Ed/Ant Guidance')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed.");
        }else{
            logTestStepFail("Validation message not displayed");
        }
         logTestStepPass("All validation message for date frame are displayed.");
         objLoginOut.logout();
    }
}
