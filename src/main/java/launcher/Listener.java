package launcher;

import org.testng.*;

import java.util.List;

/**
 * Created by taras on 9/28/16.
 */
public class Listener implements IHookable, IMethodInterceptor, ISuiteListener, ITestListener {

    private Context context;

    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {

    }

    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        return null;
    }

    public void onStart(ISuite iSuite) {

    }

    public void onFinish(ISuite iSuite) {

    }

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
