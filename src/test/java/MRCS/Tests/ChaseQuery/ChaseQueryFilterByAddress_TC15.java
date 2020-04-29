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
import static com.codeborne.selenide.Selenide.$x;

public class ChaseQueryFilterByAddress_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Address", groups = {"Chase Query"})
    public void FilterByAddress() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Click On ChaseQuery Link");
        objProject.ProjectsLink();
        objProject.GetDataFromChaseQuery();
        logTestStep("Clicking on Chase Query to Get Data");
        sleep(10000);
        $(".fa.fa-step-backward").click();
        sleep(5000);
        String AID=$x("//tr[1]//td[12]").getText();
        String AIDGroup=$x("//tr[1]//td[13]").getText();
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Address link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Address')]").click();
        sleep(2000);
        $x("//input[@id='AddressId']").sendKeys(AID);
        $x("//input[@id='AddressGroupId']").sendKeys(AIDGroup);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection AIDCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-masterDocumentSourceId ng-star-inserted']");
        ElementsCollection AIDGroupCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-addressGrouping ng-star-inserted']");
        int AIDCount=AIDCol.size();
        int AIDGroupCount=AIDGroupCol.size();
        Log.info("No of cols are : " + AIDCount);
        Log.info("No of cols are : " + AIDGroupCount);
        logTestStep("Enter into comparison");
        for(int i=0;i<AIDCount;i++){
            String ActualAID=$x("//tr[\" + (i + 1) + \"]//td[12]").getText();
            Log.info(ActualAID);
            assertText(ActualAID,AID);
        }
        for (int i=0;i<AIDGroupCount;i++){
            String ActualAIDGroup=$x("//tr[\" + (i + 1) + \"]//td[13]//span[2]").getText();
            assertText(ActualAIDGroup,AIDGroup);
        }
        logTestStep("Verified that User should be able to query by Address");
        objLoginOut.logout();
    }
}
