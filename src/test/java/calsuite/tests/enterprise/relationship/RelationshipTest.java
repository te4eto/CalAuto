package calsuite.tests.enterprise.relationship;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

public class RelationshipTest extends RelationshipBaseTests {


    @Test
    public void get() throws JsonProcessingException {
        String partyId = "100702";
        String headerPartyId = "902";

        var respWrapper = relationshipClient.getRelationship(headerPartyId, partyId);
        respWrapper.getResponse().validateStatusCode(200);
    }

}
