package calsuite.tests.item;

import calsuite.tests.BaseTest;

import calsuite.services.APIClientManager;
import calsuite.services.item.ItemsClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class ItemBaseTest extends BaseTest {

    protected ItemsClient itemsClient;
    protected List<Integer> testObjectsIds;

    @BeforeClass
    public void setupClient() {
        itemsClient = APIClientManager.getClient(ItemsClient.class);
    }

    @BeforeTest
    public void intiObjects() {
        testObjectsIds = new ArrayList<>();
    }

}
