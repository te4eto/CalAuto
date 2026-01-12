package calsuite.models.response.item;

import calsuite.models.response.common.responses.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Entity {

    private String _type;
    private Object category;
    private Object color;
    public int dictionaryId;
    private Object icon;
    public int id;
    private int listIndex;
    private String name;
    private List<Attribute> attributes;
    public AttributesJson attributesJson;
    public int ownerId;
    private ArrayList<Translation> translations;
    private int translationsCount;
    private StockKeepingUnit stockKeepingUnit;
    private ConsumerUnit consumerUnit;
    private Boolean deleteRequested;
    private Dimensions dimensions;
    private Integer estimatedVolume;
    private GoodsWeightConfiguration goodsWeightConfiguration;
    private Integer grossWeight;
    private String gtin;
    private Boolean hasVariableAlcoholContent;
    private Boolean hasVariableGoodsWeight;
    private Boolean hasVariablePackagingWeight;
    private Boolean isActive;
    private LiquidContent liquidContent;
    private Integer maturationTime;
    private Integer minimumShelfLifeOnReceipt;
    private Integer netWeight;
    private PackagingWeightConfiguration packagingWeightConfiguration;
    private Boolean requiresRepacking;
    private Integer retailShelfLife;
    private Integer totalShelfLife;
    private Integer underdeliveryAuthorisationLimit;
    private Boolean useReversePicking;
    private String validFrom;
    private String validTo;
    private Versioning versioning;
    private WorkGroup workGroup;
    private Description description;

}