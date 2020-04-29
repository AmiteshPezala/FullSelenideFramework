package MRCS.Tests.MRR;
import MRCS.Tests.HedisBCS.BCS_BCSShowsPositiveCompliance_TC5;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

public class VerifyChaseCompliance_TC8 extends TestBase {
    BCS_BCSShowsPositiveCompliance_TC5 objBcs=new BCS_BCSShowsPositiveCompliance_TC5();

    @Test( description = "Review compliance for all numerators", groups = {"MRR"} )
    public void VerifyChaseCompliance() throws Exception {
       objBcs.BCS_BCSShowsPositiveCompliance();
    }
}
