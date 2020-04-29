package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ExportFunctionality_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();


    @Test(description = "Verify export functionality.", groups = {"Clinical Assignment"})
    public void ExportFunctionality_TC4() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(10000);
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(4000);
        $x("//span[contains(text(),'Export All')]").click();
        logTestStep("Clicked on Export all button");
        sleep(25000);
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
