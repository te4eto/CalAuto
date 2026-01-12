package calsuite.models.response.item;

import lombok.Data;

@Data
public class CreateItemResponseModel {

    private String correlationId;
    private Entity entity;
    private Object errorMessage;
    private Object errorMessageName;
    private Object messageInfo;
    private String status;
    private boolean success;
    private Object validationResults;
    private String detail;
    private String errors;
}