package calsuite.models.response.relationship;

import lombok.Data;

@Data
public class Value {

    private String comparableValue;
    private String displayValue;
    private Integer id;
    private String $discriminator;
    private String type;
}
