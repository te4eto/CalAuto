package calsuite.models.request.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {
    public Integer attributeTypeId;
    public String attributeTypeName;
    public Value value;

}
