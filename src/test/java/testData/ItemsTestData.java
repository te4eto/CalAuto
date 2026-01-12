package testData;

import org.example.library.models.requestModels.descriptions.DescriptionBody;

import java.util.List;

public class ItemsTestData {

    public static DescriptionBody getItemDescription(){
        DescriptionBody body = DescriptionBody.builder()
                .name("Test Item Description")
                .translations(List.of(
                        DescriptionBody.Translation.builder()
                                .translation("Test Description")
                                .language("en")
                                .build()
                ))
                .build();

        return body;
    }
}
