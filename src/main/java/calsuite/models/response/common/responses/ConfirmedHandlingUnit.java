package calsuite.models.response.common.responses;

import lombok.Data;

@Data
public class ConfirmedHandlingUnit {

    private Integer id;
    private long sscc;
    private IntendedSpace intendedSpace;
}