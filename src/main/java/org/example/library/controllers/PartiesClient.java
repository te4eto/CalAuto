package org.example.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.library.customObjects.ResponseWrapper;
import org.example.library.models.responseModels.parties.GetPartiesResponseModel;

public class PartiesClient extends  ApiClient{
    private final String partiesEndpoint = "/api/enterprise/api/parties";

    public PartiesClient() {
        super();
    }

    public ResponseWrapper<GetPartiesResponseModel> getParties(int partyId) throws JsonProcessingException {
        setHeader("accept", "text/plain");
        setHeader("Party-Id", partyId);
        setQueryParam("page", 1);
        setQueryParam("pageSize", 25);

        return sendRequest(partiesEndpoint, RequestType.GET, GetPartiesResponseModel.class);
    }
}
