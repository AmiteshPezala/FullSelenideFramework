package MRCS.Utils;

import java.util.ArrayList;
import java.util.List;

public class TestConfig {
    private String moduleName, parallel, parallelCount;
    private List<String> testsList = new ArrayList<String>();


    public TestConfig() {
        super();
    }

    public TestConfig(String moduleName, String parallel, String parallelCount, List<String> testsList) {
        super();
        this.moduleName = moduleName;
        this.parallel = parallel;
        this.parallelCount = parallelCount;
        this.testsList = testsList;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    public String getParallelCount() {
        return parallelCount;
    }

    public void setParallelCount(String parallelCount) {
        this.parallelCount = parallelCount;
    }

    public List<String> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<String> testsList) {
        this.testsList = testsList;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "moduleName='" + moduleName + '\'' +
                ", parallel='" + parallel + '\'' +
                ", parallelCount='" + parallelCount + '\'' +
                ", testsList# " + testsList.size() + " -Detail " + testsList +
                '}';
    }
}