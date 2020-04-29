package MRCS.Modules.ClinicalModule;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class OR2 {
    public  static void ClinicalLink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        logTestStep("Clicked on Navigation bar");
        logTestStep("Clicking on Clinical link ");
        ClickElement(ClinicalRepo.Clinical,"Clinical link");
        sleep(2000);
    }
    public static void NavigateToOR2() throws Exception {
        OR1.ClinicalLink();
        ClickElement(ClinicalRepo.OR2,"OR2");
        sleep(2000);
    }
    public static void BulkAssignToUser() throws Exception {
        String User= Common.GetUserName();
        System.out.println(User);
        OR2.NavigateToOR2();
        waitForPageLoadToComplete();
        Selenide.sleep(2000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.BCS).click();
        logTestStep("Selecting HST measure");
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
