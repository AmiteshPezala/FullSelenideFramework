package MRCS.Tests.RetrievalFT;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalFTUploadSingleMR_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather MR is upload or not", groups = {"Retrieval FT"})
    public void RetrievalFTUploadSingleMR() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        logTestStep("Clicked on address id");
        Common.ClickElement(RetrievalFTRepo.FirstFTAID,"First");
        sleep(5000);
        $(RetrievalRepo.Upload).click();
        sleep(2000);
        String ChaseId =$x("//tr[1]//td[2]").getText();
        Log.info(ChaseId);
        logTestStep("Chase Id where documents uploaded:"+ChaseId);
        sleep(2000);
        $x("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Select All: YES')]").click();
        sleep(2000);
        Common.UploadDocument();
        sleep(5000);
        SelenideElement SubmitButton =$x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Submit')]");
        Actions actions1=new Actions(WebDriverRunner.getWebDriver());
        sleep(2000);
        actions1.moveToElement(SubmitButton).click().perform();
        if($x("//*[@class='ui-toast-detail']").waitUntil(Condition.visible,DEFAULT_WAIT).isDisplayed())
        {
            logTestStepPass("File uploaded successfully");
        }else
        {
            logTestStepFail("File not uploaded successfully");
            Assert.fail("File not uploaded successfully");
        }
        sleep(20000);
        $(ProjectsRepo.ProjectsLink).click();
        logTestStep("Clicked on ProjectsLink tab");
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        sleep(2000);
        //checking weather the chart is uploaded or not
        logTestStep("Searching same chase id to verify that chart is uploaded or not");
        logTestStep("clicked on Chase Query option");
        $(ProjectsRepo.ChaseId).click();
        sleep(2000);
        $(ProjectsRepo.EnterChaseId).sendKeys(ChaseId);
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
