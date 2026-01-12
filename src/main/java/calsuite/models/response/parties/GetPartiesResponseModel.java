package calsuite.models.response.parties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetPartiesResponseModel {

    private String correlationId;
    @JsonProperty("entities")
    private List<ResponseEntity> entities;
    private Object errorMessage;
    private Object errorMessageName;
    private String status;
    private boolean success;
    private long total;
    private Object validationResults;
}
