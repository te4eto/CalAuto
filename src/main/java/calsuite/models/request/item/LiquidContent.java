package calsuite.models.request.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiquidContent {
    public Integer alcoholPercentage;
    public Integer alcoholPercentageToleranceFactor;
    public Integer alcoholPercentageToleranceValue;
    public Integer vintage;
    public String vintageControl;
    public Integer volume;
}
