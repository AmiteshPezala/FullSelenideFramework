package MRCS.Modules.ClinicalModule;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class OR1 {
    public  static void ClinicalLink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        logTestStep("Clicking on Clinical link ");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        sleep(2000);
    }
    public static void NavigateToOR1() throws Exception {
        OR1.ClinicalLink();
        ClickElement(ClinicalRepo.OR1,"OR1");
        sleep(2000);
    }
    public static void BulkAssignToUser() throws Exception {
        LoginOut objLoginOut = new LoginOut();
        String User= Common.GetUserName();
        System.out.println(User);
        OR1.NavigateToOR1();
        waitForPageLoadToComplete();
        Selenide.sleep(2000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(5000);
        $(MeasureRepo.BCS).click();
        logTestStep("Selecting BCS measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        $(".ui-chkbox-box",0).click();
        Common.ClickElement(MRQARepo.AssignChases,"Assign");
        Selenide.sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(User);
        Selenide.sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ARROW_DOWN);
        Selenide.sleep(2000);
        $(MRQARepo.AssignToUsers).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        $(MRQARepo.AssignButton).click();
        sleep(2000);
        if($x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").isDisplayed()){
            $x("//a//i[@class='pi pi-times']").click();
            $(".ui-chkbox-box",0).click();
            Common.ClickElement(MRQARepo.AssignChases,"Assign");
            Selenide.sleep(2000);
            $(MRQARepo.AssignToUsers).sendKeys("test 2020");
            Selenide.sleep(2000);
            $(MRQARepo.AssignToUsers).sendKeys(Keys.ARROW_DOWN);
            Selenide.sleep(2000);
            $(MRQARepo.AssignToUsers).sendKeys(Keys.ENTER);
            Selenide.sleep(2000);
            $(MRQARepo.AssignButton).click();
            String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
            Common.assertText(GetToasterMsg, "Assigned Successfully.");
            Selenide.sleep(5000);
            Actions actions = new Actions(WebDriverRunner.getWebDriver());
            actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
            ClickElement(LoginOutRepo.Logout,"Logout");
            Selenide.sleep(2000);
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonAdmin);
            OR1.NavigateToOR1();
            ClickElement(ProjectsRepo.Filter,"Filter");
            logTestStep("Clicking on Assigned To link");
            ClickElement(CommonRepo.AssignTo,"AssignedTo");
            sleep(2000);
            $(CommonRepo.AssignToUser).sendKeys("test 2020");
            sleep(2000);
            $(CommonRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
            sleep(2000);
            $(CommonRepo.AssignToUser).sendKeys(Keys.ENTER);
            sleep(2000);
            ClickElement(ProjectsRepo.Update,"Clicking on Update");
            waitForPageLoadToComplete();
            sleep(10000);
        }else{
            logTestStep("Alert not displayed");
            String GetToasterMsg=Common.getElementText(By.cssSelector(".ui-toast-detail"),5);
            Common.assertText(GetToasterMsg, "Assigned Successfully.");
            Selenide.sleep(5000);
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
            sleep(10000);
        }


    }
}
