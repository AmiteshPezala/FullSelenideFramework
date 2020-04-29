package MRCS.Tests.RetrievalPend;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class PendViewAllDocs_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Weather all documents are uploaded or not", groups = {"Retrieval Pend"})
    public void PendViewAllDocs_TC14() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objPend.PendLink();
        sleep(2000);
        $x("//a[@class='headerStatsItem ng-star-inserted']").click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        logTestStep("Selecting pend status option");
        sleep(2000);
        logTestStep("Selecting all status except closed ");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::div[5]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::div[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/following::li[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Closed'])[1]/following::span[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Request to Resolve'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        $x("//tr[1]//td[2]").click();
        sleep(2000);
        $x("//span[contains(text(),'VIEW ALL DOCUMENTS')]").click();
        logTestStep("Clicked on view all documents button");
        sleep(3000);
        $x("//span[contains(text(),'UPLOAD DOCUMENT')]").click();
        sleep(2000);
        Common.UploadDocument();
        $x("//textarea[@id='description']").setValue("Testing purpose");
        sleep(2000);
        $x("//div[@class='document-header']//following::span[contains(text(),'UPLOAD')]").click();
        sleep(2000);
        logTestStep("File uploaded successfully");
        sleep(2000);
        ElementsCollection col = $$(RetrievalPendRepo.TotalDocument);
        System.out.println(col);
        Log.info("enter into comparison");
        int record = col.size(); // Will get total number of records
        System.out.println(record);
        Log.info("No of cols are : " + record);
        if(record > 0){
            logTestStep("All uploaded documents are displayed");
        }else{
            Assert.fail("Documents are not displayed ");
        }
        objLoginOut.logout();
    }
}
