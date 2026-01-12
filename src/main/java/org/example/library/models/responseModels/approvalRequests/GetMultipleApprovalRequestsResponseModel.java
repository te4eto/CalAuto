package org.example.library.models.responseModels.approvalRequests;

import lombok.Data;

import java.util.List;

@Data
public class GetMultipleApprovalRequestsResponseModel {
    private String correlationId;
    private List<ApprovalRequestsEntity> entities;
    private String errorMessage;
    private String errorMessageName;
    private String status;
    private boolean success;
    private long total;
    private List<ValidationResult> validationResults;
    private String type;
}
