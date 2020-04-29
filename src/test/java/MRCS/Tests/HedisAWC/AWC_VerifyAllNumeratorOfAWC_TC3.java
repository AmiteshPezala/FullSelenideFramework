package MRCS.Tests.HedisAWC;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisAWC;
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

public class AWC_VerifyAllNumeratorOfAWC_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that all numerators are available for AWC measure", groups = {"Hedis AWC"})
    public void VerifyAllNumeratorOfAWC_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisAWC.navigateToAWC();
        objRisk.membervalidation();
        sleep(2000);
        String Numerator1 = $x("//div[contains(text(),'Health History')]").getText();
        assertText(Numerator1,"Health History");
        sleep(2000);
        String Numerator2=$x("//div[contains(text(),'Mental Dev. History')]").getText();
        assertText(Numerator2,"Mental Dev. History");
        sleep(2000);
        String Numerator3=$x("//div[contains(text(),'Physical Dev. History')]").getText();
        assertText(Numerator3,"Physical Dev. History");
        sleep(2000);
        String Numerator4=$x("//div[contains(text(),'Physical Exam')]").getText();
        assertText(Numerator4,"Physical Exam");
        sleep(2000);
        String Numerator5=$x("//div[contains(text(),'Health Ed/Ant Guidance')]").getText();
        assertText(Numerator5,"Health Ed/Ant Guidance");
        sleep(2000);
        logTestStep("All numerators are available");
        sleep(2000);
        objLoginOut.logout();
    }
}
