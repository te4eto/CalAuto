package org.example.library.models.requestModels.approvalRequests;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateApprovalRequest {
    private String status;
}
