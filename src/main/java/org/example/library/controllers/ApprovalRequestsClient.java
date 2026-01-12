package org.example.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.library.customObjects.CustomResponse;
import org.example.library.customObjects.ResponseWrapper;
import org.example.library.models.requestModels.approvalRequests.CreateApprovalRequestsRequestModel;
import org.example.library.models.requestModels.approvalRequests.UpdateApprovalRequest;
import org.example.library.models.responseModels.approvalRequests.CreateApprovalRequestsResponseModel;
import org.example.library.models.responseModels.approvalRequests.GetMultipleApprovalRequestsResponseModel;

public class ApprovalRequestsClient extends ApiClient{
    private final String basePath = "/api/authorisation/api/approvalRequests/";

    public ApprovalRequestsClient() {
        super();
    }

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

    public ResponseWrapper<CreateApprovalRequestsResponseModel> createApprovalRequest(String partyId, CreateApprovalRequestsRequestModel payload) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath, RequestType.POST, CreateApprovalRequestsResponseModel.class, payload);
    }

    public ResponseWrapper<CreateApprovalRequestsResponseModel> updateApprovalRequest(String approvalRequestId, String partyId, UpdateApprovalRequest payload) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath + approvalRequestId, RequestType.PUT, CreateApprovalRequestsResponseModel.class, payload);
    }

    public CustomResponse deleteApprovalRequest(String approvalRequestId, String partyId) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath + approvalRequestId, RequestType.DELETE);
    }
}
