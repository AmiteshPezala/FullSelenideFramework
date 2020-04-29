package MRCS.Tests.HedisPPC;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PPC_VerifyChaseCanBeSubmitted_TC27 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify chase can be submitted when the compliance is +ve", groups = {"Hedis PPC"} )
    public void PPC_VerifyChaseCanBeSubmitted() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying prenatal compliance show +ve");
        HedisPPC.DODFromMedRecords();
        sleep(4000);
        String DODPrenatalDate = $x("(//label[contains(text(),'DOD Prenatal Start Date')]//following::div)[1]").getText();
        sleep(2000);
        $(HedisPPCRepo.PrenatalVisitDate).setValue(DODPrenatalDate);
        sleep(1000);
        ClickElement($(HedisPPCRepo.PrenatalVisitDropDown1), "Clicking on Provider type dropdown");
        ClickElement($x("//span[contains(text(),'PCP')]"), "Selecting PCP provider");
        ClickElement($(HedisPPCRepo.PrenatalVisitDropDown2), "Clicking on Visit type dropdown");
        ClickElement($x("//span[contains(text(),'Pregnancy Diagnosis')]"), "Selecting Pregnancy Diagnosis Visit type");
        sleep(2000);
        $(HedisPPCRepo.PrenatalVisitPage).setValue("1");
        sleep(2000);
        HedisPPC.SaveData();
        String GetMsg = $x("//tr[1]//td[2]").getText();
        if (GetMsg.equals("C/MR")) {
            logTestStepPass("Prenatal shows +ve compliance");
        } else {
            logTestStepFail("Prenatal not shows +ve compliance");
            Assert.fail("Prenatal not shows +ve compliance");
        }
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
