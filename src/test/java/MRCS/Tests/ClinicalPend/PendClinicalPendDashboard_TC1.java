package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendClinicalPendDashboard_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ClinicalPend objPend = new ClinicalPend();
    Common objCommon = new Common();

    @Test(description = "Verify whether pend home page stats ,counts and diagrams are loading or not", groups = {"Clinical Pend"})
    public void PendClinical() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        $(RetrievalPendRepo.Clinical).click();
        logTestStep("Clicked on clinical link");
        sleep(2000);
        String vaule= $x("//p[contains(text(),'PEND DISTRIBUTION BY PEND CODE')]").getText();
        Log.info(vaule);
        assertText(vaule,"PEND DISTRIBUTION BY PEND CODE");
        sleep(2000);
        $x("//div[@class='container-main']//div[@class='container-body']").click();
        sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)WebDriverRunner.getWebDriver();
        jse.executeScript("window.scrollBy(0,5000)", "vaule1");
        String vaule1 = $x("//p[contains(text(),'PEND DISTRIBUTION BY PROJECT')]").getText();
        assertText(vaule1,"PEND DISTRIBUTION BY PROJECT");
        sleep(2000);
        objLoginOut.logout();
    }
}
