package MRCS.Tests.HedisMRP;

import MRCS.Locators.HedisRepo.HedisMRPRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisMRP;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MRP_VarifyValidationMessageForRDD_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify validation message for revised discharge date ", groups = {"Hedis MRP"})
    public void MRP_VarifyValidationMessageForRDD_TC4() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisMRP.navigateToMRP();
        objRisk.membervalidation();
        sleep(2000);
        String AdminDate=$(HedisMRPRepo.AdminDate).getValue();
        Log.info(AdminDate);
        sleep(2000);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(AdminDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 3);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("(//label[contains(text(),'Discharge Date (admin)')]//following::button)[1]").click();
        sleep(2000);
        $(HedisMRPRepo.RevisedDischargedDate).setValue(newDate);
        sleep(2000);
        $(HedisMRPRepo.RevisedDischargedPage).setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        String Message=$x("//div[@class='control__header__error ng-star-inserted']").getText();
        assertText(Message,"Date between 01/01/2019 and 12/01/2020 expected;");
        sleep(2000);
        objLoginOut.logout();
    }
}
