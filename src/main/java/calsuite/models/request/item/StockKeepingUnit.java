package calsuite.models.request.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockKeepingUnit {
    public Integer dictionaryId;
    public Integer phraseId;

}
