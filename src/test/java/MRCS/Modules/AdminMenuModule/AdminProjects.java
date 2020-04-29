package MRCS.Modules.AdminMenuModule;

import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AdminProjects {
    public static void NavigateToProjects() throws Exception {
        sleep(5000);
        logTestStep("Clicking on Navigation bar");
        Common.ClickElement(LoginOutRepo.NavigationBar,"Navigation bar");
        Log.info("Clicked on Navigation bar");
        logTestStep("Clicking on Admin Link");
        Common.ClickElement(AdminRepo.Admin,"Admin");
        Log.info("Clicked on Admin");
        logTestStep("Clicking on Projects in Admin ");
        sleep(2000);
        Common.ClickElement(AdminRepo.ProjectsAdmin,"Project Admin");
        Log.info("Clicked on Projects in Admin");
        sleep(2000);
    }
}
