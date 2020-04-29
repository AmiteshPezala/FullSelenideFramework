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

public class IMA_PositiveComplianceForHPVFor14DaysDifference_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "HPV shows +ve compliance when 2 HPV VACCINATIONS has 14 days difference in them.", groups = {"Hedis IMA"})
    public void PositiveComplianceForHPVFor14DaysDifference_TC9() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisIMA.navigateToIMA();
        objRisk.membervalidation();
        sleep(3000);
        if($x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            int AdminData = $$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            sleep(2000);
            String AdminDate =$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])[1]").getValue();
            sleep(2000);
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
            String seconddate = AdminDate;
            SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
            Calendar cal1 = Calendar.getInstance();
            try {
                cal1.setTime(sdf1.parse(seconddate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal1.add(Calendar.DAY_OF_MONTH, -14);
            String newDate1 = sdf1.format(cal1.getTime());
            System.out.println("new date" + newDate1);
            try {
                cal1.setTime(sdf1.parse(newDate1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            objMeasure.DeleteRow_IMA();
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 2) + " ]").sendKeys("1");
            sleep(2000);
            $x("//div[@class='coding-container']").click();
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 3) + " ]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 4) + " ]").sendKeys("1");
            sleep(2000);
            $x("//div[@class='coding-container']").click();
            sleep(2000);
            JavascriptExecutor js1 = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            js1.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Meningococcal')]"));
            sleep(2000);
            logTestStep("Checking the compliance for numerator HPV");
            objMeasure.PositiveComplianceForHPV_IMA();
            sleep(2000);

        }else{
            logTestStep("Admin date is not available");
        }
    }
}
