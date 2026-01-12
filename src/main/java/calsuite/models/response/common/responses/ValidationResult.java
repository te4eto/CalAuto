package calsuite.models.response.common.responses;

import lombok.Data;

@Data
public class ValidationResult {

    private String errorMessage;
    private String errorMessageName;
    private String propertyPath;
    private String severity;
}
