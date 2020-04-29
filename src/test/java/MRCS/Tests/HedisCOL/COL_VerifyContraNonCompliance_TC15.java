package MRCS.Tests.HedisCOL;

import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Modules.Hedis.HedisCOL;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class COL_VerifyContraNonCompliance_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that contra- non compliance shows only when contra date is in 2018 and page number is available", groups = {"Hedis COL"} )
    public void COL_VerifyContraNonCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        objRisk.membervalidation();
        sleep(2000);
        HedisCOL.ClearIcon();
        HedisCOL.DeleteIcon();
        Common.ClickElement(HedisCCSRepo.Contra,"");
        Common.ClickElement(HedisBCSRepo.FirstElementInDropdown,"");
        ClearAndSendKeys($(HedisCCSRepo.ContraDate),"12/31/2018","Filling exclusion date");
        ClearAndSendKeys($(HedisCCSRepo.ContraPageNumber),"1","Filling exclusion page number");
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").shouldHave(text("NC/C"));
        logTestStepPass("Contra non compliance shows only when exclusion date is in 2019 and page number is available");
        sleep(2000);
        ClickElement($x("//label[contains(text(),'Contra')]//following::button[@class='control__delete'][1]"), "Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
