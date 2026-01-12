package org.example.library.models.requestModels.descriptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionBody {
    private String name;
    private List<Translation> translations;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Translation {
        private String translation;
        private String language;
    }
}
