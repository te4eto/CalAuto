package calsuite.models.response.authorisation.approvalrequests;

import calsuite.models.response.common.responses.ValidationResult;
import lombok.Data;

import java.util.List;

@Data
public class CreateApprovalRequestsResponseModel {
    private String correlationId;
    private ApprovalRequestsEntity entity;
    private String errorMessage;
    private String errorMessageName;
    private String status;
    private boolean success;
    private String messageInfo;
    private List<ValidationResult> validationResults;
}
