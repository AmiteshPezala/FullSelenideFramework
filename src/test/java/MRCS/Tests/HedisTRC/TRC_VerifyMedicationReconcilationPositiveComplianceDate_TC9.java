package MRCS.Tests.HedisTRC;

import MRCS.Locators.HedisRepo.HedisTRCRepo;
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

public class TRC_VerifyMedicationReconcilationPositiveComplianceDate_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that for medication reconcilation +ve compliance date must be within 30 days of discharge (discharge date + 30 days) and medication list drop down value  is yes or no prescribed medication", groups = {"Hedis TRC"} )
    public void TRC_VerifyMedicationReconcilationPositiveComplianceDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        String DischargeDate=$x("(//label[contains(text(),'Discharge Date')]//following::input)[1]").getValue();
        System.out.println(DischargeDate);
        sleep(2000);
        /** Engagement 30 Days After Discharge  **/
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(DischargeDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 30);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        $(HedisTRCRepo.MedicationReconciliationAfterDischargeDate).setValue(newDate);
        sleep(2000);
        $(HedisTRCRepo.MedicationReconciliationAfterDischargePage).setValue("1");
        sleep(2000);
        $(HedisTRCRepo.MedicationReconciliationAfterDischargeDrop).click();
        sleep(2000);
        $(HedisTRCRepo.YesButton).click();
        sleep(2000);
        HedisTRC.SaveData();
        String GetMsg=$x("(//tr[4]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Medication Reconciliation  shows +ve compliance");
        }else{
            logTestStepFail("Medication Reconciliation  not shows +ve compliance");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
