package MRCS.Tests.ProjectFiles;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.AdminMenuModule.AdminProjects;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectFilesHome_TC1 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Project file home page with folder for each available project", groups = {"Project Files"})
    public void VerifyListOfProjects ()throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        AdminProjects.NavigateToProjects();
        sleep(5000);
        String col=$x("(//span[contains(@class,'font-size-2 bold ng-star-inserted')])[1]").getText();// Will get total count of ProjectsLink from Admin/ProjectsLink page
        logTestStep("Total number of Project in Admin/Projects:"+" "+col);
        Log.info("Total number of Project in Admin/Projects:"+" "+col);
        sleep(2000);
        $(ProjectsRepo.ProjectsLink).click();
        logTestStep("Clicking on Project Files");
        sleep(2000);
        $x("//span[contains(.,'Project Files')]").waitUntil(Condition.visible,DEFAULT_WAIT).click();
        Log.info("Clicked on Project Files");
        sleep(10000);
        int count = $$(".fa.fa-folder").size();// Will get total projects count
        String projectCount = Integer.toString(count); // Converted Integer into String
        logTestStep("Total number of Projects in Project Files:"+" "+ projectCount);
        assertText(projectCount,col);
        objLoginOut.logout();
    }
}
