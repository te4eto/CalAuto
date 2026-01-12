package calsuite.services.authorisation.approvalrequests;

import com.fasterxml.jackson.core.JsonProcessingException;
import calsuite.api.response.CustomResponse;
import calsuite.api.response.ResponseWrapper;
import calsuite.models.request.authorisation.approvalrequests.CreateApprovalRequestsRequestModel;
import calsuite.models.request.authorisation.approvalrequests.UpdateApprovalRequest;
import calsuite.models.response.authorisation.approvalrequests.CreateApprovalRequestsResponseModel;
import calsuite.models.response.authorisation.approvalrequests.GetMultipleApprovalRequestsResponseModel;
import calsuite.services.ApiClient;
import calsuite.services.RequestType;

public class ApprovalRequestsClient extends ApiClient {
    private final String basePath = "/api/authorisation/api/approvalRequests/";

    public ApprovalRequestsClient() {
        super();
    }

    /** POST REQUESTS */
    public ResponseWrapper<CreateApprovalRequestsResponseModel> createApprovalRequest(String partyId, CreateApprovalRequestsRequestModel payload) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath, RequestType.POST, CreateApprovalRequestsResponseModel.class, payload);
    }

    /** GET REQUESTS */
    public ResponseWrapper<CreateApprovalRequestsResponseModel> getApprovalRequestById(String approvalRequestId, String partyId) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath + approvalRequestId, RequestType.GET, CreateApprovalRequestsResponseModel.class);
    }

    public ResponseWrapper<GetMultipleApprovalRequestsResponseModel> getAllApprovalRequests(String partyId) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath, RequestType.GET, GetMultipleApprovalRequestsResponseModel.class);
    }

    public CustomResponse getAllApprovalRequestRaw(String partyId) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath, RequestType.GET);
    }

    /** PUT REQUESTS */
    public ResponseWrapper<CreateApprovalRequestsResponseModel> updateApprovalRequest(String approvalRequestId, String partyId, UpdateApprovalRequest payload) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath + approvalRequestId, RequestType.PUT, CreateApprovalRequestsResponseModel.class, payload);
    }

    /** DELETE REQUESTS */
    public CustomResponse deleteApprovalRequest(String approvalRequestId, String partyId) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath + approvalRequestId, RequestType.DELETE);
    }
}
