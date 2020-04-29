package MRCS.Tests.MRR;

import MRCS.Locators.*;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.*;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;


public class VerifyChaseMove_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Chase move back", groups = {"MRR"})
    public void VerifyChaseMove() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Clinical link");
        String User=GetUserName();
        objRetrieval.RetrievalLink();
        ClickElement(RetrievalRepo.MRQA,"Clicking on MRQA");
        logTestStep("Clicked on MRQA Link");
        waitForPageLoadToComplete();
        ClickElement(ProjectsRepo.Filter,"Filter");
        logTestStep("Clicking on Assigned To link");
        ClickElement(CommonRepo.AssignTo,"AssignedTo");
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(User);
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        waitForPageLoadToComplete();
        sleep(5000);
        String GetFirstChaseId=$(CommonRepo.FirstMRQARecord).getText();
        logInfoStepColored(COLOR.BLUE,"Chase id which capture in MRQA:" +GetFirstChaseId);
        sleep(2000);
        ClickElement(CommonRepo.FirstChaseId,"Selecting Chase id");
        waitForPageLoadToComplete();
        sleep(2000);
        logTestStep("Clicking on Move Back button to move back chase");
        $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'MOVE BACK')]").click();
        ClearAndSendKeys(By.xpath("//textarea[@id='chaseNotes']"),"TestingByNk","Notes");
        ClickElement(CommonRepo.Save,"Save");
        logTestStep("Clicking on Project link");
        ClickElement(ProjectsRepo.ProjectsLink,"Project link");
        logTestStep("Clicking on Chase Query");
        sleep(30000);
        ClickElement(ProjectsRepo.ChaseQueryHEDIS,"Clicking on ChaseQuery");
        sleep(2000);
        ClickElement(ProjectsRepo.ChaseId,"Clicking on Chase Id");
        ClearAndSendKeys(ProjectsRepo.EnterChaseId,GetFirstChaseId,"Entering chase id which taken in MRQA");
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        waitForPageLoadToComplete();
        ClickElement(CommonRepo.FirstChaseId,"Selecting Chase id");
        waitForPageLoadToComplete();
        logInfoStepColored(COLOR.BLUE,"Comparing chase status");
        $x("//span[contains(text(),'Readonly View')]").shouldBe(Condition.visible);
        objLoginOut.logout();
    }
}
