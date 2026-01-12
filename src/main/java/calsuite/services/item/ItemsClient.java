package calsuite.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import calsuite.api.response.CustomResponse;
import calsuite.api.response.ResponseWrapper;
import calsuite.models.request.item.CreateItemRequestModel;
import calsuite.models.response.item.CreateItemResponseModel;
import calsuite.models.response.item.CreatePhraseResponseModel;
import calsuite.models.response.item.GetAllItemsResponse;
import calsuite.services.ApiClient;
import calsuite.services.RequestType;

public class ItemsClient extends ApiClient {

    private final String basePath = "/api/item/api";

    public ItemsClient() {
        super();
    }

    /** POST REQUESTS */
    public ResponseWrapper<CreatePhraseResponseModel> createItemDescription(Object body, String partyId, String dataAuthPartyIds) throws JsonProcessingException {
        String endpoint = basePath + "/dictionaries/CALConsult.CALwms.Item.ItemDescriptions/phrases/createorupdate";
        setHeader("accept", "application/json");
        setHeader("Party-Id", partyId);
        setHeader("Data-Authorisation-Party-Ids", dataAuthPartyIds);

        return sendRequest(endpoint, RequestType.POST, CreatePhraseResponseModel.class, body);
    }

    public ResponseWrapper<CreatePhraseResponseModel> createSkuPhrase(Object body, long dictionaryId) throws JsonProcessingException {
        String endpoint = basePath + "/dictionaries/" + dictionaryId + "/phrases";
        setHeader("accept", "application/json");

        return sendRequest(endpoint, RequestType.POST, CreatePhraseResponseModel.class, body);
    }

    public ResponseWrapper<CreatePhraseResponseModel> createConsumerUnitPhrase(Object body, long dictionaryId) throws JsonProcessingException {
        String endpoint = basePath + "/dictionaries/" + dictionaryId + "/phrases";
        setHeader("accept", "application/json");

        return sendRequest(endpoint, RequestType.POST, CreatePhraseResponseModel.class, body);
    }

    public ResponseWrapper<CreateItemResponseModel> createItem(Object body, CreateItemRequestModel payload) throws JsonProcessingException {
        String endpoint = basePath + "/api/items";
        setHeader("accept", "application/json");

        return sendRequest(endpoint, RequestType.POST, CreateItemResponseModel.class, body);
    }

    public ResponseWrapper<CreateItemResponseModel> createItem1(CreateItemRequestModel payload, String headerPartyId) throws JsonProcessingException {
        String endpoint = basePath + "/items";
        setHeader("accept", "application/json");
        setHeader("Party-Id", headerPartyId);
        return sendRequest(endpoint, RequestType.POST, CreateItemResponseModel.class, payload);
    }

    /** GET REQUESTS */
    public ResponseWrapper<GetAllItemsResponse> getAllItems(String partyId) throws JsonProcessingException {
        String endpoint = basePath + "/items";
        setHeader("Party-Id", partyId);
        return sendRequest(endpoint, RequestType.GET, GetAllItemsResponse.class);
    }

    /** DELETE REQUESTS */
    public CustomResponse deleteItemDescription(String partyId, String id, String dictionaryId) throws JsonProcessingException {
        String endpoint = basePath + "/dictionaries/" + dictionaryId + "/phrases/" + id;
        setHeader("accept", "application/json");
        setHeader("Party-Id", partyId);

        return sendRequest(endpoint, RequestType.DELETE);
    }
}

