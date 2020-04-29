package MRCS.Modules.BulkActionsModule;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static MRCS.Utils.WaitTool.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;

public class BulkChanges {


    public static void BulkChangesLink() throws Exception {
        logTestStep("Clicking on Bulk Action");
        ClickElement(BulkActionsRepo.BulkAction,"Bulk action link");
        sleep(2000);
        logTestStep("Clicking on Bulk Changes");
        ClickElement(BulkActionsRepo.BulkChanges,"Bulk changes link");
        sleep(2000);
    }
    public static void GettingChaseId() throws Exception {
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        sleep(2000);
        ClickElement(ClinicalRepo.Clinical,"clinical link ");
        logTestStep("Clicked on Navigation bar");
        sleep(2000);
        ClickElement(ClinicalRepo.MRR,"clinical link ");
        logTestStep("Clicked on Navigation bar");
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Status')]").click();
        sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[contains(text(),'Data Entry')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        }

        public static void GettingAssignedUser() throws Exception {
            Common objCommon = new Common();
            objCommon.getUserAndAssignTo();
            sleep(2000);
            $x("(//*[contains(text(),'Client')])[2]").click();
            sleep(2000);
            $x("//input[@id='ClientId']").sendKeys("Testing group 0");
            sleep(2000);
            $x("//input[@id='ClientId']").sendKeys(Keys.ARROW_DOWN);
            sleep(2000);
            $x("//input[@id='ClientId']").sendKeys(Keys.ENTER);
            sleep(2000);
            $(ProjectsRepo.Update).click();
            sleep(2000);
        }
        public static void GettingChaseIdOfSameClient() throws Exception {
            Clinical objClinical = new Clinical();
            objClinical.ClinicalLink();
            ClickElement(ClinicalRepo.MRR,"MRR");
            waitForPageLoadToComplete();
            ClickElement(ProjectsRepo.Filter,"Filter");
            sleep(2000);
            $x("//span[contains(text(),'Status')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Status')]//following::span[contains(text(),'Select All')]").click();
            sleep(2000);
            $x("//span[@class='ui-chkbox-icon ui-clickable pi pi-check']").click();
            sleep(2000);
            $x("(//*[contains(text(),'Client')])[2]").click();
            sleep(2000);
            $x("//input[@id='ClientId']").setValue("testing group");
            sleep(2000);
            $x("//input[@id='ClientId']").sendKeys(Keys.ARROW_DOWN);
            sleep(2000);
            $x("//input[@id='ClientId']").sendKeys(Keys.ENTER);
            sleep(2000);
            $(ProjectsRepo.Update).click();
            sleep(2000);
        }
        public static void GettingPendIdToResolve() throws Exception {
            RetrievalPend objPend = new RetrievalPend();
            objPend.PendLink();
            $x("//div[@class='statistics']//div[1]").click();
            sleep(3000);
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//*[contains(text(),'Pend Status')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Select All')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Closed')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Resolved')]").click();
            sleep(2000);
            $(ProjectsRepo.Update).click();
            $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        }
        public static void GettingPendIdToClose() throws Exception {
            RetrievalPend objPend = new RetrievalPend();
            objPend.PendLink();
            $x("//div[@class='statistics']//div[1]").click();
            sleep(3000);
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//*[contains(text(),'Pend Status')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Select All')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Closed')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'New')]").click();
            sleep(2000);
            $(ProjectsRepo.Update).click();
            sleep(2000);
        }
        public static void GettingPendIdOfClient() throws Exception {
            RetrievalPend objPend = new RetrievalPend();
            objPend.PendLink();
            $x("//div[@class='statistics']//div[1]").click();
            sleep(3000);
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//*[contains(text(),'Pend Status')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Select All')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Closed')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Resolved')]").click();
            sleep(2000);
            $x("//*[contains(text(),'Owner')]").click();
            sleep(2000);
            $x("//p-radiobutton[2]//div[1]//div[2]").click();
            sleep(2000);
            $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Projects')]").click();
            sleep(2000);
            $x("//span[contains(text(),'2020 HEDIS 1')]").click();
            sleep(2000);
            $(ProjectsRepo.Update).click();
            sleep(2000);
        }
        public static void GettingPendOfReveleer() throws Exception {
            RetrievalPend objPend = new RetrievalPend();
            objPend.PendLink();
            $x("//div[@class='statistics']//div[1]").click();
            sleep(3000);
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//*[contains(text(),'Pend Status')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Select All')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Closed')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Pend Status')]//following::span[contains(text(),'Resolved')]").click();
            sleep(2000);
            $x("//*[contains(text(),'Owner')]").click();
            sleep(2000);
            $x("//p-radiobutton[1]//div[1]//div[2]").click();
            sleep(2000);
            $(ProjectsRepo.Update).click();
            sleep(2000);
        }

        public static void GetChaseAndPerformPendUpdate() throws Exception {
            String ChaseId1 = $(BulkActionsRepo.FirstChaseId).getText();
            sleep(2000);
            String ChaseId2 = $(BulkActionsRepo.SecondChaseId).getText();
            String ChaseId = ChaseId1 + "," + ChaseId2;
            BulkChanges.BulkChangesLink();
            $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(0).click();
            $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(1).click(); // selecting RetrievalPend from drop down
            $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
            $$(BulkActionsRepo.DropDownIcon).filter(Condition.visible).get(1).click();
            $$(BulkActionsRepo.DropDownElement).filter(Condition.visible).get(4).click(); // selecting update 3rd party field
            $(BulkActionsRepo.PendIdText).sendKeys(ChaseId);
            $(BulkActionsRepo.Continue).click();
            $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        }
}
