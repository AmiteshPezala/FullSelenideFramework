package MRCS.Tests.OR1;

import MRCS.Tests.MRR.VerifyChaseMove_TC14;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class VerifyChaseMove_TC18 extends TestBase {
    VerifyChaseMove_TC14 objMRR=new VerifyChaseMove_TC14();

    @Test(description = "Chase move back", groups = {"OR1"})
    public void VerifyChaseMove() throws Exception {
        objMRR.VerifyChaseMove();
    }
}
