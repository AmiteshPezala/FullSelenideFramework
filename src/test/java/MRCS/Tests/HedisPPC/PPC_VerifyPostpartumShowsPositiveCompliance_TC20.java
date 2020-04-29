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

public class PPC_VerifyPostpartumShowsPositiveCompliance_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that postpartum shows +ve compliance when postpartum Visit Date is within Postpartum Date Range", groups = {"Hedis PPC"} )
    public void PPC_VerifyPostpartumShowsPositiveCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE, "Verifying Postpartum shows +ve compliance");
        logInfoStepColored(COLOR.BLUE,"Filling data in DOD from Med. Records field");
        $(HedisPPCRepo.DODFromMedRecordsDate).setValue("10/07/2019");
        sleep(2000);
        $(HedisPPCRepo.DODFromMedRecordsPage).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave, "Click to save");
        logInfoStepColored(COLOR.BLUE,"Date of Delivery (Admin):" + "10/07/2019");
        logInfoStepColored(COLOR.BLUE,"Taking DOD Postpartum Start Date");
        sleep(5000);
        String DODPostpartumDate=$x("(//label[contains(text(),'DOD Postpartum Start Date')]//following::div)[1]").getText();
        logInfoStepColored(COLOR.BLUE,"Postpartum Start Date:" + DODPostpartumDate);
        sleep(2000);
        /** PostPartum Visit: **/
        if($(HedisPPCRepo.PostPartumVisitDate).isEnabled()) {
            logInfoStepColored(COLOR.BLUE, "Filling Prenatal Visit field");
            $(HedisPPCRepo.PostPartumVisitDate).setValue(DODPostpartumDate);
            sleep(1000);
            ClickElement($(HedisPPCRepo.PostPartumVisitDown1), "Clicking on Provider type dropdown");
            ClickElement($x("//span[contains(text(),'OB/GYN')]"), "Selecting OB/GYN provider");
            ClickElement($(HedisPPCRepo.PostPartumVisitDropDown2), "Clicking on Visit type dropdown");
            ClickElement($x("//span[contains(text(),'Dated Notation')]"), "Selecting Dated Notation");
            sleep(2000);
            $(HedisPPCRepo.PostPartumVisitPage).setValue("1");
            sleep(2000);
            HedisPPC.SaveData();
            String GetMsg = $x("//tr[2]//td[2]").getText();
            if (GetMsg.equals("C/MR")) {
                logTestStepPass("Postpartum shows +ve compliance");
            } else {
                logTestStepFail("Postpartum not shows +ve compliance");
                Assert.fail("Postpartum not shows +ve compliance");
            }
        }else
        {
            logTestStep("Postpartum disabled");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
