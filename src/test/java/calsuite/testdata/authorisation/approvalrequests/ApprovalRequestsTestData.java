package calsuite.testdata.authorisation.approvalrequests;

import calsuite.models.request.authorisation.approvalrequests.CreateApprovalRequestsRequestModel;
import calsuite.models.request.authorisation.approvalrequests.UpdateApprovalRequest;

public class ApprovalRequestsTestData {

    public static CreateApprovalRequestsRequestModel getCreateApprovalRequestTestData(){
        return CreateApprovalRequestsRequestModel.builder()
                .entityFullName("ApprovalRequestTestName")
                .requestContent("ApprovalRequestTestContent")
                .type("Underdelivery")
                .build();
    }

    public static CreateApprovalRequestsRequestModel getCreateApprovalRequestTestData2(){
        return CreateApprovalRequestsRequestModel.builder()
                .entityFullName("ApprovalRequestTestNameForUpdate")
                .requestContent("ApprovalRequestTestContentForUpdate")
                .type("Underdelivery")
                .build();
    }

    public static UpdateApprovalRequest getUpdateApprovalRequestRejectedTestData(){
        return UpdateApprovalRequest.builder()
                .status("Rejected")
                .build();
    }

    public static UpdateApprovalRequest getUpdateApprovalRequestApprovedTestData(){
        return UpdateApprovalRequest.builder()
                .status("Approved")
                .build();
    }

    public static UpdateApprovalRequest getUpdateApprovalRequestInvalidTestData(){
        return UpdateApprovalRequest.builder()
                .status("Invalid")
                .build();
    }
}
