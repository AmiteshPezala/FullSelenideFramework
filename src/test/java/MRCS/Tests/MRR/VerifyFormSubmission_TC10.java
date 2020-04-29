package MRCS.Tests.MRR;

import MRCS.Tests.HedisBCS.BCS_ChaseCanSubmit_TC11;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class VerifyFormSubmission_TC10 extends TestBase {
    BCS_ChaseCanSubmit_TC11 objBcs=new BCS_ChaseCanSubmit_TC11();
    @Test( description = "System allow submission without errors", groups = {"MRR"} )
    public void VerifyChaseCompliance() throws Exception {
    objBcs.BCS_ChaseCanSubmit();
    }
}
