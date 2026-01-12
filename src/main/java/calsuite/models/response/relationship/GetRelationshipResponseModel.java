package calsuite.models.response.relationship;

import calsuite.models.response.common.responses.ValidationResult;
import lombok.Data;

import java.util.List;

@Data
public class GetRelationshipResponseModel {

    private String correlationId;
    private List<Entity> entities;
    private String errorMessage;
    private String errorMessageName;
    private String status;
    private Boolean success;
    private Integer total;
    private List<ValidationResult> validationResults;
    private String type;
    private String entity;
}
