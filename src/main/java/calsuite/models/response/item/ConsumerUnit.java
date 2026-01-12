package calsuite.models.response.item;

import lombok.Data;

@Data
public class ConsumerUnit {

    private String gtin;
    private Integer quantity;
    private Unit unit;
}
