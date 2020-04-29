package MRCS.Tests.ChaseQuery;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ChaseQueryFilterByAssignedTo_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Assigned To", groups = {"Chase Query"})
    public void FilterByAssignedTo() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        ClickElement(LoginOutRepo.UatAdmin,"Admin");
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"),"My profile");
        sleep(5000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(1000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        //objWait.implicitwait();
        logTestStep("Click On ChaseQuery Link");
        objProject.ProjectsLink();
        objProject.GetDataFromChaseQuery();
        logTestStep("Clicking on Chase Query to Get Data");
        sleep(2000);
        $(".fa.fa-step-backward").click();
        Selenide.sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Assigned To link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        sleep(2000);
        WebElement AssignedUser=$x("//input[@id='AssignedToUserId']");
        AssignedUser.sendKeys(User);
        sleep(1000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Page Size:'])[1]/following::span[2]").click();
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection AssignedToCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-assignedTo ng-star-inserted']");
        int AssignedToCount=AssignedToCol.size();
        Log.info("No of cols are : " + AssignedToCount);
        logTestStep("Enter into comparison");
        for(int i=0;i<AssignedToCount;i++){
            String ActualAssignedTo=$x("//tr[\" + (i + 1) + \"]//td[15]").getText();
            Log.info(ActualAssignedTo);
            assertText(ActualAssignedTo,User);
        }
        logTestStep("Verified that User should be able to query by Assigned To");
        objLoginOut.logout();
    }
}
