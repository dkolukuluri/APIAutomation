package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class TestresultsListener implements ITestListener {

    // Map to store test name and result
    public static Map<String, String> testResults = new HashMap<>();

    // When a test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        testResults.put(result.getName(), "Pass");
    }

    // When a test fails
    @Override
    public void onTestFailure(ITestResult result) {
        testResults.put(result.getName(), "Fail");
    }

    // When a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        testResults.put(result.getName(), "Skipped");
    }

    // This method runs after all tests have completed
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished. Test results:");
        for (Map.Entry<String, String> entry : testResults.entrySet()) {
            System.out.println("Test Name: " + entry.getKey() + " - Result: " + entry.getValue());
        }
    }

    // Get the test results as a map
    public Map<String, String> getTestResults() {
        return testResults;
    }
}

