package calsuite.models.response.authorisation.approvalrequests;

import lombok.Data;

@Data
public class ApprovalRequestsEntity {
    private String entityFullName;
    private long entityId;
    private int id;
    private long ownerId;
    private String requestContent;
    private long requestedBy;
    private long respondedBy;
    private String status;
    private String type;
}
