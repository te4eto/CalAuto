package calsuite.models.response.hurequest;

import calsuite.models.response.common.responses.ValidationResult;
import lombok.Data;

import java.util.List;

@Data
public class HandlingUnitResponseModel {

    private String correlationId;
    private List<Entity> entities;
    private String errorMessage;
    private String errorMessageName;
    private String status;
    private Boolean success;
    private Integer total;
    private List<ValidationResult> validationResults;
    private List<HandlingUnitRequestPart> handlingUnitRequestParts;
    private String type;
    private Entity entity;
    private String messageInfo;
}
