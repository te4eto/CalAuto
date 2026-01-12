package calsuite.tests.enterprise.organisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;
import calsuite.testdata.enterprise.organisation.OrganisationTestData;

import java.util.UUID;

import static calsuite.constants.Organisations.QA_AUTOMATION_DEPOT_112502;

public class OrganisationsTest extends OrganisationsBaseTest{

    @Test(description = "Create an organisation and verify it's name")
    public void addOrganisation() throws JsonProcessingException {

        var payload = OrganisationTestData.createOrganisationData();
        payload.setName("QA Automation " + UUID.randomUUID());
        var respWrapper = organisationsClient.addAnOrganisation(payload, QA_AUTOMATION_DEPOT_112502);
        var responseModel = respWrapper.getSingleResponseModel();
        softAsserter.assertEquals(payload.getName(), responseModel.getEntity().getName());

        var resp = organisationsClient.deleteAnOrganisation(QA_AUTOMATION_DEPOT_112502, String.valueOf(responseModel.getEntity().getId()));
        resp.validateStatusCode(200);

        softAsserter.assertAll();
    }
}
