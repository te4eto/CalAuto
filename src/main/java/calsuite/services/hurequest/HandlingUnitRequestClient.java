package calsuite.services.hurequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import calsuite.api.response.ResponseWrapper;
import calsuite.models.response.hurequest.HandlingUnitResponseModel;
import calsuite.services.ApiClient;
import calsuite.services.RequestType;

public class HandlingUnitRequestClient  extends ApiClient {

    private final String basePath = "/api/handlingunitrequest/api/handlingunitrequests/";

    public HandlingUnitRequestClient() {
        super();
    }

    /** GET REQUESTS */
    public ResponseWrapper<HandlingUnitResponseModel> getAllHandlingUnitRequests(String headerPartyId) throws JsonProcessingException {
        setHeader("Party-Id", headerPartyId);
        return sendRequest(basePath, RequestType.GET, HandlingUnitResponseModel.class);
    }

    public ResponseWrapper<HandlingUnitResponseModel> getAllHandlingUnitRequestsById(String handlingUnitRequestId, String headerPartyId) throws JsonProcessingException {
        setHeader("Party-Id", headerPartyId);
        return sendRequest(basePath + handlingUnitRequestId, RequestType.GET, HandlingUnitResponseModel.class);
    }
}
