package calsuite.models.response.common.responses;

import lombok.Data;
import calsuite.models.response.hurequest.OutboundDelivery;

@Data
public class InstructedOutboundDeliveryPart {

    private Integer id;
    private OutboundDelivery outboundDelivery;
}
