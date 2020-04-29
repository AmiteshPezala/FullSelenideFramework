package MRCS.Tests.HedisIMA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisIMA;
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

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class IMA_PositiveComplianceForHPVFor3Dates_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "HPV shows +ve compliance when 3 HPV VACCINATIONS", groups = {"Hedis IMA"})
    public void PositiveComplianceForHPVFor3Dates_TC8() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisIMA.navigateToIMA();
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
        cal.add(Calendar.YEAR, 11);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String seconddate = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(seconddate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String thirddate = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(thirddate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        objMeasure.DeleteRow_IMA();
        sleep(2000);
        logTestStep("Fill data for 2 HPV VACCINATIONS (146 DAYS APART) OR 3 HPV VACCINATIONS ON OR BETWEEN THE MEMBER'S 9TH AND 13TH BIRTHDAY field");
        if($x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            int AdminData = $$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 2) + " ]").sendKeys("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 3) + " ]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 4) + " ]").sendKeys("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 5) + " ]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 6) + " ]").sendKeys("1");
            sleep(2000);
        }else{
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[2]").sendKeys("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[4]").sendKeys("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[6]").sendKeys("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Meningococcal')]"));
        sleep(2000);
        logTestStep("Checking the compliance for numerator Meningococcal");
        objMeasure.PositiveComplianceForHPV_IMA();
        sleep(2000);
        objLoginOut.logout();
    }
}
