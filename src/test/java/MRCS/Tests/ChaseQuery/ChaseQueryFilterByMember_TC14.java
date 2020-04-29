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

public class ChaseQueryFilterByMember_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Member", groups = {"Chase Query"})
    public void FilterByMember() throws Exception {
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
        String FirstName=$x("//tr[1]//td[9]").getText();
        String LastName=$x("//tr[1]//td[10]").getText();
        String DOB=$x("//tr[1]//td[11]").getText();
        String MemberKey=$x("//tr[1]//td[8]").getText();
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Member link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Member')]").click();
        sleep(2000);
        $x("//input[@id='MemberFirstName']").sendKeys(FirstName);
        $x("//input[@id='MemberLastName']").sendKeys(LastName);
        $x("//input[@id='MemberDob']").sendKeys(DOB);
        $x("//input[@id='MemberSourceAliasID']").sendKeys(MemberKey);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection FirstNameCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-memberFirstName ng-star-inserted']");
        ElementsCollection LastNameCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-memberLastName ng-star-inserted']");
        ElementsCollection DOBCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-memberDateOfBirth ng-star-inserted']");
        ElementsCollection MemberKeyCol = $$x("//td[@class='hdvi-gridcol hdvi-gridcol-memberSourceAliasID ng-star-inserted']");
        int FirstNameCount=FirstNameCol.size();
        int LastNameCount=LastNameCol.size();
        int DOBCount=DOBCol.size();
        int MemberCount=MemberKeyCol.size();
        Log.info("No of cols are : " + FirstNameCount);
        Log.info("No of cols are : " + LastNameCount);
        Log.info("No of cols are : " + DOBCount);
        Log.info("No of cols are : " + MemberCount);
        logTestStep("Enter into comparison");
        for(int i=0;i<FirstNameCount;i++){
            String ActualFirstName=$x("//tr[\" + (i + 1) + \"]//td[9]//span[2]").getText();
            Log.info(ActualFirstName);
            assertText(ActualFirstName,FirstName);
        }
        for (int i=0;i<LastNameCount;i++){
            String ActualLastName=$x("//tr[\" + (i + 1) + \"]//td[10]//span[2]").getText();
            assertText(ActualLastName,LastName);
        }
        for (int i=0;i<LastNameCount;i++){
            String ActualDOB=$x("//tr[\" + (i + 1) + \"]//td[11]//span[2]").getText();
            assertText(ActualDOB,DOB);
        }
        for (int i=0;i<LastNameCount;i++){
            String ActualMemberKey=$x("//tr[\" + (i + 1) + \"]//td[8]//span[2]").getText();
            assertText(ActualMemberKey,MemberKey);
        }
        logTestStep("Verified that User should be able to query by Member");
        objLoginOut.logout();
    }

}
