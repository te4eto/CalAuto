package calsuite.testdata.item;


import calsuite.models.request.item.CreateItemRequestModel;
import calsuite.models.request.item.Description;
import calsuite.models.request.item.StockKeepingUnit;
import calsuite.utils.RandomGenerator;

public class ItemsTestData {

    public static Description getItemDescription() {
        Description body = Description.builder()
                .dictionaryId(7101)
                .phraseId(152802)
                .build();
        return body;
    }

    public static StockKeepingUnit getStockKeepingUnit() {
        StockKeepingUnit body = StockKeepingUnit.builder()
                .dictionaryId(176201)
                .phraseId(1298601)
                .build();
        return body;
    }

    public static CreateItemRequestModel getCreateItemRequestTestData1() {
        return CreateItemRequestModel.builder()
                .netWeight(21)
                .grossWeight(51)
                .name(RandomGenerator.generateRandomBeer() + "_AUT")
                .description(getItemDescription())
                .stockKeepingUnit(getStockKeepingUnit())
                .isActive(true)
                .build();
    }

}
