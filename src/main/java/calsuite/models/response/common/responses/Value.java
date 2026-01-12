package calsuite.models.response.common.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Value {

    private String comparableValue;
    private String displayValue;
    private Integer id;
    private String $discriminator;
    private String type;
    private String _type;
    @JsonProperty("$type")
    private String $type;
    private String value;
}
