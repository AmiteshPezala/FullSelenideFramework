package MRCS.Tests.ThirdParty;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class UploadSingleMR_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify that MR get uploaded for the chase or not.", groups = {"Third party"})
    public void UploadSingleMR_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        objThirdParty.AssigningToLoggedInUser();
        sleep(2000);
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on first AID.");
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]//following::span[contains(text(),'Upload')]").click();
        sleep(2000);
        $x("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]").click();
        Selenide.sleep(2000);
        $x("//span[contains(text(),'Select All: YES')]").click();
        Selenide.sleep(2000);
        Common.UploadDocument();
        Selenide.sleep(2000);
        SelenideElement SubmitButton =$x("//span[contains(text(),'Submit')]");
        Actions actions1=new Actions(WebDriverRunner.getWebDriver());
        Selenide.sleep(2000);
        actions1.moveToElement(SubmitButton).click().perform();
        logTestStep("File uploaded successfully");
        Selenide.sleep(2000);
        $x("//span[contains(text(),'Home')]").click();
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        Selenide.sleep(20000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(5000);
        logTestStep("Clicked on notification icon");
        $x("//div[@class='notifications']").click();
        Selenide.sleep(4000);
        $x("//div[@class='ui-overlaypanel-content']/div/div[1]//a").click();
        sleep(3000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        sleep(3000);
        if($x("//ul//li//div//img").isDisplayed()){
            logTestStepPass("Chart uploaded successfully for the chase Id");
        }else{
            logTestStepFail("Chart not uploaded for the chase Id");
        }
        objLoginOut.logout();
    }
}
