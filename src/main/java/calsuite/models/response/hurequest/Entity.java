package calsuite.models.response.hurequest;

import calsuite.models.response.common.responses.Attribute;
import calsuite.models.response.common.responses.WorkGroup;
import lombok.Data;

import java.util.List;

@Data
public class Entity {

    private String _type;
    private Integer activeUser;
    private List<Attribute> attributes;
    private Boolean confirmCompleteHandlingUnit;
    private String creationDateTime;
    private HandlingUnit handlingUnit;
    private List<HandlingUnitRequestPart> handlingUnitRequestParts;
    private Integer id;
    private Boolean isReadyForProcessing;
    private Integer ownerId;
    private String plannedExecutionDateTime;
    private Integer plannedExecutionOrder;
    private List<Object> serviceActivityRequests;
    private String status;
    private Summary summary;
    private Integer systemChangeNumber;
    private WorkGroup workGroup;
}
