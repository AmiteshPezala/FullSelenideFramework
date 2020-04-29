package MRCS.Tests.ProjectFiles;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.ProjectFiles;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProjectFilesGridViewFile_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProjects = new Projects();

    @Test( description = "File can get saved locally and user can view the file  ", groups = {"Project Files"} )
    public void VerifyFileGetViewed() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProjectFiles.NavigateToProjectFile();
        ProjectFiles.UploadAndVerifyFile();
        logTestStep("Clicking on View File");
        sleep(3000);
        $x("(//span[contains(@class,'fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted')])[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'View File')]").click();
        sleep(5000);
        // download file & verify
        Common.DownloadPdfDocument();
        logTestStep("Clicking to delete upload file");
        objProjects.DeleteFile();
        Log.info("Uploaded file deleted successfully");
        sleep(2000);
        objLoginOut.logout();
    }
}
