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

public class ChaseQueryFilterByLastCodedBy_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Last Coded By", groups = {"Chase Query"})
    public void FilterByLastCodedBy() throws Exception {
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
        String LastCodedBy=$x("//tr[1]//td[20]").getText();
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Last Coded By link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Last Coded By')]").click();
        sleep(2000);
        $x("//input[@id='LastCoderUserID']").sendKeys(LastCodedBy);
        sleep(1000);
        //$x("(.//*[normalize-space(text()) and normalize-space(.)='Page Size:'])[1]/following::span[2]").click();
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection LastCodedByCol= $$x("//td[@class='hdvi-gridcol hdvi-gridcol-lastCoderUserName ng-star-inserted']");
        int LastCodedByCount=LastCodedByCol.size();
        Log.info("No of cols are : " + LastCodedByCount);
        logTestStep("Enter into comparison");
        for(int i=0;i<LastCodedByCount;i++){
            String ActualLastCodedBy=$x("//tr[\" + (i + 1) + \"]//td[20]").getText();
            Log.info(ActualLastCodedBy);
            assertText(ActualLastCodedBy,LastCodedBy);
        }
        logTestStep("Verified that User should be able to query by Last Coded By");
        objLoginOut.logout();
    }

}
