package MRCS.Tests.HedisIMA;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisIMA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class IMA_VerifyValidationForTimeframe_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify validation message of timeframe for all fields", groups = {"Hedis IMA"})
    public void VerifyValidationForTimeframe_TC15() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisIMA.navigateToIMA();
        objRisk.membervalidation();
        sleep(2000);
        objMeasure.DeleteRow_IMA();
        sleep(2000);
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        logTestStep("Verifying validation message for Meningococcal field");
        $x("(//button[@class='control__add'])[position()=1]").click();
        sleep(2000);
        if($x("//div[contains(text(),'Tdap')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled']").isDisplayed()){
            Log.info("in if loop");
            int AdminData = $$x("//div[contains(text(),'Tdap')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled']").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[ " + (AdminData + 1) + " ]").setValue(DOB);
            sleep(2000);
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[ " + (AdminData + 2) + " ]").setValue("1");
            sleep(2000);
        }else {
            Log.info("in else loop");
            logTestStep("Fill data for MENINGOCOCCAL VACCINE ON OR BETWEEN THE MEMBER'S 11TH AND 13TH BIRTHDAY field ");
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[1]").setValue(DOB);
            sleep(2000);
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        if($x("//div[contains(text(),'Meningococcal')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message is displayed .");
        }else{
            logTestStepFail("Validation message not displayed.");
            Assert.fail("Validation message not displayed.");
        }
        sleep(2000);
        $x("(//button[contains(text(),'×')])[1]").click();
        sleep(2000);
        logTestStep("Verifying validation message for Tdap field");
        $x("(//button[@class='control__add'])[position()=2]").click();
        if($x("(//div[contains(text(),'Tdap')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            logTestStep("Fill data for TDAP VACCINE ON OR BETWEEN THE MEMBER'S 10TH AND 13TH BIRTHDAY field ");
            int CountofTdap = $$x("(//div[contains(text(),'Tdap')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            System.out.println("Count of TDAP = " + CountofTdap);
            sleep(2000);
            int CountOfHPV = $$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            System.out.println("Count of HPV = " + CountOfHPV);
            sleep(2000);
            int FinalCount = CountofTdap - CountOfHPV;
            System.out.println("Final count = " + FinalCount);
            if (CountofTdap != CountOfHPV || CountOfHPV == 0) {
                sleep(2000);
                $x("(//div[contains(text(),'Tdap')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(DOB);
                sleep(2000);
                $x("(//div[contains(text(),'Tdap')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
            } else {

                $x("(//div[contains(text(),'Tdap')]//following::input)[1]").setValue(DOB);
                sleep(2000);
                $x("(//div[contains(text(),'Tdap')]//following::input)[2]").setValue("1");
                sleep(2000);
            }
        }else{
            $x("(//div[contains(text(),'Tdap')]//following::input)[1]").setValue(DOB);
            sleep(2000);
            $x("(//div[contains(text(),'Tdap')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("//div[contains(text(),'Tdap')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message is displayed .");
        }else{
            logTestStepFail("Validation message not displayed.");
            Assert.fail("Validation message not displayed.");
        }
        sleep(2000);
        $x("(//button[contains(text(),'×')])[1]").click();
        sleep(2000);
        logTestStep("Verifying validation message for HPV field");
        if($x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            int AdminData = $$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 1) + " ]").setValue(DOB);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 2) + " ]").sendKeys("1");
        }else{
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[1]").setValue(DOB);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[2]").sendKeys("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        if($x("//div[contains(text(),'HPV')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message is displayed .");
        }else{
            logTestStepFail("Validation message not displayed.");
            Assert.fail("Validation message not displayed.");
        }
        sleep(2000);
        $x("(//button[contains(text(),'×')])[1]").click();
        sleep(2000);
        logTestStep("All validation messages are verified for all fields.");
        objLoginOut.logout();
    }
}
