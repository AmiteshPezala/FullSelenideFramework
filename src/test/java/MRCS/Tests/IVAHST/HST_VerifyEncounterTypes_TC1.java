package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyEncounterTypes_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify three encounters types are present.", groups = {"IVA HST"} )
    public void HST_VerifyEncounterTypes_TC1() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        String Type1=$x("//h3[contains(text(),'Diagnoses')]//preceding::span[contains(text(),'Total')]").getText();
        Log.info(Type1);
        sleep(2000);
        assertText(Type1, "Total");
        sleep(2000);
        String Type2=$x("//h3[contains(text(),'Diagnoses')]//preceding::span[contains(text(),'Admin')]").getText();
        Log.info(Type2);
        sleep(2000);
        assertText(Type2, "Admin");
        String Type3=$x("//h3[contains(text(),'Diagnoses')]//preceding::span[contains(text(),'Added')]").getText();
        Log.info(Type3);
        sleep(2000);
        assertText(Type3, "Added");
        logTestStepPass("All encounter types are present.");
        sleep(2000);
        objLoginOut.logout();
      }
}
