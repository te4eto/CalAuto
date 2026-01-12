package calsuite.tests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import calsuite.auth.AuthManager;
import calsuite.models.general.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected SoftAssert softAsserter;

    @BeforeSuite(alwaysRun = true)
    public void setupTokens() throws Exception {
        AuthManager.initializeToken();
        setupLogging();
    }

    @BeforeClass
    public void setup() {
        initObjects();
    }

    public void setupLogging() {
        if (Configuration.getLoggingEnabled()) {
            RestAssured.filters(
                    new RequestLoggingFilter(),
                    new ResponseLoggingFilter()
            );
        }
    }

    public void initObjects(){
        softAsserter = new SoftAssert();
    }
}
