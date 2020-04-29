package MRCS.Modules;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Log;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class Clinical {
    WaitTool objWait = new WaitTool();

    public  static void ClinicalLink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        logTestStep("Clicking on Clinical link ");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        sleep(2000);
    }
    public void AssignTo_OR2() throws Exception {
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        logTestStep("Clicking on Clinical link ");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        sleep(2000);
        Thread.sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"),"My profile");
        Thread.sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        Thread.sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        Thread.sleep(1000);
        String User = FirstName + " " + LastName;
        Thread.sleep(2000);
        ClickElement(ClinicalRepo.OR2,"OR2");
        waitForPageLoadToComplete();
        ClickElement(ProjectsRepo.Filter,"Filter");
        //sleep(2000);
        logTestStep("Clicking on Assigned To link");
        ClickElement($x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]"),"AssignedTo");
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.BCS).click();
        logTestStep("Selecting BCS measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }
    public void AssignTo_OR1_HST() throws Exception {
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        logTestStep("Clicking on Clinical link ");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        sleep(2000);
        Thread.sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"),"My profile");
        Thread.sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        Thread.sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        Thread.sleep(1000);
        String User = FirstName + " " + LastName;
        Thread.sleep(2000);
        ClickElement(ClinicalRepo.OR1,"OR1");
        waitForPageLoadToComplete();
        ClickElement(ProjectsRepo.Filter,"Filter");
        //sleep(2000);
        logTestStep("Clicking on Assigned To link");
        ClickElement($x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]"),"AssignedTo");
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.HST).click();
        logTestStep("Selecting HST measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }
    public void AssignTo_OR2_HST() throws Exception {
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        logTestStep("Clicking on Clinical link ");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        sleep(2000);
        Thread.sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"),"My profile");
        Thread.sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        Thread.sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        Thread.sleep(1000);
        String User = FirstName + " " + LastName;
        Thread.sleep(2000);
        ClickElement(ClinicalRepo.OR2,"OR2");
        waitForPageLoadToComplete();
        ClickElement(ProjectsRepo.Filter,"Filter");
        //sleep(2000);
        logTestStep("Clicking on Assigned To link");
        ClickElement($x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]"),"AssignedTo");
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.HST).click();
        logTestStep("Selecting HST measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }
    public void bulkPendChase() throws InterruptedException {
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $(ClinicalRepo.Status).click();
        sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[contains(text(),'Select All')]").click();
        sleep(2000);
        $x("//span[@class='ui-chkbox-icon ui-clickable pi pi-check']").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
    }
}
