package MRCS.Modules;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;

import static MRCS.Utils.Common.ClickElement;
import static java.lang.Thread.sleep;

public class ApprovalCenter {
    public void ApprovalChaseMoveLink() throws Exception {
        ClickElement(LoginOutRepo.NavigationBar,"Clicking on Navigation bar");
        Log.info("clicked on Navigation bar");
        ClickElement(ApprovalCenterRepo.ApprovalCenter,"Clicking on Approval Center link");
        TestBase.logTestStep("Clicked on Approval Center link.");
        sleep(2000);
    }
}
