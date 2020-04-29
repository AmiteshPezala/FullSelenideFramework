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
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class TRC_VerifyChaseCanSubmitWhenCompliancePositive_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when the compliance is +ve", groups = {"Hedis TRC"} )
    public void TRC_VerifyChaseCanSubmitWhenCompliancePositive() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        String AdmissionDate=$x("(//label[contains(text(),'Admission Date')]//following::input)[1]").getValue();
        System.out.println(AdmissionDate);
        sleep(1000);
        String DischargeDate=$x("(//label[contains(text(),'Discharge Date')]//following::input)[1]").getValue();
        System.out.println(DischargeDate);
        sleep(2000);
        /** On day of admission, day after admission or earlier if documented in MR **/
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(AdmissionDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        $(HedisTRCRepo.InpatientAdmissionDate).setValue(newDate);
        sleep(2000);
        $(HedisTRCRepo.InpatientAdmissionPageNumber).setValue("1");
        sleep(2000);
        /** On day of Discharge, day after discharge or earlier if documented in MR **/
        try{
            cal.setTime(sdf.parse(DischargeDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 01);
        String newDate1 = sdf.format(cal.getTime());
        System.out.println(newDate1);
        sleep(2000);
        $(HedisTRCRepo.InformationOfDischargeInformationDate).setValue(newDate1);
        sleep(2000);
        $(HedisTRCRepo.InformationOfDischargeInformationPage).setValue("1");
        sleep(2000);
        $(HedisTRCRepo.InformationOfDischargeInformationDropdwon).click();
        sleep(2000);
        $(HedisTRCRepo.YesButton).click();
        sleep(2000);
        /** Engagement 30 Days After Discharge  **/
        try{
            cal.setTime(sdf.parse(DischargeDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 29);
        String newDate2 = sdf.format(cal.getTime());
        System.out.println(newDate2);
        sleep(2000);
        $(HedisTRCRepo.PatientEngagementAfterDischargeDate).setValue(newDate2);
        sleep(2000);
        $(HedisTRCRepo.PatientEngagementAfterDischargePage).setValue("1");
        sleep(2000);
        /** Engagement 30 Days After Discharge  **/
        try{
            cal.setTime(sdf.parse(DischargeDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 30);
        String newDate3 = sdf.format(cal.getTime());
        System.out.println(newDate3);
        sleep(2000);
        $(HedisTRCRepo.MedicationReconciliationAfterDischargeDate).setValue(newDate3);
        sleep(2000);
        $(HedisTRCRepo.MedicationReconciliationAfterDischargePage).setValue("1");
        sleep(2000);
        $(HedisTRCRepo.MedicationReconciliationAfterDischargeDrop).click();
        sleep(2000);
        $(HedisTRCRepo.YesButton).click();
        sleep(2000);
        HedisTRC.SaveData();
        int compliance=$$x("//td[2]").size();
        for(int i=1;i<=compliance-1;i++)
        {
            String PositiveCompliance=$x("//tr[" + (i + 0) + "]//td[2]").getText();
            sleep(2000);
            if(PositiveCompliance.equals("C/MR")){
                logTestStepPass("Inpatient Admission shows +ve compliance");
            }else{
                logTestStepFail("Inpatient Admission not shows +ve compliance");
            }
        }
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
