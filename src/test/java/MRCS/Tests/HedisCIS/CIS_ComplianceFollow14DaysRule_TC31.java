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

public class CIS_ComplianceFollow14DaysRule_TC31 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Admin and MR dates should be 14 days apart to show a +ve compliance.", groups = {"Hedis CIS"})
    public void CIS_ComplianceFollow14DaysRule_TC31() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisCIS.navigateToCIS();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_CIS();
        sleep(2000);
       if ($x("(//div[contains(text(),'IPV')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()){
            String AdminDate=$x("(//div[contains(text(),'IPV')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").getValue();
            System.out.println(AdminDate);
            sleep(2000);
            //int Date=Integer.parseInt(AdminDate);
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(AdminDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.DAY_OF_MONTH, 14);
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
            String Date4 = newDate2;
            SimpleDateFormat sdf3 = new SimpleDateFormat("M/d/yyyy");
            Calendar cal3 = Calendar.getInstance();
            try {
                cal3.setTime(sdf3.parse(Date4));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal3.add(Calendar.DAY_OF_MONTH, 1);
            String newDate3 = sdf3.format(cal3.getTime());
            System.out.println("new date" + newDate3);
            try {
                cal3.setTime(sdf3.parse(newDate3));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int AdminData = $$x("(//div[contains(text(),'IPV')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 2) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 3) + " ]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 4) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 5) + " ]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 6) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 7) + " ]").setValue(newDate3);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 8) + " ]").setValue("1");
            sleep(2000);
            $x("//div[@class='coding-container']").click();
            sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'DtaP')]"));
            sleep(2000);
            objMeasure.PositiveComplianceDtap_CIS();
            sleep(2000);
        }else {
           if ($x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
               String AdminDate = $x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").getValue();
               System.out.println("admin date " + AdminDate);
               sleep(2000);
               //int Date=Integer.parseInt(AdminDate);
               SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
               Calendar cal = Calendar.getInstance();
               try {
                   cal.setTime(sdf.parse(AdminDate));
               } catch (ParseException e) {
                   e.printStackTrace();
               }
               cal.add(Calendar.DAY_OF_MONTH, 14);
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
               int AdminData = $$x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
               $x("(//button[@class='control__add'])[position()=20]").click();
               sleep(2000);
               $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
               sleep(2000);
               $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminData + 2) + " ]").setValue("1");
               sleep(2000);
               $x("(//button[@class='control__add'])[position()=20]").click();
               sleep(2000);
               $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminData + 3) + " ]").setValue(newDate1);
               sleep(2000);
               $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminData + 4) + " ]").setValue("1");
               sleep(2000);
               $x("//div[@class='coding-container']").click();
               sleep(2000);
               JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
               js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'PCV')]"));
               sleep(2000);
               objMeasure.PositiveComplianceInfluenza_CIS();
               sleep(2000);
           } else {
               logTestStep("No admin date found");
           }
       }
        objLoginOut.logout();
    }
}
