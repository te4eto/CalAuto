package calsuite.models.response.item;

import lombok.Data;

@Data
public class Versioning {

    private Integer latestVersionId;
    private Integer predecessorId;
}
