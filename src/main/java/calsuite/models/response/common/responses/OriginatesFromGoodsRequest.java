package calsuite.models.response.common.responses;

import lombok.Data;

import java.util.List;

@Data
public class OriginatesFromGoodsRequest {

    private String _type;
    private String type;
    private ConfirmedHandlingUnit confirmedHandlingUnit;
    private Integer confirmedQuantity;
    private ConfirmedSpace confirmedSpace;
    private ConfirmedStockMatch confirmedStockMatch;
    private String finishedAt;
    private Integer firstRouteIndex;
    private Integer id;
    private List<InitialHandlingUnit> initialHandlingUnits;
    private InstructedOutboundDeliveryPart instructedOutboundDeliveryPart;
    private Boolean isMultiOrderPicking;
    private Boolean isTwoStagePicking;
    private Item item;
    private String lastConfirmationDateTime;
    private Integer listIndex;
    private Object measuredGrossWeight;
    private Object measuredNetWeight;
    private Float measuredQuantity;
    private Float measuredWeight;
    private List<Object> measurements;
    private Object originatesFromGoodsRequest;
    private Integer quantity;
    private Boolean repackOversized;
    private RootHandlingUnitRequest rootHandlingUnitRequest;
    private List<Object> serviceActivityRequests;
    private Object startedAt;
    private String status;
    private Boolean useReversePicking;
    private String workAssignmentStatus;
}
