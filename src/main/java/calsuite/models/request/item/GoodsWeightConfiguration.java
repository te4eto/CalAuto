package calsuite.models.request.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsWeightConfiguration {
    public Integer unitsPerScan;
    public Integer weightToleranceFactor;
    public String weightType;
}
