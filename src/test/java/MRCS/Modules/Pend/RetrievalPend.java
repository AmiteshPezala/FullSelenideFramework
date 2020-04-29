package MRCS.Modules.Pend;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Utils.Common;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPend {
    WaitTool objWait = new WaitTool();

    public static void PendLink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Clicking on Navigation bar");
        logTestStep("Clicked on Navigation bar");
        ClickElement(RetrievalPendRepo.Pend,"Clicking on RetrievalPend");
        logTestStep("Clicked on RetrievalPend Link");
        Common.waitForPageLoadToComplete();
        sleep(5000);
    }
    public static void NavigateToPendDetails() throws Exception {
        RetrievalPend objPend = new RetrievalPend();
        objPend.PendLink();
        Common.ClickElement(RetrievalPendRepo.TotalPend, "Total RetrievalPend");
        Common.ClickElement(RetrievalPendRepo.FirstPend, "First RetrievalPend");
        waitForPageLoadToComplete();
    }
    public static void VerifyUploadedDocument() throws Exception {
        String Description="Auto"+Common.GetTimeStamp();
        $(RetrievalPendRepo.Description).sendKeys(Description);
        sleep(2000);
        ClickElement(RetrievalPendRepo.UploadButton,"Upload button");
        String GetMsg=Common.getElementText(RetrievalPendRepo.ToasterMessage,4);
        if(GetMsg.equals("Document Uploaded successfully."))
        {
            logTestStepPass("File get uploaded and available under document tab");
        }
        else
        {
            logTestStepFail("File not uploaded");
            Assert.fail("File not uploaded");
        }
    }
    public static void RAD() throws Exception {
        RetrievalPend.NavigateToPendDetails();
        logTestStep("Clicking on Documents tab");
        Common.ClickElement(RetrievalPendRepo.DocumentsTab, "Doc");
        logTestStep("Clicking on Request Additional Document");
        Common.ClickElement(RetrievalPendRepo.RAD,"Request Additional Document");
        sleep(2000);
        $x("//label[@class='control__header__label'][contains(text(),'Document Request Type')]").click();
        sleep(2000);
        $(RetrievalPendRepo.RADDropdown).click();
        sleep(1000);
        Common.ClickElement(RetrievalPendRepo.FirstDropdownRecord,"Select First Record");
        sleep(1000);
        Common.ClickElement(RetrievalPendRepo.SelectAll,"Select All");
        String Text="QA Automation"+Common.GetTimeStamp();
        $(RetrievalPendRepo.NoteText).sendKeys(Text);
        sleep(1000);
        logTestStep("Clicking on Request Button");
        SelenideElement RequestButton= $(RetrievalPendRepo.RequestButton);
        Actions act=new Actions(WebDriverRunner.getWebDriver());
        act.moveToElement(RequestButton).click().perform();
        sleep(2000);
    }

}
