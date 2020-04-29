package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Tests.ThirdParty.VerifyChaseMoveButtonForManagerUser_TC22;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;

public class RetrievalPSRVerifyButtonFroManagerUser_TC31 extends TestBase {
    VerifyChaseMoveButtonForManagerUser_TC22 objTestCase=new VerifyChaseMoveButtonForManagerUser_TC22();

    @Test(description = "Verify that 'Chase move ' button for manager user is 'Move chase' or not .", groups = {"Retrieval PSR"})
    public void RetrievalPSRVerifyButtonFroManagerUser_TC31() throws Exception {
       objTestCase.VerifyChaseMoveButtonForManagerUser_TC22();
    }
}
