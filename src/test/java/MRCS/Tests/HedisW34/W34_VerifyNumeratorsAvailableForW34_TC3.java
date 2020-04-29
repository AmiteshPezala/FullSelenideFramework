package MRCS.Tests.HedisW34;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisW34;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class W34_VerifyNumeratorsAvailableForW34_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that all numerators are available for HedisW34 measure", groups = {"Hedis W34"})
    public void VerifyNumeratorsAvailableForW34_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisW34.navigateToW34();
        objRisk.membervalidation();
        sleep(2000);
        String Numerator1 =$x("//div[contains(text(),'Physical Exam')]").getText();
        assertText(Numerator1, "Physical Exam");
        sleep(2000);
        String Numerator2 = $x("//div[contains(text(),'Mental Development History')]").getText();
        assertText(Numerator2,"Mental Development History");
        sleep(2000);
        String Numerator3 = $x("//div[contains(text(),'Health Education / Ant Guidance')]").getText();
        assertText(Numerator3,"Health Education / Ant Guidance");
        sleep(2000);
        String Numerator4 =$x("//div[contains(text(),'Physical Development History')]").getText();
        assertText(Numerator4,"Physical Development History");
        sleep(2000);
        String Numerator5=$x("//div[contains(text(),'Health History')]").getText();
        assertText(Numerator5,"Health History");
        logTestStep("All numerators are available");
        sleep(2000);
        objLoginOut.logout();
    }
}
