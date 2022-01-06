package listeners;

import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.CustomAttribute;
import utils.PostResultsToInfluxDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class InfluxDBListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.postTestMethodStatus(iTestResult, "PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.postTestMethodStatus(iTestResult, "FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        this.postTestMethodStatus(iTestResult, "SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
//        this.postTestClassStatus(iTestContext);
    }

    private void postTestMethodStatus(ITestResult iTestResult, String status) {
        CustomAttribute[] attributes = Optional.ofNullable(Reporter.getCurrentTestResult().getMethod().getAttributes())
                .orElse(new CustomAttribute[]{});
        List<String[]> productDetails = new ArrayList<>();
        Arrays.stream(attributes).forEach(attribute -> {
            productDetails.add(attribute.values());
        });

        Point point = Point.measurement("ui-automation").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("TestClassName", iTestResult.getTestClass().getName())
                .tag("TeamName", productDetails.get(0)[0])
                .tag("ProductName", productDetails.get(0)[1])
                .tag("GroupName", productDetails.get(0)[2])
                .tag("ExecutionStatus", status)
                .tag("Severity", productDetails.get(0)[3])
                .tag("TestMethodName", iTestResult.getName())
                .tag("description", iTestResult.getMethod().getDescription())
                .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
        PostResultsToInfluxDB.post(point);
    }

    private void postTestClassStatus(ITestContext iTestContext) {
        Point point = Point.measurement("ui-automation-classes").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
                .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
                .build();
        PostResultsToInfluxDB.post(point);
    }
}
