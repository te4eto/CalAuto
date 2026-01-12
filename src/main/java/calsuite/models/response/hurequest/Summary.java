package calsuite.models.response.hurequest;

import lombok.Data;

@Data
public class Summary {

    public Integer completedPercentage;
    public Integer confirmedQuantity;
    public Integer estimatedPickingEffort;
    public Integer itemCount;
    public Integer linesCount;
    public OutboundDelivery outboundDelivery;
    public PackagingType packagingType;
    public Integer quantity;
}
