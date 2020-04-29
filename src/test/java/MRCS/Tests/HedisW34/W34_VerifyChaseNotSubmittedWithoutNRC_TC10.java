package MRCS.Tests.HedisW34;

import MRCS.Locators.HedisRepo.HedisCOARepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.HedisW34;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class W34_VerifyChaseNotSubmittedWithoutNRC_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that negative compliance chase can not be submitted if NRC is not selected", groups = {"Hedis W34"})
    public void VerifyChaseNotSubmittedWithoutNRC_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        HedisW34.navigateToW34();
        objRisk.membervalidation();
        sleep(2000);
        int ClearIcon = $$(HedisCOARepo.ClearIcon).size();
        for(int i=1;i<=ClearIcon;i++)
            {
                ClickElement($x("(//button[@title='Clear'])[" +(i+0)+ "]"),"Clearing data");
                sleep(1000);
            }
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[contains(text(),'Exclusion')]"));
        sleep(2000);
        objMeasure.NegativeCompliance_ABA();
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[position() =2]").click();
        sleep(1000);
        String SuccessfulMessage = $x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").getText();
        assertText(SuccessfulMessage, "Negative reason code is missing from non-compliant numerator \"Well Child Visit\";");
        sleep(2000);
        objLoginOut.logout();
    }
}