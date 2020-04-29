package MRCS.Tests.HedisTRC;

import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TRC_VerifyMRDates_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that when MR dates are more than 30 days from admin dates,for  fields admission and discharge date chase shows a validation message upon submission", groups = {"Hedis TRC"} )
    public void TRC_VerifyMRDates() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        String AdmissionDate=$x("(//label[contains(text(),'Admission Date')]//following::input)[1]").getValue();
        System.out.println(AdmissionDate);
        sleep(2000);
        /** Adding more than 30 days in Admission Date **/
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(AdmissionDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 31);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Admission Date')]//following::input)[1]").setValue(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Admission Date')]//following::input)[2]").setValue("1");
        sleep(2000);
        String DischargeDate=$x("(//label[contains(text(),'Discharge Date')]//following::input)[1]").getValue();
        System.out.println(DischargeDate);
        sleep(2000);
        /** Adding dates more than days of discharge admin dates **/
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(sdf1.parse(DischargeDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Discharge Date')]//following::input)[1]").setValue(newDate1);
        sleep(2000);
        $x("(//div[contains(text(),'Discharge Date')]//following::input)[2]").setValue("1");
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        if($x("//span[@class='ui-messages-icon pi pi-times']").isDisplayed()){
            logTestStepPass("Validation message displayed");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        sleep(2000);
        $x("//i[@class='pi pi-times']").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
