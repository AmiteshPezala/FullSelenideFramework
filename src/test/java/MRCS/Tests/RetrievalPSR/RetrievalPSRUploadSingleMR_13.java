package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRUploadSingleMR_13 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather MR is upload or not", groups = {"Retrieval PSR"})
    public void RetrievalPSRUploadSingleMR_13() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(2000);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        $(RetrievalRepo.AIDFirstRow).click();
        sleep(3000);
        $x("(//span[@class='ui-button-text ui-clickable'][contains(text(),'Upload')])[1]").click();
        sleep(2000);
        String chaseid =$x("//tr[1]//td[2]").getText();
        Log.info(chaseid);
        sleep(2000);
        $x("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Select All: YES')]").click();
        sleep(2000);
        Common.UploadDocument();
        sleep(2000);
        SelenideElement SubmitButton =$x("//span[contains(text(),'Submit')]");
        Actions actions1=new Actions(WebDriverRunner.getWebDriver());
        sleep(2000);
        actions1.moveToElement(SubmitButton).click().perform();
        logTestStep("File uploaded sucessfully");
        sleep(20000);
        //checking weather the chart is uploaded or not
        logTestStep("Searching same chase id to verify that chart is uploaded or not");
        $(ProjectsRepo.ProjectsLink).click();
        logTestStep("Clicked on ProjectsLink tab");
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        sleep(2000);
        logTestStep("clicked on chasequery option");
        $(ProjectsRepo.ChaseId).click();
        sleep(2000);
        $(ProjectsRepo.EnterChaseId).sendKeys(chaseid);
        sleep(2000);
        logTestStep("Searching chase id through Chase ID / Client Chase Key filter");
        $(ProjectsRepo.Update).click();
        sleep(60000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(3000);
        $x("//tr[1]//td[2]").click();
        sleep(2000);
        $(RetrievalRepo.Chart).click();
        sleep(5000);
        $(RetrievalRepo.ChaseInfo).click();
        sleep(10000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();",$x("//div[contains(text(),'LATEST DOCUMENTS')]"));
        logTestStep("Verifying weather the uploaded chart is available or not");
        sleep(2000);
        String NameOfDocument = $x("//div[@class='bold filename']").getText();
        sleep(2000);
        assertText(NameOfDocument,"Test.pdf");
        sleep(3000);
        logTestStep("The chart is uploaded Successfully");
        objLoginOut.logout();
    }
}