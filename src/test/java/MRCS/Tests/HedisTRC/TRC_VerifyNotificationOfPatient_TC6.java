package MRCS.Tests.HedisTRC;
import MRCS.Locators.HedisRepo.HedisTRCRepo;
import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TRC_VerifyNotificationOfPatient_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that notification of inpatient admission Notification of IP Admission  is On day of admission, day after admission or earlier if documented in MR", groups = {"Hedis TRC"} )
    public void TRC_VerifyNotificationOfPatient() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        String AdmissionDate=$x("(//label[contains(text(),'Admission Date')]//following::input)[1]").getValue();
        System.out.println(AdmissionDate);
        sleep(2000);
        /** On day of admission, day after admission or earlier if documented in MR **//*
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
        sleep(2000);*/
        $(HedisTRCRepo.InpatientAdmissionDate).setValue(AdmissionDate);
        sleep(2000);
        $(HedisTRCRepo.InpatientAdmissionPageNumber).setValue("1");
        sleep(2000);
        HedisTRC.SaveData();
        String GetMsg=$x("(//tr[1]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Inpatient Admission shows +ve compliance");
        }else{
            logTestStepFail("Inpatient Admission not shows +ve compliance");
            Assert.fail("Inpatient Admission not shows +ve compliance");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
