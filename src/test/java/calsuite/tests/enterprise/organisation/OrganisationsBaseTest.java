package calsuite.tests.enterprise.organisation;

import calsuite.tests.BaseTest;
import calsuite.services.APIClientManager;
import calsuite.services.enterprise.organisation.OrganisationsClient;
import org.testng.annotations.BeforeClass;

public class OrganisationsBaseTest extends BaseTest {

    protected OrganisationsClient organisationsClient;

    @BeforeClass
    public void setupClient() {
        organisationsClient = APIClientManager.getClient(OrganisationsClient.class);
    }
}
