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

public class ChaseQueryFilterByClient_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Client", groups = {"Chase Query"})
    public void FilterByClient() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Click On ChaseQuery Link");
        objProject.ProjectsLink();
        objProject.GetDataFromChaseQuery();
        logTestStep("Clicking on Chase Query to Get Data");
        sleep(5000);
        $(".fa.fa-step-backward").click();
        sleep(2000);
        String ClientName=$x("//tr[1]//td[5]").getText();
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Client Link");
        $(ProjectsRepo.Client).click();
        sleep(2000);
        $x("//input[@id='ClientId']").sendKeys(ClientName);
        sleep(1000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Page Size:'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection col = $$(ProjectsRepo.CheckboxOfProject);
        logTestStep("Enter into comparison");
        int record = col.size(); // Will get total number of records
        Log.info("No of cols are : " + record);
        for (int i = 0; i < record - 1; i++) {
            String ActualClientName = $x("//tr[\" + (i + 1) + \"]//td[5]").getText(); //checking that project name which is selected is matching the displayed project name
            assertText(ClientName, ActualClientName);
        }
        logTestStep("Verified that User should be able to query by Client");
        objLoginOut.logout();
    }

}
