package org.example.library.models.responseModels.items.item;

import lombok.Data;

@Data
public class CreatePhraseResponseModel {
    public String correlationId;
    public Entity entity;
    public Object errorMessage;
    public Object errorMessageName;
    public Object messageInfo;
    public String status;
    public boolean success;
    public Object validationResults;
}