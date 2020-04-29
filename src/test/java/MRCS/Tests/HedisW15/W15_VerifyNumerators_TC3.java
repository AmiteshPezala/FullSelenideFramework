package MRCS.Tests.HedisW15;
import MRCS.Modules.Hedis.HedisW15;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class W15_VerifyNumerators_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();
    Common objcommon = new Common();

    @Test(description = "Verify that all numerators are available for W15 measure", groups = {"Hedis W15"})
    public void VerifyNumeratorsOfW15_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisW15.NavigateToW15();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        String Numerator1 = $x("//div[contains(text(),'Physical Exam')]").getText();
        assertText(Numerator1, "Physical Exam +");
        sleep(2000);
        String Numerator2=$x("//div[contains(text(),'Mental Development History')]").getText();
        assertText(Numerator2,"Mental Development History +");
        sleep(2000);
        String Numerator3=$x("//div[contains(text(),'Health Education / Ant Guidance')]").getText();
        assertText(Numerator3,"Health Education / Ant Guidance +");
        sleep(2000);
        String Numerator4=$x("//div[contains(text(),'Physical Development History')]").getText();
        assertText(Numerator4,"Physical Development History +");
        sleep(2000);
        String Numerator5=$x("//div[contains(text(),'Health History')]").getText();
        assertText(Numerator5,"Health History +");
        sleep(2000);
        logTestStep("All numerators are available");
        sleep(2000);
        objLoginOut.logout();
    }
}
