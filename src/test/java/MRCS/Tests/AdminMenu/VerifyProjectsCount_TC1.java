package MRCS.Tests.AdminMenu;
import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class VerifyProjectsCount_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Gird is populated and matches the count", groups = {"Admin Menu"})
    public void VerifyListOfProjects ()throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        //sleep(5000);
        logTestStep("Clicking on Navigation bar");
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        Log.info("Clicked on Navigation bar");
        logTestStep("Clicking on Admin Link");
        ClickElement(AdminRepo.Admin,"Admin");
        Log.info("Clicked on Admin");
        logTestStep("Clicking on Projects");
        ClickElement(AdminRepo.ProjectsAdmin,"Project Admin");
        sleep(5000);
        String ProjectCount=$x("(//span[contains(@class,'font-size-2 bold ng-star-inserted')])[1]").getText();
        logInfoStepColored(COLOR.BLUE,"Expected Projects Count: " +ProjectCount);
        int AllProjectCount=Integer.parseInt(ProjectCount);
        int TotalProjects = 0;
        int pgCount=1;
        while(!$("a.ui-paginator-next").getAttribute("class").contains("disable")){
            int counts = $$x("//table/tbody/tr").size();
            System.out.println("Page number " +pgCount + " contains rows " +counts);
            pgCount++;
            TotalProjects=TotalProjects+counts;
            $("a.ui-paginator-next").click();
            sleep(4000);
        }
        TotalProjects +=$$x("//table/tbody/tr").size();
        System.out.println("---------------------------");
        System.out.println("Total Projects: " +TotalProjects);
        logInfoStepColored(COLOR.BLUE,"Total Projects: " +TotalProjects);
        if(AllProjectCount==TotalProjects){
            logTestStepPass("Number of Projects matched");
        }else {
            logTestStepFail("Number of Projects not matched");
        }
        objLoginOut.logout();
    }
    }

