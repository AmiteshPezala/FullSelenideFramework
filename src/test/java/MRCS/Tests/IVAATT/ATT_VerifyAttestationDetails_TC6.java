package MRCS.Tests.IVAATT;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAATT;
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

public class ATT_VerifyAttestationDetails_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify attestation details available on ATT form.", groups = {"IVA ATT"})
    public void ATT_VerifyAttestationDetails_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAATT.navigateToATT();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep("Verifying weather all details are available or not");
        String MemberId=$x("//label[contains(text(),'Member ID')]").getText();
        assertText(MemberId, "Member ID");
        sleep(2000);
        String FirstName= $x("//label[contains(text(),'Member First Name')]").getText();
        assertText(FirstName, "Member First Name");
        sleep(2000);
        String LastName= $x("//label[contains(text(),'Member Last Name')]").getText();
        assertText(LastName, "Member Last Name");
        sleep(2000);
        String claimId=$x("//label[contains(text(),'Claim ID')]").getText();
        assertText(claimId, "Claim ID");
        sleep(2000);
        String ProviderName=$x("//label[contains(text(),'Rendering Provider Name')]").getText();
        assertText(ProviderName, "Rendering Provider Name");
        sleep(2000);
        String DateFrom=$x("//label[contains(text(),'Service Date From')]").getText();
        assertText(DateFrom, "Service Date From");
        sleep(2000);
        String Datethru =$x("//label[contains(text(),'Service Date Thru')]").getText();
        assertText(Datethru, "Service Date Thru");
        sleep(2000);
        String EnciuntersDetails=$x("//label[contains(text(),'Confirm encounter details match')]").getText();
        assertText(EnciuntersDetails, "Confirm encounter details match");
        sleep(2000);
        logTestStep("All details are present");
        sleep(2000);
        objLoginOut.logout();
    }

}
