package calsuiteTests.newTests.approvalRequests;

import calsuiteTests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.library.controllers.APIClientManager;
import org.example.library.controllers.ApprovalRequestsClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class ApprovalRequestsBaseTest extends BaseTest {
    protected ApprovalRequestsClient approvalRequestsClient;
    protected List<Integer> testObjectsIds;

    @BeforeClass
    public void setupClient() {
        approvalRequestsClient = APIClientManager.getClient(ApprovalRequestsClient.class);
    }

    @BeforeTest
    public void intiObjects(){
        testObjectsIds = new ArrayList<>();
    }

    //in case the delete test doesn't execute for some reason
    @AfterClass
    public void cleanUp() throws JsonProcessingException {
        for(var id : testObjectsIds){
            var resp = approvalRequestsClient.deleteApprovalRequest(String.valueOf(id), "105202");
            resp.validateStatusCode(200);
        }

        testObjectsIds.clear();
    }
}
