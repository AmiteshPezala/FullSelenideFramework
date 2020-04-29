package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalPSRVerifyOptionOfCoverLetterForFax_TC36 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPSR objRetrievalPSR = new RetrievalPSR();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that options are available for cover letter while sending fax.", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyOptionOfCoverLetterForFax_TC36() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objRetrievalPSR.NavigateToPSR();
        sleep(2000);
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on the first AID.");
        sleep(5000);
        $(RetrievalPSRRepo.EditAddress).click();
        logTestStep("Clicked on edit address option to update the address details .");
        sleep(2000);
        $x("//input[@id='fax']").setValue("1111111111");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        sleep(3000);
        $(RetrievalPSRRepo.FirstRecordInAID).click();
        sleep(2000);
        $(RetrievalPSRRepo.FaxRequest).click();
        logTestStep("Clicked on fax request button.");
        sleep(3000);
        $$(RetrievalPSRRepo.SelectTemplateDropdown).filter(Condition.visible).last().click();
        Selenide.sleep(2000);
        ElementsCollection options =$$x("//p-dropdownitem//li//span");
        int Count=options.size();
        System.out.println(Count);
        if(Count > 0){
            logTestStepPass("Options available for cover letter while sending fax.");
        }else{
            logTestStepFail("Options not available for cover letter while sending fax.");
        }
        $x("//div[contains(text(),'FAX # :')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
