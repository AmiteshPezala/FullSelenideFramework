package MRCS.Tests.HedisPPC;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClearAndSendKeys;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PPC_VerifyPrenatalComplianceWhenOBHistory_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that when OB History or Prenatal Risk Assessment is selected as prenatal visit type, then must have either an LMP, EDD or Gestation Age documented in the data entry screens for prenatal +ve compliance", groups = {"Hedis PPC"} )
    public void PPC_PrenatalCompliancePositiveWhenProviderPCP() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE,"Filling data in DOD from Med. Records field");
        String CurrentDate = Common.GetCurrentTimeStamp();
        $(HedisPPCRepo.DODFromMedRecordsDate).setValue("10/07/2019");
        sleep(2000);
        $(HedisPPCRepo.DODFromMedRecordsPage).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave, "Click to save");
        logInfoStepColored(COLOR.BLUE,"Date of Delivery (Admin):" + "10/07/2019");
        logInfoStepColored(COLOR.BLUE,"Taking DOD Prenatal Start Date");
        sleep(5000);
        String DODPrenatalDate=$x("(//label[contains(text(),'DOD Prenatal Start Date')]//following::div)[1]").getText();
        logInfoStepColored(COLOR.BLUE,"Prenatal start date:" + DODPrenatalDate);
        sleep(2000);

        /**ENTER DOS WHERE EDD IS FOUND. ENTER EDD FOUND ON THAT NOTE. **/
        logInfoStepColored(COLOR.BLUE,"Entering data for Date of Service for EDD:");
        ClearAndSendKeys(By.xpath("//div[contains(text(),'Date of Service for EDD:')]//following::input[1]"),"12/19/2018","Entering Date of Service for EDD:");
        ClearAndSendKeys(By.xpath("//div[contains(text(),'Date of Service for EDD:')]//following::input[2]"),"12/19/2018","Entering EDD from Med. Records");
        ClearAndSendKeys(By.xpath("//div[contains(text(),'Date of Service for EDD:')]//following::input[3]"),"1","Entering Page Number for Date of Service for EDD:");
        ClickElement(CommonRepo.ClickToSave, "Click to save");

        /** Prenatal Visit: **/
        logInfoStepColored(COLOR.BLUE,"Filling Prenatal Visit field");
        $(HedisPPCRepo.PrenatalVisitDate).setValue(DODPrenatalDate);
        sleep(1000);
        ClickElement($(HedisPPCRepo.PrenatalVisitDropDown1),"Clicking on Provider type dropdown");
        ClickElement($x("//span[contains(text(),'OB/GYN')]"),"Selecting OB/GYN provider");
        ClickElement($(HedisPPCRepo.PrenatalVisitDropDown2),"Clicking on Visit type dropdown");
        ClickElement($x("//span[contains(text(),'OB History or Risk Assessment')]"),"Selecting OB History or Risk Assessment Visit type");
        sleep(2000);
        $(HedisPPCRepo.PrenatalVisitPage).setValue("1");
        sleep(2000);
        HedisPPC.SaveData();
        String GetMsg=$x("//tr[1]//td[2]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Prenatal shows +ve compliance");
        }else{
            logTestStepFail("Prenatal not shows +ve compliance");
            Assert.fail("Prenatal not shows +ve compliance");
        }
        ClickElement($x("//div[contains(text(),'Prenatal Visit:')]//following::button[@class='control__delete ng-star-inserted']"),"Clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
