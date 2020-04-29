package MRCS.Utils;

/**
 * <h1>Custom Exception </>
 * <p>Purpose: Common tests step failed exception whenever any step is failed in test</p>
 */
public class TestStepFailException extends Exception {
    public TestStepFailException() {
    }

    public TestStepFailException(String message) {
        super("Test step failed > " + message);
    }

    public TestStepFailException(Throwable cause) {
        super(cause);
    }

    public TestStepFailException(String message, Throwable cause) {
        super("Test step failed > " + message, cause);
    }

}//End custom Exception
