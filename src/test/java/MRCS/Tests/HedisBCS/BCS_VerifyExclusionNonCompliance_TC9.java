package MRCS.Tests.HedisBCS;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BCS_VerifyExclusionNonCompliance_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that exclusion non compliance shows only when exclusion date is in 2018 and page number is available", groups = {"Hedis BCS"} )
    public void BCS_VerifyExclusionNonCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ClickElement($(HedisBCSRepo.DeleteForExclusion), "Clicking to clear data");
        sleep(2000);
        Common.ClickElement(HedisBCSRepo.ExclusionDropdown,"");
        sleep(1000);
        Common.ClickElement(HedisBCSRepo.FirstElementInDropdown,"");
        String url =Common.getElementText(By.xpath("//*[contains(text(),'Breast Cancer Screening during')]"),5); // getting count of the xpath
        System.out.println(url);
        String[] arrSplit_3 = url.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 6; i < 7; i++) {
            count = arrSplit_3[i];
            break;
        }
        $(HedisBCSRepo.ExclusionDate).setValue(count);
        sleep(1000);
        $(HedisBCSRepo.ExclusionPageNumber).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Clicking to save data");
        sleep(2000);
        $x("//span[contains(text(),'NC/E')]").shouldHave(text("NC/E"));
        logTestStepPass("Exclusion non compliance shows only when exclusion date is in 2019 and page number is available");
        sleep(2000);
        ClickElement($(HedisBCSRepo.DeleteForExclusion), "Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
