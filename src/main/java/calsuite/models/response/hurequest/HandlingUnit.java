package calsuite.models.response.hurequest;

import calsuite.models.response.common.responses.IntendedSpace;
import lombok.Data;

@Data
public class HandlingUnit {
    private Integer id;
    private IntendedSpace intendedSpace;
    private String sscc;
}
