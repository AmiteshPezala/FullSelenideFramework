package MRCS.Tests.HedisCOA;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Hedis.HedisCOA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class COA_VerifyNRC_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify NRC can be selected and validated upon submission when chase is non compliant", groups = {"Hedis COA"} )
    public void COA_VerifyNRC() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        HedisCOA.ClearData();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        objRisk.ChecklistForART();
        sleep(2000);
        ClickElement(CommonRepo.SubmitMeasure,"Submit messaure");
        sleep(4000);
        if($x("//span[@class='ui-messages-icon pi pi-times']").isDisplayed())
        {
            logTestStepPass("Validation message is displayed that NRC  selection is required");
        }else
        {
            logTestStepFail("Validation message not displayed that NRC  selection is required");
        }
        sleep(2000);
        ClickElement($x("//i[@class='pi pi-times']"),"Close toaster message");
        //sleep(2000);
        objLoginOut.logout();
    }
}
