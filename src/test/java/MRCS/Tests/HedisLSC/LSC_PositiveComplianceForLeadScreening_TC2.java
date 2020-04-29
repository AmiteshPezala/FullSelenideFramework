package MRCS.Tests.HedisLSC;

import MRCS.Locators.HedisRepo.HedisLSCRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisLSC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class LSC_PositiveComplianceForLeadScreening_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify lead screening date is within 2 years of DOB for +ve screening ", groups = {"Hedis LSC"})
    public void LSC_PositiveComplianceForLeadScreening_TC2() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisLSC.NavigateToLSC();
        objRisk.membervalidation();
        sleep(2000);
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HedisLSC.DeleteAdd();
        $(HedisLSCRepo.BloodLeadDate).setValue(newDate);
        sleep(2000);
        $(HedisLSCRepo.BloodLeadLevel).setValue("1");
        sleep(2000);
        $(HedisLSCRepo.BloodLeadDropDown).click();
        sleep(2000);
        $x("//span[contains(text(),'Normal')]").click();
        sleep(2000);
        $(HedisLSCRepo.BloodLeadPage).setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Lead Screening')]"));
        sleep(2000);
        objMeasure.PositiveCompliance_LSC();
        sleep(2000);
        objLoginOut.logout();
    }
}
