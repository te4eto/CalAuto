package calsuite.services.enterprise.relationship;

import com.fasterxml.jackson.core.JsonProcessingException;
import calsuite.api.response.ResponseWrapper;
import calsuite.models.response.relationship.GetRelationshipResponseModel;
import calsuite.services.ApiClient;
import calsuite.services.RequestType;

public class RelationshipClient extends ApiClient {

    private final String basePath = "/api/enterprise/api/parties/";

    public ResponseWrapper<Object> getRelationship(String headerPartyId, String partyId) throws JsonProcessingException {
        setHeader("Party-Id", headerPartyId);
        return sendRequest(basePath + partyId, RequestType.GET, Object.class);
    }

    public ResponseWrapper<GetRelationshipResponseModel>getRelationshipResponseBody(String headerPartyId, String partyId) throws JsonProcessingException {
        setHeader("Party-Id", headerPartyId);
        return sendRequest(basePath + partyId, RequestType.GET, GetRelationshipResponseModel.class);
    }
}
