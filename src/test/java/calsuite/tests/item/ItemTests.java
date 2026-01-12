package calsuite.tests.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import calsuite.models.request.item.CreateItemRequestModel;
import calsuite.models.response.item.CreateItemResponseModel;

import org.testng.annotations.Test;
import calsuite.testdata.item.ItemsTestData;

public class ItemTests extends ItemBaseTest {


    @Test
    public void getAllItems() throws JsonProcessingException {
        String partyId = "100802";
        var respWrapper = itemsClient.getAllItems(partyId);
        respWrapper.getResponse().validateStatusCode(200);
    }

    @Test
    public void create() throws JsonProcessingException {
        String partyId = "100802";

        var payload = ItemsTestData.getCreateItemRequestTestData1();
        var responseModel = createItemResponseModel(partyId, payload);
        softAsserter.assertEquals(payload.getName(), responseModel.getEntity().getName());

        softAsserter.assertAll();

    }

    private CreateItemResponseModel createItemResponseModel(String partyId, CreateItemRequestModel payload) throws JsonProcessingException {

        var respWrapper = itemsClient.createItem1(payload, partyId);
        respWrapper.getResponse().validateStatusCode(201);
        var responseModel = respWrapper.getSingleResponseModel();

        return responseModel;
    }

    //TODO - UPDATE, DELETE

}

