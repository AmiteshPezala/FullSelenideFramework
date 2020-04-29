package MRCS.Tests.HedisTRC;
import MRCS.Locators.HedisRepo.HedisTRCRepo;
import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TRC_VerifyNotificationDischarge_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify notification of discharge information date is dated on the day of discharge or the following day  and result =Yes for +ve compliance", groups = {"Hedis TRC"} )
    public void TRC_VerifyNotificationDischarge() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        String DischargeDate=$x("(//label[contains(text(),'Discharge Date')]//following::input)[1]").getValue();
        System.out.println(DischargeDate);
        sleep(2000);
        /** On day of Discharge, day after discharge or earlier if documented in MR **/
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(DischargeDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 01);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        $(HedisTRCRepo.InformationOfDischargeInformationDate).setValue(newDate);
        sleep(2000);
        $(HedisTRCRepo.InformationOfDischargeInformationPage).setValue("1");
        sleep(2000);
        $(HedisTRCRepo.InformationOfDischargeInformationDropdwon).click();
        sleep(2000);
        $(HedisTRCRepo.YesButton).click();
        sleep(2000);

        HedisTRC.SaveData();
        String GetMsg=$x("(//tr[2]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Discharge Information shows +ve compliance");
        }else{
            logTestStepFail("Discharge Information not shows +ve compliance");
            Assert.fail("Discharge Information not shows +ve compliance");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
