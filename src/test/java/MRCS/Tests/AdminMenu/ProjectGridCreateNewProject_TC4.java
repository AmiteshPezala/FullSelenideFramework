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

public class ProjectGridCreateNewProject_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Project grid -Create new project", groups = {"Admin Menu"})
    public void CreateNewProject ()throws Exception {
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
        Log.info("Clicked on Projects in Admin");
        //sleep(3000);
        //String OldProjectName=$x("//tr[1]//td[1]").getText();
        sleep(1000);
        String NewProjectName=Common.GetTimeStamp()+"AutoQA";
        logTestStep("Creating New Project");
        ClickElement($x("//span[contains(text(),'CREATE NEW PROJECT')]"),"Create New project");
        sleep(2000);
        $x("//input[@id='projectName']").sendKeys(NewProjectName);
        sleep(1000);
        ClickElement($x("//label[contains(text(),'Select Group')]"),"Select group");
        ClickElement($x("(//li[@role='option'])[1]"),"option");
        sleep(2000);
        ClickElement($x("//label[contains(text(),'Select Product')]"),"Select Product");
        ClickElement($x("(//li[@role='option'])[1]"),"option");
        sleep(2000);
        ClickElement($x("//label[contains(text(),'Select Project Owner')]"),"Select Project Owner");
        ClickElement($x("(//li[@role='option'])[1]"),"Option");
        sleep(2000);
        ClickElement($x("//label[contains(text(),'Select Project Type')]"),"Select Project Tyep");
        ClickElement($x("(//li[@role='option'])[1]"),"Option");
        sleep(1000);
        $x("//input[@id='projectStartDate']").sendKeys("07/14/2019");
        sleep(1000);
        $x("//input[@id='projectEndDate']").sendKeys("07/10/2030");
        sleep(2000);
        ClickElement($x("//span[contains(text(),'SAVE AND CONFIGURE')]"),"Save and Configure");
        sleep(2000);
        ClickElement($x("//span[contains(text(),'SAVE')]"),"Save");
        sleep(2000);
        String ActualMsg=$x("//div[contains(text(),'Project config saved.')]").getText();
        if(ActualMsg.equals("Project config saved.")){
            logTestStepPass("New Project Created Successfully");
        }else {
            logTestStepFail("New Project not Created");
        }
        objLoginOut.logout();
    }
}
