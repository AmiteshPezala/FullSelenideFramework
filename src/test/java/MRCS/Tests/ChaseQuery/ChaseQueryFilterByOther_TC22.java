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
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ChaseQueryFilterByOther_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Chase Query - Filter By Other", groups = {"Chase Query"})
    public void FilterByOther() throws Exception {
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
        String Product=$x("//tr[1]//td[7]").getText();
        Log.info(Product);
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        logTestStep("Clicking on Other link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Other')]").click();
        sleep(2000);
        $x("((//div//label[contains(text(),'Products')])[2]//following::input)").sendKeys(Product);
        $x("((//div//label[contains(text(),'Products')])[2]//following::input)").sendKeys(Keys.ARROW_DOWN);
        $x("((//div//label[contains(text(),'Products')])[2]//following::input)").sendKeys(Keys.ENTER);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        ElementsCollection OtherCol= $$x("//td[@class='hdvi-gridcol hdvi-gridcol-product ng-star-inserted']");
        int ProductCount=OtherCol.size();
        Log.info("No of cols are : " + ProductCount);
        logTestStep("Enter into comparison");
        for(int i=0;i<ProductCount;i++){
            String ActualProduct=$x("//tr[\" + (i + 1) + \"]//td[7]").getText();
            Log.info(ActualProduct);
            assertText(ActualProduct,Product);
        }
        logTestStep("Verified that User should be able to query by Other");
        objLoginOut.logout();
    }

}
