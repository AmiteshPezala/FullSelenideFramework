package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ChaseQueryFilterByChaseId_TC10 extends TestBase {
      LoginOut objLoginOut = new LoginOut();
      Projects objProject = new Projects();
      WaitTool objWait = new WaitTool();

      @Test(description = "Chase Query - Filter By ChaseId.", groups = {"Chase Query"})
      public void SearchByChaseID() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Click On ChaseQuery Link");
        objProject.ProjectsLink();
        objProject.GetDataFromChaseQuery();
        logTestStep("Clicking on Chase Query to Get Data");
        String ChaseQueryId=$x("//tr[1]//td[2]").getText();
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Chase Id link");
        $(ProjectsRepo.ChaseId).click();
        sleep(2000);
        $(ProjectsRepo.EnterChaseId).sendKeys(ChaseQueryId);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection col = $$(ProjectsRepo.CheckBox);
        Log.info("enter into comparison");
        int record = col.size(); // Will get total number of records
        Log.info("No of cols are : " + record);
        for (int i = 0; i < record - 1; i++) {
            String ChaseKey = $x("//tr[" + (i + 1) + "]//td[2]//a[1]").getText();
            Log.info(ChaseKey);
            assertText(ChaseKey,ChaseQueryId);
        }
        logTestStep("Verified that User should be able to query by Chase Id");
        objLoginOut.logout();
    }
}
