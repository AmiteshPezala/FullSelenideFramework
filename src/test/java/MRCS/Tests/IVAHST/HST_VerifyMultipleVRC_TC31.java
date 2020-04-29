package MRCS.Tests.IVAHST;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyMultipleVRC_TC31 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify multiple VRC is allowed for single diagnostic line", groups = {"IVA HST"} )
    public void HST_VerifyMultipleVRC() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        sleep(2000);
        objRisk.AddDiagnoses();
        sleep(2000);
        objRisk.EnterDiagnosticData();
        sleep(2000);
        $x("//div//form-vrc-dropdown//div[1]//p-dropdown//div//label").click();
        Selenide.sleep(1000);
        $x("(//p-dropdownitem//li//span)[2]").click();
        Selenide.sleep(1000);
        $x("//h4[contains(text(),'ICD Information')]").click();
        Selenide.sleep(2000);
        ElementsCollection MultipleVRC = $$x("//div[@class='selected ng-star-inserted']");
        int VRCCount=MultipleVRC.size();
        System.out.println(VRCCount);
        logTestStep("Diagnostic grid data is updated");
        $x("//span[@class='selected__delete']").click();
        if(VRCCount>1){
            logTestStep("Multiple VRC is allowed for single diagnostic line");
        }
        else{
            Assert.fail("Multiple VRC is not allowed for single diagnostic line");
        }
        Selenide.sleep(3000);
        objLoginOut.logout();
    }
}
