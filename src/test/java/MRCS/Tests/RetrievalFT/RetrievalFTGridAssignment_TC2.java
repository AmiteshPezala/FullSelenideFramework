package MRCS.Tests.RetrievalFT;
import MRCS.Modules.LoginOut;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;


public class RetrievalFTGridAssignment_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    RetrievalFTCreateAppointment_TC12 objRetrieval=new RetrievalFTCreateAppointment_TC12();

    @Test(description = "Verify whether appointment is created or not.", groups = {"Retrieval FT"})
    public void RetrievalFTCreateAppointment() throws Exception {
        objRetrieval.RetrievalFTCreateAppointment();
    }
}
