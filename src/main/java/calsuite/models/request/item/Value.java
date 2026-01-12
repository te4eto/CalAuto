package calsuite.models.request.item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Value {
    public String $discriminator;
    public String type;
}
