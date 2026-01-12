package org.example.library.models.responseModels.parties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Party {
    @JsonProperty("$type")
    private String type;
    private String partyType;
    private Object gln;
    private long id;
    private String name;
    private long ownerID;
    private Object reference;
    private Object warehouseGLN;
}
