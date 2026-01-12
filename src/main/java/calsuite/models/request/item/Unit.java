package calsuite.models.request.item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Unit {
    public Integer dictionaryId;
    public Integer phraseId;
}
