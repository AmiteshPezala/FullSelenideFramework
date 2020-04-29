package MRCS.Tests.HedisW15;

import MRCS.Modules.Hedis.HedisW15;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class W15_VerifyChaseCanSubmit_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Measure objMeasure = new Measure();

    @Test( description = "Verify chase can be submitted when the complaince is +ve", groups = {"Hedis W15"} )
    public void VerifyChaseCanSubmit() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisW15.NavigateToW15();
        objRisk.membervalidation();
        objMeasure.DeleteRow_CIS();
        HedisW15.PositiveCompliance();
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("(//tr[1]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("well child visit shows +ve compliance when all the numerators dates falls in MY");
        }else{
            logTestStepFail("well child visit not shows +ve compliance when all the numerators dates falls in MY");
        }
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
