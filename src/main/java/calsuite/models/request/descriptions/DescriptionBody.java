package calsuite.models.request.descriptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionBody {
    public String name;
    public String translations;
    public String language;
//    @Data
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class Translation {
//        private String translation;
//        private String language;
//    }
}
