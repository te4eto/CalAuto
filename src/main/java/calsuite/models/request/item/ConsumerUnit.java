package calsuite.models.request.item;

import lombok.Data;

@Data
public class ConsumerUnit {
    public String gtin;
    public Integer quantity;
    public Unit unit;
}
