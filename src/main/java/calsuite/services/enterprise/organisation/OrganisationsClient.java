package calsuite.services.enterprise.organisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import calsuite.api.response.CustomResponse;
import calsuite.api.response.ResponseWrapper;
import calsuite.models.response.enterprise.organisation.ServiceResponseOrganisationDto;
import calsuite.services.ApiClient;
import calsuite.services.RequestType;


public class OrganisationsClient extends ApiClient {

    private final String basePath = "/api/enterprise/api/organisations/";

    public OrganisationsClient() {
        super();
    }

    /** POST REQUESTS
     *  Add an organisation by DTO - /api/enterprise/api/organisations */
    public ResponseWrapper<ServiceResponseOrganisationDto> addAnOrganisation(Object payload, String partyId) throws JsonProcessingException {
        setHeader("accept", "text/plain");
        setHeader("Party-Id", partyId);
        setHeader("Content-Type", "application/json-patch+json");

        return sendRequest(basePath, RequestType.POST, ServiceResponseOrganisationDto.class, payload);
    }

    /** DELETE REQUESTS
     * Delete an organisation by id - /api/enterprise/api/organisations/{id} */
    public CustomResponse deleteAnOrganisation(String partyId, String idOfOrganisation) throws JsonProcessingException {
        setHeader("Party-Id", partyId);
        return sendRequest(basePath + idOfOrganisation, RequestType.DELETE);
    }
}
