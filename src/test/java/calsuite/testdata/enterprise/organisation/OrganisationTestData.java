package calsuite.testdata.enterprise.organisation;

import calsuite.models.request.enterprise.organisation.AddOrganisationDto;
import calsuite.utils.RandomGenerator;

public class OrganisationTestData {

    /** Think about removing the builder as it takes longer to load test data  */
//    public static AddOrganisationDto createOrganisationData() {
//        return AddOrganisationDto.builder()
//                .type("AddOrganisationDTO")
//                .isBranch(false)
//                .isCompany(false)
//                .isDelegate(false)
//                .isDepot(false)
//                .isPrincipal(false)
//                .name("Automaiton test " + RandomGenerator.generateRandomBeer())
//                .build();
//    }


    public static AddOrganisationDto createOrganisationData() {

        AddOrganisationDto dto = new AddOrganisationDto();
        dto.setType("AddOrganisationDTO");
        dto.setIsBranch(false);
        dto.setIsCompany(false);
        dto.setIsDelegate(false);
        dto.setIsDepot(false);
        dto.setIsPrincipal(false);
        dto.setName("Automation test " + RandomGenerator.generateRandomBeer());

        return dto;
    }
}

