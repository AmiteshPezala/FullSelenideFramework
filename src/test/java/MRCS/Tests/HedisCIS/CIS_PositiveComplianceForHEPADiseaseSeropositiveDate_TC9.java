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

public class CIS_PositiveComplianceForHEPADiseaseSeropositiveDate_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "HEPA shows +ve compliance when 1 x Disease/Seropositive Date Between DOB and DOB+2yrs.", groups = {"Hedis CIS"})
    public void CIS_PositiveComplianceForHEPADiseaseSeropositiveDate_TC9() throws Exception {
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
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if($x("((//h4[contains(text(),'Disease/Seropositive')])[position()=1]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            int CountOfDisease = $$x("((//h4[contains(text(),'Disease/Seropositive')])[position()=1]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            int CountOfHIB = $$x("(//h4[contains(text(),'HepB')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            int FinalCount = CountOfDisease - CountOfHIB;
            if (CountOfDisease != CountOfHIB || CountOfHIB == 0) {
                $x("(//button[@class='control__add'])[position()=4]").click();
                sleep(2000);
                $x("(//div[contains(text(),' Disease/Seropositive ')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),' Disease/Seropositive ')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=4]").click();
                sleep(2000);
                $x("(//div[contains(text(),' Disease/Seropositive ')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),' Disease/Seropositive ')]//following::input)[2]").setValue("1");
                sleep(2000);
            }
        }else{
            $x("(//button[@class='control__add'])[position()=4]").click();
            sleep(2000);
            $x("(//div[contains(text(),' Disease/Seropositive ')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),' Disease/Seropositive ')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'HepA')]"));
        sleep(2000);
        objMeasure.PositiveComplianceHepA_CIS();
        sleep(2000);
        objLoginOut.logout();
    }
}
