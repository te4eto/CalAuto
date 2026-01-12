package calsuite.models.response.enterprise.organisation;

import lombok.Data;

@Data
public class ServiceResponseOrganisationDto {

    private String correlationId;
    private Entity entity;
    private Object errorMessage;
    private Object errorMessageName;
    private Object messageInfo;
    private String status;
    private Boolean success;
    private Object validationResults;
}
