package MRCS.Tests.OR1;

import MRCS.Locators.*;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.Retry;
import MRCS.Utils.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyOR1EditFieldHighlight_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Clinical objclinical = new Clinical();
    @Test(retryAnalyzer = Retry.class,description = "Verify OR1 changes get highlighted", groups = {"OR1"} )
    public void VerifyOR1EditFieldHighlight() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Common.getUserAndAssignTo();
        sleep(2000);
        ClickElement(ProjectsRepo.Measure,"Measure");
        Log.info("Clicked on Measures tab");
        sleep(2000);
        ClickElement(MeasureRepo.BCS, "Clicking on BCS");
        ClickElement(ProjectsRepo.Update, "Clicking on Update button");
        sleep(10000);
        logTestStep("Clicking on First chase id");
        String ChaseId = $x("//tr[1]//td[2]").getText();
        System.out.println(ChaseId);
        SelectChaseAndOpenChart();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2017");
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[2]").setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        String GetMsg=$x("//span[contains(text(),'C/MR')]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Measure shows +ve compliance");
        }else{
            logTestStepFail("Measure not shows +ve compliance");
            Assert.fail("Measure not shows +ve compliance");
        }
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        ClickElement(CommonRepo.SubmitMeasure,"Clicking to submit data");
        sleep(4000);
        Common.StopWalkThru();
        sleep(2000);
        String getMsg=$x("//div[contains(text(),'YOUR CHASES')]").getText();
        if(getMsg.equals("YOUR CHASES"))
        {
            logTestStepPass("Chase submitted");
        }else
        {
            logTestStepFail("Chase not submitted");
            Assert.fail("Chase not submitted");
        }
        logInfoStepColored(COLOR.BLUE, "Chase id submitted from MRR");
        sleep(2000);
        objLoginOut.logout();
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonAdmin);
        logTestStep("Log in to application as a Manager user");
        Common.PopUp();
        String User=GetUserName();
        objclinical.ClinicalLink();
        ClickElement(ClinicalRepo.OR1,"OR1");
        sleep(2000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        sleep(2000);
        ClickElement(ProjectsRepo.Measure,"Measure");
        sleep(2000);
        ClickElement(MeasureRepo.BCS,"BCS measure");
        sleep(2000);
        ClickElement(CommonRepo.AssignTo,"AssignedTo");
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(User);
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update button");
        waitForPageLoadToComplete();
        sleep(5000);
        ClickElement($x("//tr[1]//td[2]"),"First Chase");
        ClickElement(RetrievalRepo.Chart,"");
        Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(2000);
        String PreviousColour=$x("(//div[contains(text(),'Mammogram')]//following::input)[1]").getCssValue("Previous border colour");
        Log.info(PreviousColour);
        sleep(2000);
        $x("//button[contains(text(),'×')]").click();
        sleep(2000);
        $x("//button[@class='control__add']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2016");
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[2]").setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Click to save");
        sleep(2000);
        logInfoStepColored(COLOR.BLUE, "Verifying color code");
        String borderColor=$x("(//div[contains(text(),'Mammogram')]//following::input)[1]").getCssValue("border-color");
        logInfoStepColored(COLOR.BLUE,"Border Color:"+ borderColor);
        sleep(2000);
        if(PreviousColour.equals(borderColor)){
            logTestStepFail("Fields are not highlighted");
        }else{
            logTestStepPass("Fields get highlighted.");
        }
        objLoginOut.logout();
    }
}
