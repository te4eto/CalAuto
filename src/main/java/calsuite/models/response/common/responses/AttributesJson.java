package calsuite.models.response.common.responses;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AttributesJson {

    @JsonProperty("Temperature Classification")
    private String temperatureClassification;
    @JsonProperty("Kind of tax")
    private String kindOfTax;
    @JsonProperty("Custom tariff number")
    private Integer customTariffNumber;
}
