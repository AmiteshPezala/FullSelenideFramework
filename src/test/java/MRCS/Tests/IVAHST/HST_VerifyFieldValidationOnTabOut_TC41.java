package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyFieldValidationOnTabOut_TC41 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that Field get highlighted in red colour and validation message displayed on tab out.", groups = {"IVA HST"})
    public void HST_VerifyFieldValidationOnTabOut_TC41() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        String CurrentDate= $x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").getValue();
        Log.info("CurrentDate : "+CurrentDate );
        sleep(2000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(CurrentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 2);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("//div[contains(text(),'Service Start Date')]//following::input").setValue("3");
        sleep(2000);
        $x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").setValue("12/25/2020");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String Colour=$x("//div[contains(text(),'Service Start Date')]//following::div[@class='control__header__error ng-star-inserted']").getCssValue("border-color");
        Log.info("Colour :" + Colour);
        sleep(2000);
        if($x("//div[contains(text(),'Service Start Date')]//following::div[@class='control__header__error ng-star-inserted']").isDisplayed()){
            logTestStepPass("Field get highlighted in red colour and validation message displayed on tab out.");
        }else{
            logTestStepFail("Field is not highlighted and validation message in not displayed.");
        }
        objLoginOut.logout();
    }
}
