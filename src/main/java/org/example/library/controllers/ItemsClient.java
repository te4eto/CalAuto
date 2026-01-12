package org.example.library.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.example.library.customObjects.CustomResponse;
import org.example.library.customObjects.ResponseWrapper;

import org.example.library.models.responseModels.items.item.CreateItemResponseModel;

import org.example.library.models.responseModels.items.item.CreatePhraseResponseModel;

public class ItemsClient extends ApiClient {

    private final String basePath = "/api/item/api";

    public ItemsClient() {
        super();
    }

    public CustomResponse deleteItemDescription(String partyId, String id, String dictionaryId) throws JsonProcessingException {
        String endpoint = basePath + "/dictionaries/" + dictionaryId + "/phrases/" + id;
        setHeader("accept", "application/json");
        setHeader("Party-Id", partyId);

        return sendRequest(endpoint, RequestType.DELETE);
    }

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

    public ResponseWrapper<CreateItemResponseModel> createItem(Object body) throws JsonProcessingException {
        String endpoint = basePath + "/items";
        setHeader("accept", "application/json");

        return sendRequest(endpoint, RequestType.POST, CreateItemResponseModel.class, body);
    }
}

