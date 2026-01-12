package calsuite.models.response.hurequest;

import calsuite.models.response.common.responses.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HandlingUnitRequestPart {

    private Integer id;
    private String lastConfirmationDateTime;
    private Integer listIndex;
    private String status;
    private String $discriminator;
    private String _type;
    @JsonProperty("$type")
    private String $type;
    private String type;
    private boolean addsVolumeToHandlingUnit;
    private ConfirmedPackagingType confirmedPackagingType;
    private ConfirmedHandlingUnit confirmedHandlingUnit;
    private ConfirmedSpace confirmedSpace;
    private String finishedAt;
    private Integer firstRouteIndex;
    private List<InitialHandlingUnit> initialHandlingUnits;
    private InstructedOutboundDeliveryPart instructedOutboundDeliveryPart;
    private Boolean isMultiOrderPicking;
    private Boolean isTwoStagePicking;
    private Item item;
    private Object measuredGrossWeight;
    private Object measuredNetWeight;
    private Float measuredQuantity;
    private Float measuredWeight;
    private List<Object> measurements;
    private OriginatesFromGoodsRequest originatesFromGoodsRequest;
    private ConfirmedStockMatch confirmedStockMatch;
    private Description description;
    private PackagingType packagingType;
    private boolean pickFromSource;
    private Integer quantity;
    private Integer confirmedQuantity;
    private GoodsWeightConfiguration goodsWeightConfiguration;
    private Boolean repackOversized;
    private RootHandlingUnitRequest rootHandlingUnitRequest;
    private List<Object> serviceActivityRequests;
    private Object startedAt;
    private Boolean useReversePicking;
    private String workAssignmentStatus;
}
