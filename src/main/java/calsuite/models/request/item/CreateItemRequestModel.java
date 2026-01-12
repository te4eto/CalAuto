package calsuite.models.request.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemRequestModel {
    public String type;
    public List<Attribute> attributes;
    public ConsumerUnit consumerUnit;
    public Description description;
    public Dimensions dimensions;
    public GoodsWeightConfiguration goodsWeightConfiguration;
    public Integer grossWeight;
    public String gtin;
    public Boolean hasVariableAlcoholContent;
    public Boolean hasVariableGoodsWeight;
    public Boolean hasVariablePackagingWeight;
    public Boolean isActive;
    public LiquidContent liquidContent;
    public Integer maturationTime;
    public Integer minimumShelfLifeOnReceipt;
    public String name;
    public Integer netWeight;
    public PackagingWeightConfiguration packagingWeightConfiguration;
    public Boolean requiresRepacking;
    public Integer retailShelfLife;
    public StockKeepingUnit stockKeepingUnit;
    public Integer totalShelfLife;
    public Integer underdeliveryAuthorisationLimit;
    public Boolean useReversePicking;
    public WorkGroup workGroup;

}
