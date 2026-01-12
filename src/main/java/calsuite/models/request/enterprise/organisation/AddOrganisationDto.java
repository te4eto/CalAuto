package calsuite.models.request.enterprise.organisation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddOrganisationDto {

    private String type;
    private Boolean isBranch;
    private Boolean isCompany;
    private Boolean isDelegate;
    private Boolean isDepot;
    private Boolean isPrincipal;
    private String name;
    private ParentDepot parentDepot;
}
