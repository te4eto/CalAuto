package calsuite.tests.enterprise.relationship;

import calsuite.tests.BaseTest;
import calsuite.services.APIClientManager;
import calsuite.services.enterprise.relationship.RelationshipClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class RelationshipBaseTests extends BaseTest {

    protected RelationshipClient relationshipClient;
    protected List<Integer> testObjectsIds;

    @BeforeClass
    public void setupClient(){
        relationshipClient = APIClientManager.getClient(RelationshipClient.class);
    }

    @BeforeTest
    public void intiObjects() {
        testObjectsIds = new ArrayList<>();
    }

}
