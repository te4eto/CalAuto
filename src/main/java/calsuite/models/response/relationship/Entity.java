package calsuite.models.response.relationship;

import lombok.Data;

@Data
public class Entity {

    private FromParty fromParty;
    private Integer id;
    private ToParty toParty;
    private String $discriminator;
    private String type;
}
