package MRCS.Modules.ProjectsModule;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import org.openqa.selenium.By;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProjectFiles {
    public static void NavigateToProjectFile() throws Exception {
        Projects objProjects = new Projects();
        logTestStep("Clicking on Project Tab");
        objProjects.ProjectsLink();
        sleep(3000);
        $(ProjectsRepo.Projectfiles).click();
        Log.info("Clicked on Project files link");
        $(ProjectsRepo.Folder).click();
        Log.info("Clicked on Folder");
        sleep(3000);
    }
    public static void UploadAndVerifyFile() throws Exception {
        logTestStep("Clicking on Choose to upload Project file");
        Common.UploadDocument();
        $(ProjectsRepo.ProjectFileUpload).click();
        waitForPageLoadToComplete();
        Log.info("Clicked on Upload button");
        logTestStep("Comparing whether Project file uploaded successfully");
        // will get toaster message
        String UploadSuccess = Common.getElementText(By.xpath("//div[contains(text(),'File(s) uploaded successfully.')]"),5);
        String ExpectedMsg = "File(s) uploaded successfully.";
        assertText(UploadSuccess, ExpectedMsg);
        // will get uploaded file name
        sleep(5000);
        String UploadedFileName = $x("//tr[1]//td[1]").getText();
        String ExpectedUploadedFileName = "Test.pdf"; // document name
        assertText(UploadedFileName, ExpectedUploadedFileName);
        logTestStep("Project file uploaded successfully");
    }
}
