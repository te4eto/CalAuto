package calsuite.models.request.descriptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CleanUpObject {
    public String partyId;
    public String dictionaryId;
    public String id;
}
