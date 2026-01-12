package calsuite.tests.hurequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HandlingUnitRequestTests extends HandlingUnitRequestBaseTest {

//    @Test
//    public void getAllHandlingUnitRequests() throws JsonProcessingException {
//        String partyId = "100802";
//        var respWrapper = handlingUnitRequestClient.getAllHandlingUnitRequests(partyId);
//        respWrapper.getResponse().validateStatusCode(200);
//    }

    @Test
    public void getHandlingUnitRequestById() throws JsonProcessingException {
        String partyId = "100802";
        Integer id = 927402;
        var respWrapper = handlingUnitRequestClient.getAllHandlingUnitRequestsById(String.valueOf(id), partyId);
        respWrapper.getResponse().validateStatusCode(200);

        assertEquals(respWrapper.getSingleResponseModel().getEntity().getId(), id);
    }
}