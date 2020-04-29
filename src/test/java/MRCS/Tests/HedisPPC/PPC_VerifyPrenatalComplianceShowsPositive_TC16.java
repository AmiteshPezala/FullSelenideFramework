package MRCS.Tests.HedisPPC;
import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PPC_VerifyPrenatalComplianceShowsPositive_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify prenatal compliance shows +ve when Prenatal Visit Date is within DOD from MR Prenatal Visit Date Range (first trimester)", groups = {"Hedis PPC"} )
    public void PPC_VerifyPrenatalComplianceShowsPositive() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying prenatal compliance show +ve");
        HedisPPC.DODFromMedRecords();
        sleep(4000);
        String DODPrenatalDate=$(HedisPPCRepo.DODPrenatalStartDate).getText();
        sleep(2000);
        $(HedisPPCRepo.PrenatalVisitDate).setValue(DODPrenatalDate);
        sleep(1000);
        ClickElement($(HedisPPCRepo.PrenatalVisitDropDown1),"Clicking on Provider type dropdown");
        ClickElement($x("//span[contains(text(),'PCP')]"),"Selecting PCP provider");
        ClickElement($(HedisPPCRepo.PrenatalVisitDropDown2),"Clicking on Visit type dropdown");
        ClickElement($x("//span[contains(text(),'Pregnancy Diagnosis')]"),"Selecting Pregnancy Diagnosis Visit type");
        sleep(2000);
        $(HedisPPCRepo.PrenatalVisitPage).setValue("1");
        sleep(2000);
        HedisPPC.SaveData();
        String GetMsg=Common.getElementText(By.xpath("//tr[1]//td[2]"),5);
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Prenatal shows +ve compliance");
        }else{
            logTestStepFail("Prenatal not shows +ve compliance");
            Assert.fail("Prenatal not shows +ve compliance");
        }
        ClickElement($x("//*[contains(text(),'Prenatal Visit:')]//following::button[@class='control__delete ng-star-inserted']"),"Clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
