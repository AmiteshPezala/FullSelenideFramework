package MRCS.Modules.ProjectsModule;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.*;
import org.openqa.selenium.interactions.Actions;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Projects {
    WaitTool objWait = new WaitTool();
    public void ProjectsLink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Clicking on Navigation bar");
        Log.info("clicked on Navigation bar");
        ClickElement(ProjectsRepo.ProjectsLink,"Project link");
        Log.info("Clicked on ProjectsLink tab");
        Common.waitForPageLoadToComplete();
        sleep(2000);
    }
    public void ChaseQuery() throws Exception {
        ClickElement(ProjectsRepo.ChaseQueryHEDIS,"clicking on chase query");
        Log.info("Clicked on Chase Query HEDIS link");
        ClickElement(ProjectsRepo.Update,"clicking on update button");
        waitForPageLoadToComplete();
        sleep(25000);
        Log.info("Closed Popup");
        sleep(2000);
        $(".fa.fa-step-backward").click();
        Selenide.sleep(2000);
        ClickElement(ProjectsRepo.Filter,"clicking on filter");
        waitForPageLoadToComplete();
        sleep(2000);
        Log.info("Clicked on Filter button");
    }
    public void ChaseQueryMeasure() throws Exception {
        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
        Log.info("Clicked on Measures tab");
        waitForPageLoadToComplete();
        String MeasureSelected=$(ProjectsRepo.SelectedMeasure).getText();
        ClickElement(ProjectsRepo.SelectedMeasure,"Select measure");
        Log.info("Selected Measure");
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        Log.info("Clicked on Update button");
        waitForPageLoadToComplete();
        sleep(10000);
        String TotalRecord =$x("//div[@class='total-container']").getText();
        Log.info(TotalRecord);
        String ExpectedTotalRecord ="Top 0 records.";
        Log.info(ExpectedTotalRecord);
        if(TotalRecord.equals(ExpectedTotalRecord)) {
            Log.info("in if loop");
            logTestStep("Record After Applying filter :"+" "+TotalRecord);
        }else{
            //Doing comparison between the name of project
            Log.info("in else loop");
        ElementsCollection col = $$(ProjectsRepo.Comparison);
        Log.info("enter into comparison");
        int Colm = col.size();
        System.out.println(Colm);
        Log.info("No of cols are : " + Colm);
            Log.info("No of cols are : " + Colm);
            for (int i = 0; i < Colm; i++) {
                SelenideElement wbc = $x("//tr[\" + (i + 1) + \"]//td[4]//span[2]");
                String result = wbc.getText();
                assertText(result,MeasureSelected);
            }}
        }
    public void FilterByStatus() throws Exception {
        ClickElement(ProjectsRepo.Status,"Clicking on status");
        Log.info("Clicked on Status");
        waitForPageLoadToComplete();
        String SelectedStatus=$(ProjectsRepo.Pended).getText();
        ClickElement(ProjectsRepo.Pended,"Clicking on Pended");
        Log.info("Selected Pended");
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        Log.info("Clicked on Update button");
        waitForPageLoadToComplete();
        sleep(25000);
        String TotalRecord =$x("//div[@class='total-container']").getText();
        Log.info(TotalRecord);
        String ExpectedTotalRecord ="Top 0 records.";
        Log.info(ExpectedTotalRecord);
        if(TotalRecord.equals(ExpectedTotalRecord)) {
            Log.info("in if loop");
            logTestStep("Record After Applying filter :"+" "+TotalRecord);
        }else{
            Log.info("in else loop");
        // Doing comparison between pended status
        ElementsCollection col = $$(ProjectsRepo.StatusPended);
        Log.info("Enter into Comparison");
        int count=col.size();
        Log.info("No of counts are:" + count);
        for (int i = 0; i < count; i++) {
            String PendedStatus = $x("//tr[\" + (i + 1) + \"]//td[16]//span[2]").getText();
            Log.info(PendedStatus);
            assertText(PendedStatus, SelectedStatus);
        }}
    }
     public void FilterByPendCode() throws Exception {
        ClickElement(ProjectsRepo.PendCodes,"Clicking on PendCodes");
        Log.info("Clicked on Pend Codes");
        sleep(2000);
        String PendCode=$(ProjectsRepo.PC100).getText();
        ClickElement(ProjectsRepo.PC100,"PC100");
        Log.info("Selected PC100");
        ClickElement(ProjectsRepo.Update,"Update");
        Log.info("Clicked on Update button");
        waitForPageLoadToComplete();
        sleep(25000);
        String TotalRecord =$x("//div[@class='total-container']").getText();
        Log.info(TotalRecord);
        String ExpectedTotalRecord ="Top 0 records.";
        Log.info(ExpectedTotalRecord);
        if(TotalRecord.equals(ExpectedTotalRecord)) {
             Log.info("in if loop");
             logTestStep("Record After Applying filter :"+" "+TotalRecord);
        }else{
             Log.info("in else loop");
        // Doing comparison between pend codes
        ElementsCollection col=$$(ProjectsRepo.PendCodePC100);
        Log.info("Enter into Comparison");
        int count=col.size();
        Log.info("No of counts are:" + count);
        for(int i=0;i<count-1;i++){
            String PendCodePc100=$x("//tr[\" + (i + 1) + \"]//td[18]//span[2]").getText();
            Log.info(PendCodePc100);
            assertText(PendCodePc100,PendCode);
        }}
    }
    public void FilterByRisk() throws Exception {
        ClickElement(ProjectsRepo.Risk,"Risk");
        Log.info("Clicked on Risk");
        ClickElement(ProjectsRepo.HccNo,"HccNo");
        Log.info("Selected Hcc Discrepency");
        ClickElement(ProjectsRepo.Update,"Update");
        waitForPageLoadToComplete();
        Log.info("Clicked on Update button");
        sleep(25000);
        // Doing comparison between Risk
        ElementsCollection col=$$(ProjectsRepo.HccDep);
        Log.info("Enter into comparison");
        int count=col.size();
        Log.info("No of counts are:" +count);
        for(int i=0;i<count-1;i++){
           String RiskHccDep=$x("//tr[\" + (i + 1) + \"]//td[25]//span[2]").getText();
           Log.info(RiskHccDep);
           assertText(RiskHccDep,"No");
        }
    }
    public void FilterByProject() throws Exception {
        ClickElement(ProjectsRepo.Project,"Project");
        logTestStep("Click on Project");
        ClickElement(ProjectsRepo.ProjectName,"Project Name");
        logTestStep("Select project from list");
        sleep(1000);
        String ProjectName1 = $(ProjectsRepo.ProjectName).getText();//will get project name which is selected in filter
        Log.info(ProjectName1);
        ClickElement(ProjectsRepo.Update,"Update");
        waitForPageLoadToComplete();
        sleep(25000);
        String TotalRecord =$x("//div[@class='total-container']").getText();
        Log.info(TotalRecord);
        String ExpectedTotalRecord ="Top 0 records.";
        Log.info(ExpectedTotalRecord);
        if(TotalRecord.equals(ExpectedTotalRecord)) {
            Log.info("in if loop");
            logTestStep("Record After Applying filter :"+" "+TotalRecord);
        }else{
            //Doing comparison between the name of project
            Log.info("in else loop");
            ElementsCollection col = $$(ProjectsRepo.CheckboxOfProject);
            logTestStep("Enter into comparison");
            int record = col.size(); // Will get total number of records
            Log.info("No of cols are : " + record);
            for (int i = 0; i < record; i++) {
                String ProjectName = $x("//tr[\" + (i + 1) + \"]//td[6]").getText(); //checking that project name which is selected is matching the displayed project name
                assertText(ProjectName, ProjectName1);
            }
        }
    }
    public void GetDataFromChaseQuery() throws Exception {
        ClickElement(ProjectsRepo.ChaseQueryHEDIS,"ChaseQuery");
        Log.info("Clicked on ChaseQuery to getData");
        sleep(4000);
        $(ProjectsRepo.Project).click();
        logTestStep("Click on filter project");
        Selenide.sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        Selenide.sleep(2000);
        ClickElement(ProjectsRepo.Update,"Update");
        waitForPageLoadToComplete();
        sleep(25000);
        Log.info("Clicked on Update button");
    }
    public void UploadFile(){
        SelenideElement ChooseButton= $x("//span[contains(text(),'Choose')]");
        Actions actions=new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(ChooseButton).click().perform();
        Log.info("Clicked on Choose button");

    }
    public void DeleteFile() throws Exception {
        sleep(3000);
        ClickElement($x("(//span[contains(@class,'fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted')])[1]"),"Delete");
        ClickElement($x("//span[contains(text(),'Delete File')]"),"Delete File");
        $x("//div[@class='projectfiles-container']").click();

       waitForPageLoadToComplete();
    }
    public void HccMeasure() throws Exception {
        ClickElement(ProjectsRepo.Measure,"Measure");
        Log.info("Clicked on Measures tab");
        ClickElement(ProjectsRepo.SelectedMeasure,"Selected measure");
        Log.info("Selected HedisBCS");
        ClickElement(ProjectsRepo.Update,"Update");
        Log.info("Clicked on Update button");
        waitForPageLoadToComplete();
        sleep(5000);
    }
    public static void PendChaseIfPended() throws Exception {
        $x("//tr[1]//td[1]").click();
        logTestStep("Selecting first chase Id.");
        Selenide.sleep(2000);
        Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
        logTestStep("clicked on pend chase option.");
        sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[@class='ng-star-inserted'][contains(text(),'New')]").click();
        logTestStep("Selecting status as new.");
        sleep(2000);
        Common.ClickElement(RetrievalFTRepo.TextArea,"Text area");
        Selenide.sleep(2000);
        $(RetrievalFTRepo.TextArea).sendKeys("For testing purpose");
        logTestStep("Writing notes for pend chase.");
        Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
        logTestStep("Clicked on save button.");
        Selenide.sleep(1000);
        String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(SuccessfulMessage, "Pend saved successfully");
    }
    public static void PendChaseElsePended() throws Exception {
        $x("//tr[1]//td[1]").click();
        logTestStep("Selecting first chase Id.");
        Selenide.sleep(2000);
        Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
        logTestStep("clicked on pend chase option.");
        sleep(3000);
        $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        Selenide.sleep(2000);
        $$(RetrievalEMRRepo.DropDownValue).filter(Condition.visible).get(3).click();
        logTestStep("Selecting pend code from drop down.");
        sleep(2000);
        $x("//textarea[@id='notes']").sendKeys("For testing purpose");
        logTestStep("Writing notes for pend chase.");
        sleep(2000);
        Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
        logTestStep("Clicked on save button.");
        Selenide.sleep(1000);
        String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(SuccessfulMessage, "Pend saved successfully");
    }
}
