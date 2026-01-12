package calsuite.models.response.relationship;

import calsuite.models.response.common.responses.Attribute;
import lombok.Data;

import java.util.List;

@Data
public class FromParty {

    private String type;
    private List<Attribute> attributes;
    private Integer id;
    private String name;
    private Integer ownerId;
}
