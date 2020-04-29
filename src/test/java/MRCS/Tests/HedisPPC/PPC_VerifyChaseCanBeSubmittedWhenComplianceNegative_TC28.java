package MRCS.Tests.HedisPPC;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PPC_VerifyChaseCanBeSubmittedWhenComplianceNegative_TC28 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when chase shows -ve compliance", groups = {"Hedis PPC"} )
    public void PPC_VerifyChaseCanBeSubmittedWhenComplianceNegative() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE, "Clearing all pre-filled data");
        ClickElement($x("//div[contains(text(),'Prenatal Visit:')]//following::button[@class='control__delete ng-star-inserted']"),"Clear data");
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        ClickElement($x("//label[contains(text(),'NRC - Prenatal')]//following::button[1]"),"Clicking on NRC dropdown");
        sleep(1000);
        ClickElement($x("//span[contains(text(),'Prenatal visit outside of time frame')]"),"Selecting from dropdown");
        if($("#NRCPostpartum").waitUntil(Condition.visible,3000).isEnabled())
        {
            ClickElement($x("//label[contains(text(),'NRC - Postpartum')]//following::button[1]"),"Clicking on NRC dropdown");
            ClickElement($x("//span[contains(text(),'Postpartum visit outside of timeframe')]"),"Selecting from dropdown");
        }else
        {
            logTestStep("Postpartum field is disabled");
        }
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        ClickElement(CommonRepo.SubmitMeasure,"Submitting PPC measure");
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
            Assert.fail("Chase not submitted");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
