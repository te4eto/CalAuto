package calsuite.models.response.common.responses;

import lombok.Data;

@Data
public class Item {

    private String _type;
    private String type;
    private Description description;
    private Float expectedMaximumGrossWeight;
    private Float expectedMaximumNetWeight;
    private Float expectedMinimumGrossWeight;
    private Float expectedMinimumNetWeight;
    private GoodsWeightConfiguration goodsWeightConfiguration;
    private Float grossWeight;
    private Integer id;
    private Object liquidContent;
    private String name;
    private Float netWeight;
    private StockKeepingUnit stockKeepingUnit;
}
