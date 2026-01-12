package calsuite.models.response.item;

import lombok.Data;

@Data
public class Translation{
    
    private int id;
    private Language language;
    private int listIndex;
    private String value;
}