package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.TestData.ReveleerTestData;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class RetrievalEMRUploadAccessInfo_TC26 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();
    ReveleerTestData objRev=new ReveleerTestData();

    @Test(description = "Verify upload access info", groups = {"Retrieval EMR"})
    public void RetrievalEMRUploadAccessInfo() throws Exception {
        logTestStep("Log in to application");
        objRev.GetData("Retrieval");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID, "First Record");
        waitForPageLoadToComplete();
        sleep(5000);
        //$(RetrievalEMRRepo.AccessInfo).click();
        $(CommonRepo.BackwardButton).click();
        Common.UploadDocument();
        SelenideElement SubmitButton =$(RetrievalEMRRepo.SubmitButton);
        Actions actions=new Actions(WebDriverRunner.getWebDriver());
        Selenide.sleep(2000);
        actions.moveToElement(SubmitButton).click().perform();
        logTestStepPass("File uploaded successfully");
        String getMsg=Common.getElementText(RetrievalEMRRepo.ToasterMessage,10);
        assertText(getMsg,"Access Info document(s) Uploaded successfully.");
        objLoginOut.logout();
    }
}
