package MRCS.Tests.RetrievalEMR;

import MRCS.Modules.LoginOut;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class RetrievalEMRGridSchedule_TC2 extends TestBase {
    RetrievalEMRDetailsCreateAppointment_TC12 objRetrievalEMR=new RetrievalEMRDetailsCreateAppointment_TC12();
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify EMR grid schedule.", groups = {"Retrieval EMR"})
    public void RetrievalEMRGridSchedule() throws Exception {
        objRetrievalEMR.RetrievalEMRCreateAppointment();
        objLoginOut.logout();
    }
}
