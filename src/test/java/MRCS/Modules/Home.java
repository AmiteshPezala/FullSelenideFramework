package MRCS.Modules;

import MRCS.Locators.HomeRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.WaitTool;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Home {

    WaitTool objWait = new WaitTool();

    public void Homelink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Clicking on Navigation");
        Log.info("Clicked on Navigation bar");
        ClickElement(HomeRepo.Home,"Clicking on Home Link");
        Common.waitForPageLoadToComplete();
        Log.info("clicked Home tab");
    }
    public void clickOnMySites() throws Exception {
        ClickElement(HomeRepo.MyStites,"Clicking on My sites link");
        Log.info("Clicked on MySites");
        Common.waitForPageLoadToComplete();
    }
    public void clickOnMyChases() throws Exception {
        ClickElement(HomeRepo.MyChases,"Clicking on My chases");
        Log.info("Clicked on MyChases");
        Common.waitForPageLoadToComplete();
    }
    public void ClickOnMyDocument() throws Exception {
        logTestStep("ClickOnMyDocument");
        ClickElement(HomeRepo.MyDocuments,"Clicking on My documents");
        Common.waitForPageLoadToComplete();
    }
}
