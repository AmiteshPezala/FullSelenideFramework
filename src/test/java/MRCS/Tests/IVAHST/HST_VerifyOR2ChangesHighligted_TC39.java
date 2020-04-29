package MRCS.Tests.IVAHST;

import MRCS.Modules.Clinical;
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

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HST_VerifyOR2ChangesHighligted_TC39 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();
    Clinical objclinical=new Clinical();


    @Test(description = "Verify that OR2 update fields are highlighted or not.", groups = {"IVA HST"})
    public void HST_VerifyOR2ChangesHighligted_TC39() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
       // objclinical.AssignTo_OR2_HST();
        Common.waitForPageLoadToComplete();
        Common.SelectChaseAndOpenChart();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(5000);
        String PreviousBgColour = $x("//div[contains(text(),'Service Start Date')]//following::input").getCssValue("border-color");
        Log.info("PreviousBgColour" + PreviousBgColour);
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
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
        cal.add(Calendar.DAY_OF_WEEK, 10);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        $x("//div[contains(text(),'Service Start Date')]//following::input").setValue("2");
        sleep(2000);
        $x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").setValue(newDate);
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
        String CurrentBgColour=$x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").getCssValue("border-color");
        Log.info("CurrentBgColour :" +CurrentBgColour);
        sleep(2000);
        if(PreviousBgColour.equals(CurrentBgColour)){
            logTestStepFail("OR2 updated fields are not highlighted.");
        }else{
            logTestStepPass("OR2 updated fields are highlighted.");
        }
        objLoginOut.logout();
     }
}
