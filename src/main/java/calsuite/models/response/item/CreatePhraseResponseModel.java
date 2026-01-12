package calsuite.models.response.item;

import lombok.Data;

@Data
public class CreatePhraseResponseModel {

    private String correlationId;
    private Entity entity;
    private Object errorMessage;
    private Object errorMessageName;
    private Object messageInfo;
    private String status;
    private boolean success;
    private Object validationResults;
}