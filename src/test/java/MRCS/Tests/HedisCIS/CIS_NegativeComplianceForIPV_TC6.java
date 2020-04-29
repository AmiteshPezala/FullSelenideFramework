package MRCS.Tests.HedisCIS;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisCIS;
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

public class CIS_NegativeComplianceForIPV_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that for IPV compliance date not before 42 days of age is not counted.", groups = {"Hedis CIS"})
    public void CIS_NegativeComplianceForIPV_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCIS.navigateToCIS();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_CIS();
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
        cal.add(Calendar.DAY_OF_MONTH, 2);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
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
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
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
        if ($x("(//div[contains(text(),'IPV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfIPV = $$x("(//div[contains(text(),'IPV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of IPV = " + CountOfIPV);
            int CountOfHepA = $$x("(//div[contains(text(),'HepA')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HepA = " + CountOfHepA);
            int FinalCount = CountOfIPV - CountOfHepA;
            System.out.println("Final count = " + FinalCount);
            if (CountOfIPV != CountOfHepA || CountOfHepA == 0) {
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[6]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=2]").click();
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=2]").click();
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=2]").click();
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[6]").setValue("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'IPV')]"));
        sleep(2000);
        objMeasure.NegativeComplianceIPV_CIS();
        sleep(2000);
        objLoginOut.logout();
        sleep(2000);
    }
}
