package MRCS.Tests.HedisTRC;

import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class TRC_VerifyRevisedAdmissionDate_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that revised admission date must be within 30 days of Admin Admission Date", groups = {"Hedis TRC"} )
    public void TRC_VerifyRevisedAdmissionDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        sleep(2000);
        HedisTRC.ClearData();
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
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        if($x("//span[@class='ui-messages-icon pi pi-times']").waitUntil(Condition.appear,10000).isDisplayed()){
            logTestStepPass("Validation message displayed");
        }else{
            logTestStepFail("Validation message not displayed");
            Assert.fail("Validation message not displayed");
        }
        sleep(2000);
        $x("//i[@class='pi pi-times']").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
