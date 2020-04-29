package MRCS.Tests.MRQA;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class MRQADetailsDocumentPageHistory_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    MRQADetailDocumentPageDelete_TC14 objMRQA=new MRQADetailDocumentPageDelete_TC14();

    @Test(description = "MRQA detail - Document Page History",groups = {"MRQA"})
    public void MRQADetailsDocumentPageHistory() throws Exception {
        objMRQA.VerifyMRQAGridLoads();
    }
}
