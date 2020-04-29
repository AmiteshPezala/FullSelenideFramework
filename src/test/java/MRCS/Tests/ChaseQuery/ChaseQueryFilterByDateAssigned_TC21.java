package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ChaseQueryFilterByDateAssigned_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Date Assigned", groups = {"Chase Query"})
    public void FilterByDateAssigned() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Click On ChaseQuery Link");
        objProject.ProjectsLink();
        objProject.GetDataFromChaseQuery();
        logTestStep("Clicking on Chase Query to Get Data");
        sleep(2000);
        $(".fa.fa-step-backward").click();
        Selenide.sleep(2000);
        String DateAssigned=$x("//tr[1]//td[21]").getText();
        Log.info(DateAssigned);
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Date Assigned link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Date Assigned')]").click();
        sleep(2000);
        $x("//input[@id='DateAssigned']").sendKeys(DateAssigned);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection DateAssignedCol= $$x("//td[@class='hdvi-gridcol hdvi-gridcol-dateAssigned ng-star-inserted']");
        int DateAssignedCount=DateAssignedCol.size();
        Log.info("No of cols are : " + DateAssignedCount);
        logTestStep("Enter into comparison");
        for(int i=0;i<DateAssignedCount;i++){
            String ActualDateAssigned=$x("//tr[\" + (i + 1) + \"]//td[21]").getText();
            Log.info(ActualDateAssigned);
            assertText(ActualDateAssigned,DateAssigned);
        }
        logTestStep("Verified that User should be able to query by Date Assigned");
        objLoginOut.logout();
    }

}
