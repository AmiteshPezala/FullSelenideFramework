package MRCS.Modules.RiskModule;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static MRCS.Utils.TestBase.logInfoStepColored;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderLookUp {

    public static void NavigateToMagnifyingIcon() throws Exception {
        Risk objRisk = new Risk();
        objRisk.getUser();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        Common.ClickElement(ProviderLookUpRepo.BackwardButton,"Backward button");
    }
    public static void SearchForAdminKeyword() throws Exception {
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        sleep(2000);
        String Admin=Common.GetTimeStamp();
        $(ProviderLookUpRepo.SearchForProviderText).sendKeys("Admin");
        Common.ClickElement(ProviderLookUpRepo.SearchButton,"Search Button");
        sleep(2000);
    }
    public static void SearchForThirdRecord() throws Exception {
        String ThirdRecord=Common.getElementText(By.xpath("(//tr[3]//td[1])[2]"),2);
        logInfoStepColored(TestBase.COLOR.BLUE,"Third record:"+ThirdRecord);
        $(ProviderLookUpRepo.SearchForProviderText).setValue(ThirdRecord);
        Common.ClickElement(ProviderLookUpRepo.SearchButton,"Search Button");
        sleep(2000);
    }
    public static void SelectEncAsNoInDropdown() throws Exception {
        sleep(1000);
        $(ProviderLookUpRepo.FirstTextField).setValue("10");
        sleep(1000);
        $x("//div[contains(text(),'Specific service dates found in document (ENC)?')]").click();
        sleep(1000);
        Common.ClickElement(ProviderLookUpRepo.ENC,"Enc");
        sleep(1000);
        Common.ClickElement(ProviderLookUpRepo.ENCAsNo,"Enc As No");
        sleep(1000);
        $x("//div[contains(text(),'Specific service dates found in document (ENC)?')]").click();
        sleep(1000);
    }
}
