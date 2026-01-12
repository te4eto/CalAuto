package calsuite.models.response.enterprise.organisation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Entity {

    @JsonProperty("_type")
    private String _type;
    private String type;
    private List<Object> attributes;
    private Object delegateOf;
    private Object gln;
    private Integer id;
    private Boolean isBranch;
    private Boolean isCompany;
    private Boolean isDelegate;
    private Boolean isDepot;
    private Boolean isPrincipal;
    private Object logo;
    private String name;
    private Integer ownerId;
    private Object parentBranch;
    private Object parentCompany;
    private Object parentDepot;
    private Object personNumber;
    private List<Object> postalAddresses;
    private Object reference;
    private Object sapNumber;
    private Object warehouseGLN;
}
