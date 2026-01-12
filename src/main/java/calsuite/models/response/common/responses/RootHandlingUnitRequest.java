package calsuite.models.response.common.responses;

import calsuite.models.response.hurequest.HandlingUnit;
import lombok.Data;

@Data
public class RootHandlingUnitRequest {

    private HandlingUnit handlingUnit;
    public Integer id;
}
