package MRCS.Tests.HedisART;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisART;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ART_ValidationMessageForAllFields_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify validation message for all fields", groups = {"Hedis ART"})
    public void ValidationMessageForAllFields_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisART.navigateToART();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Verifying validation message for date field");
        $x("//div[contains(text(),'DMARD')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[position()=1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Abatacept')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'DMARD')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String Message1=$x("//div[@class='control__header__error ng-star-inserted']").getText();
        assertText(Message1, "Empty or no value specified for a required attribute DmardPrescriptionDate;");
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("//div[contains(text(),'DMARD')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        logTestStep("Verifying validation message for medication name field");
        $x("(//div[contains(text(),'DMARD')]//following::input)[1]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'DMARD')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String Message2=$x("//div[@class='control__header__error ng-star-inserted']").getText();
        assertText(Message2, "Empty or no value specified for a required attribute DmardPrescriptionMedicationName;");
        sleep(2000);
        logTestStep("Verifying validation message for page number field");
        $x("//div[contains(text(),'DMARD')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("(//div[contains(text(),'DMARD')]//following::input)[1]").setValue(newDate2);
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[position()=1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Abatacept')]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String Message3=$x("//div[@class='control__header__error ng-star-inserted']").getText();
        assertText(Message3, "Empty or no value specified for a required attribute ChartPageNumber;");
        sleep(2000);
        logTestStep("All validation messages are verified");
        sleep(2000);
        objLoginOut.logout();
    }
}
