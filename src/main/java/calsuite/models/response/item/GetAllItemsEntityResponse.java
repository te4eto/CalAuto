package calsuite.models.response.item;

import calsuite.models.response.common.responses.*;
import lombok.Data;

import java.util.List;

@Data
public class GetAllItemsEntityResponse {

    private List<Attribute> attributes;
    private AttributesJson attributesJson;
    private Boolean deleteRequested;
    private Description description;
    private Dimensions dimensions;
    private GoodsWeightConfiguration goodsWeightConfiguration;
    private Integer grossWeight;
    private String gtin;
    private Boolean hasVariableAlcoholContent;
    private Boolean hasVariableGoodsWeight;
    private Integer id;
    private Boolean isActive;
    private LiquidContent liquidContent;
    private String name;
    private Integer netWeight;
    private Integer ownerId;
    private Boolean requiresRepacking;
    private StockKeepingUnitGetAllItems stockKeepingUnitGetAllItems;
    private Boolean useReversePicking;
    private String validFrom;
    private String validTo;
    private Versioning versioning;
    private WorkGroup workGroup;
    private String type;
}
