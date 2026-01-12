package calsuite.tests.hurequest;

import calsuite.tests.BaseTest;
import calsuite.services.APIClientManager;
import calsuite.services.hurequest.HandlingUnitRequestClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class HandlingUnitRequestBaseTest extends BaseTest {

    protected HandlingUnitRequestClient handlingUnitRequestClient;

    protected List<Integer> testObjectIds;

    @BeforeClass
    public void setupClient() {
        handlingUnitRequestClient = APIClientManager.getClient(HandlingUnitRequestClient.class);
    }
    @BeforeTest
    public void intiObjects() {
        testObjectIds = new ArrayList<>();
    }
}
