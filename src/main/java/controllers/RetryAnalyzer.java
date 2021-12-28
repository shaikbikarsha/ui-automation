package controllers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer extends ValueAssigner implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = retryCount;

    @Override
    public boolean retry(ITestResult result) {
        if(counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
