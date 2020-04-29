package MRCS.Tests.ChaseQuery;

import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class ChaseQuery_UnassignedAssignedUser_TC5 extends TestBase {
    ChaseQuery_VerifyUnassignedButtonFunctionality_TC27 objTestCase=new ChaseQuery_VerifyUnassignedButtonFunctionality_TC27();

    @Test(description = "Verify that already assigned chase can be unassigned.", groups = {"Chase Query"})
    public void ChaseQuery_UnassignedAssignedUser_TC5() throws Exception {
        objTestCase.ChaseQuery_VerifyUnassignedButtonFunctionality_TC27();
    }
}
