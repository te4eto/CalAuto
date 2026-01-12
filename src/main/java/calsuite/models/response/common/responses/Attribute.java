package calsuite.models.response.common.responses;

import lombok.Data;

@Data
public class Attribute {

    private AttributeType attributeType;
    private Integer id;
    private Value value;
}
