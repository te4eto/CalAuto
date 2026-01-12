package calsuiteTests.newTests.approvalRequests;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.library.models.requestModels.approvalRequests.CreateApprovalRequestsRequestModel;
import org.example.library.models.requestModels.approvalRequests.UpdateApprovalRequest;
import org.example.library.models.responseModels.approvalRequests.CreateApprovalRequestsResponseModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.ApprovalRequestsTestData;

public class ApprovalRequestsTests extends ApprovalRequestsBaseTest {

    @Test
    public void create() throws JsonProcessingException {
        var payload = ApprovalRequestsTestData.getCreateApprovalRequestTestData();
        var responseModel = createApprovalRequest("105202", payload);

        softAsserter.assertEquals(payload.getEntityFullName(), responseModel.getEntity().getEntityFullName());
        softAsserter.assertEquals(payload.getRequestContent(), responseModel.getEntity().getRequestContent());
        softAsserter.assertEquals(payload.getType(), responseModel.getEntity().getType());

        softAsserter.assertAll();
    }

    @Test(dependsOnMethods = "create")
    public void get() throws JsonProcessingException {
        var expectedData = ApprovalRequestsTestData.getCreateApprovalRequestTestData();
        var respWrapper = approvalRequestsClient.getApprovalRequestById(String.valueOf(testObjectsIds.get(0)), "105202");
        respWrapper.getResponse().validateStatusCode(200);
        var responseModel = respWrapper.getSingleResponseModel();

        softAsserter.assertEquals(expectedData.getEntityFullName(), responseModel.getEntity().getEntityFullName());
        softAsserter.assertEquals(expectedData.getRequestContent(), responseModel.getEntity().getRequestContent());
        softAsserter.assertEquals(expectedData.getType(), responseModel.getEntity().getType());

        softAsserter.assertAll();
    }

    @Test(dependsOnMethods = "get", dataProvider = "updateData")
    public void update(UpdateApprovalRequest payload, int expectedStatusCode) throws JsonProcessingException {
        var createPayload = ApprovalRequestsTestData.getCreateApprovalRequestTestData2();
        var id = createApprovalRequest("105202", createPayload).getEntity().getId();

        var respWrapper = approvalRequestsClient.updateApprovalRequest(String.valueOf(id), "105202", payload);
        respWrapper.getResponse().validateStatusCode(expectedStatusCode);

        if(expectedStatusCode == 200){
            var status = respWrapper.getSingleResponseModel().getEntity().getStatus();
            Assert.assertEquals(status, payload.getStatus());
        }
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws JsonProcessingException {
        for(var id : testObjectsIds){
            var resp = approvalRequestsClient.deleteApprovalRequest(String.valueOf(id), "105202");
            resp.validateStatusCode(200);
        }

        testObjectsIds.clear();
    }

    @DataProvider(name = "updateData")
    public Object[][] updateData() {
        return new Object[][] {
                {ApprovalRequestsTestData.getUpdateApprovalRequestApprovedTestData(), 200},
                {ApprovalRequestsTestData.getUpdateApprovalRequestRejectedTestData(), 200},
                {ApprovalRequestsTestData.getUpdateApprovalRequestInvalidTestData(), 400}
        };
    }

    private CreateApprovalRequestsResponseModel createApprovalRequest(String partyId, CreateApprovalRequestsRequestModel payload) throws JsonProcessingException {
        var respWrapper = approvalRequestsClient.createApprovalRequest(partyId, payload);
        respWrapper.getResponse().validateStatusCode(201);
        var id = respWrapper.getSingleResponseModel().getEntity().getId();
        testObjectsIds.add(id);

        return respWrapper.getSingleResponseModel();
    }
}
