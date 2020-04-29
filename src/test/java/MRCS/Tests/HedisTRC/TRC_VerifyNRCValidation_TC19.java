package MRCS.Tests.HedisTRC;
import MRCS.Modules.Hedis.HedisTRC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TRC_VerifyNRCValidation_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify NRC can be selected and validated upon submission when chase is non compliant", groups = {"Hedis COL"} )
    public void W15_VerifyNRC() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisTRC.NavigateToTRC();
        objRisk.membervalidation();
        HedisTRC.ClearData();
        HedisTRC.SaveData();
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(2000);
        //String getMsg=$x("//span[@class='ui-messages-icon pi pi-times']").getText();
        if($x("//span[@class='ui-messages-icon pi pi-times']").isDisplayed())
        {
            logTestStepPass("Validation message is displayed that NRC  selection is required");
        }else
        {
            logTestStepFail("Validation message is not displayed that NRC  selection is required");
            Assert.fail("Validation message is not displayed that NRC  selection is required");
        }
        sleep(2000);
        $x("//i[@class='pi pi-times']").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
