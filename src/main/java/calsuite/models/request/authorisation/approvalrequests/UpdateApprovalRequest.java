package calsuite.models.request.authorisation.approvalrequests;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateApprovalRequest {
    private String status;
}
