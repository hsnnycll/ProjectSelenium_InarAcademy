package studies;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Study44_Listeners implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED");
    }
}
