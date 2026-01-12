package calsuite.tests.migratedTests.baseTestSuite;

import calsuite.models.request.descriptions.CleanUpObject;
import calsuite.services.APIClientManager;
import calsuite.services.item.ItemsClient;
import calsuite.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import calsuite.testdata.item.ItemsTestData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CreateBaseItemsTest extends BaseTest {

    private ItemsClient client;
    private List<CleanUpObject> cleanUpObjects;

    @BeforeClass
    public void setupClient() {
        client = APIClientManager.getClient(ItemsClient.class);
    }

    @BeforeTest
    public void intiObjects(){
        cleanUpObjects = new ArrayList<>();
    }

    @Test(enabled = false)
    public void createBaseItemDescription() throws JsonProcessingException {
        var descriptionBody = ItemsTestData.getItemDescription();

        String partyId = "3501";
        String dataAuthPartyIds = "3501";

        var resp = client.createItemDescription(descriptionBody, partyId, dataAuthPartyIds);

        resp.getResponse().validateStatusCode(201);
        assertEquals(resp.getSingleResponseModel().getStatus(), "Created");

        var entity = resp.getSingleResponseModel().getEntity();

        var cleanUpObject = CleanUpObject.builder()
                .id(String.valueOf(entity.id))
                .partyId(String.valueOf(entity.ownerId))
                .dictionaryId(String.valueOf(entity.dictionaryId)).build();

        cleanUpObjects.add(cleanUpObject);
    }

    @AfterTest
    public void cleanup() throws JsonProcessingException {
        cleanUpItemDescription();
    }

    private void cleanUpItemDescription() throws JsonProcessingException {
        for(CleanUpObject cleanUpObject : cleanUpObjects) {
            var resp = client.deleteItemDescription(cleanUpObject.partyId, cleanUpObject.id, cleanUpObject.dictionaryId);
            resp.validateStatusCode(200);
        }
    }

//    @Test
//    public void createBaseItem() throws JsonProcessingException {
//        // Step 1 - Create description phrase
//        var descriptionBody = """
//        {
//          "name": "Test Item Description",
//          "translations": [{ "translation": "Test Description", "language": "en" }]
//        }
//        """;
//        ResponseWrapper<CreatePhraseResponseModel> descResp = client.createItemDescription(descriptionBody);
//        descResp.getResponse().validateStatusCode(201);
//        long descriptionId = descResp.getSingleResponseModel().getEntity().getId();
//        long descriptionDictionaryId = descResp.getSingleResponseModel().getEntity().getDictionaryId();
//
//        // Step 2 - Create SKU phrase
//        var skuBody = """
//        {
//          "name": "SKU Test",
//          "translations": [{ "languageId": 1, "value": "SKU Test" }]
//        }
//        """;
//        ResponseWrapper<CreatePhraseResponseModel> skuResp = client.createSkuPhrase(skuBody, 100000126L);
//        skuResp.getResponse().validateStatusCode(201);
//        long skuPhraseId = skuResp.getSingleResponseModel().getEntity().getId();
//
//        // Step 3 - Create item
//        var itemBody = """
//        {
//          "description": {
//            "dictionaryId": %d,
//            "phraseId": %d
//          },
//          "name": "Test Item",
//          "netWeight": 12.0,
//          "grossWeight": 15.0,
//          "gtin": "1234567890123",
//          "_type": "AddItemDTO",
//          "stockKeepingUnit": {
//            "dictionaryId": 100000126,
//            "phraseId": %d
//          }
//        }
//        """.formatted(descriptionDictionaryId, descriptionId, skuPhraseId);
//
//        ResponseWrapper<CreateItemResponseModel> itemResp = client.createItem(itemBody);
//        itemResp.getResponse().validateStatusCode(201);
//
//        var model = itemResp.getSingleResponseModel();
//        assertNotNull(model.getEntity().getId());
//        assertEquals(model.getStatus(), "Created");
//    }
}