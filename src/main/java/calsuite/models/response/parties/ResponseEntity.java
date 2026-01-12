package calsuite.models.response.parties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseEntity {
    @JsonProperty("$type")
    private String type;
    @JsonProperty("_type")
    private EntityType entityType;
    private List<Object> attributes;
    private Object delegateOf;
    private Object gln;
    private long id;
    private Boolean isBranch;
    private Boolean isCompany;
    private Boolean isDelegate;
    private Boolean isDepot;
    private Boolean isPrincipal;
    private Object logo;
    private String name;
    private long ownerId;
    private Object parentBranch;
    private Object parentCompany;
    private Object parentDepot;
    private Object personNumber;
    private List<PostalAddress> postalAddresses;
    private Object reference;
    private Object sapNumber;
    private Object warehouseGLN;
}
