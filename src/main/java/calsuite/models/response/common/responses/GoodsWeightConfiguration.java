package calsuite.models.response.common.responses;

import lombok.Data;

@Data
public class GoodsWeightConfiguration {

    private Integer unitsPerScan;
    private Object weightToleranceFactor;
    private Object weightToleranceValue;
    private String weightType;
}
