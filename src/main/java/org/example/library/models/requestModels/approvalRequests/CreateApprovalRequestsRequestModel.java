package org.example.library.models.requestModels.approvalRequests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateApprovalRequestsRequestModel {
    private String entityFullName;
    private long entityId;
    private String requestContent;
    private long requestedBy;
    private String type;
}
