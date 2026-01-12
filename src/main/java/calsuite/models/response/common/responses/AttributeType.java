package calsuite.models.response.common.responses;

import lombok.Data;

@Data
public class AttributeType {

    private String dataType;
    private Description description;
    private Integer dictionaryId;
    private String entityFullName;
    private Integer id;
    private String name;
    private String objectName;
    private String objectTarget;
    public Integer ownerId;
}
