package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
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

public class ENR_VerifyEnrollmentPeriodGridData_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify weather grid data includes plan ID,from date,through date,premium amount,APTC and RA.", groups = {"IVA ENR"})
    public void ENR_VerifyEnrollmentPeriodGridData_TC23() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("verifying data of enrollement period grid");
        String PlanId = $x("(//div[@class='control__header__label'])[6]").getText();
        assertText(PlanId, "Plan ID");
        sleep(2000);
        String EnrollmentFromDate = $x("(//div[@class='control__header__label'])[7]").getText();
        assertText(EnrollmentFromDate, "Enrollment From Date");
        sleep(2000);
        String EnrollmentThruDate = $x("(//div[@class='control__header__label'])[8]").getText();
        assertText(EnrollmentThruDate, "Enrollment Thru Date");
        sleep(2000);
        String PremiumAmount = $x("(//div[@class='control__header__label'])[9]").getText();
        assertText(PremiumAmount, "Premium Amount");
        sleep(2000);
        String APTC = $x("(//div[@class='control__header__label'])[10]").getText();
        assertText(APTC, "APTC");
        sleep(2000);
        String RatingArea=$x("(//div[@class='control__header__label'])[11]").getText();
        assertText(RatingArea, "Rating Area");
        sleep(2000);
        logTestStep("Grid data includes plan ID,from date,through date,premium amount,APTC and RA.");
        sleep(2000);
        objLoginOut.logout();
    }
}
