package calsuite.models.response.item;

import lombok.Data;

@Data
public class LiquidContent {

    private Integer alcoholPercentage;
    private Integer alcoholPercentageToleranceFactor;
    private Integer alcoholPercentageToleranceValue;
    private Integer vintage;
    private String vintageControl;
    private Integer volume;
}
