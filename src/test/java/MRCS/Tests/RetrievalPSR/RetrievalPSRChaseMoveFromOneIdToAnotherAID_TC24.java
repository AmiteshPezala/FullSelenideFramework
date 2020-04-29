package MRCS.Tests.RetrievalPSR;
import MRCS.Modules.LoginOut;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;


public class RetrievalPSRChaseMoveFromOneIdToAnotherAID_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalPSRChaseMove_TC19 objRetrievalPSR=new RetrievalPSRChaseMove_TC19();

    @Test(description = "Verify that chase can be move form one  AID to another", groups = {"Retrieval PSR"})
    public void RetrievalPSRChaseMoveFromOneIdToAnotherAID() throws Exception {
        objRetrievalPSR.RetrievalPSRChaseMove_TC19();
    }
}
