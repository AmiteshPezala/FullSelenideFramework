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
import static java.lang.Thread.sleep;

public class ProjectFilesGridUpload_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProjects = new Projects();

    @Test( description = "File get uploaded and listed in grid ", groups = {"Project Files"} )
    public void VerifyFileGetUploaded() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProjectFiles.NavigateToProjectFile();
        ProjectFiles.UploadAndVerifyFile();
        logTestStep("Clicking on delete to delete uploaded file");
        // Will delete uploaded file
        objProjects.DeleteFile();
        logTestStep("uploaded file deleted successfully");
        Log.info("Uploaded file deleted successfully");
    }
}
