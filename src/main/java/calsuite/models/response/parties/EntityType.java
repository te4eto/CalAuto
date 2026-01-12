package calsuite.models.response.parties;

import java.io.IOException;

public enum EntityType {
    OrganisationDTO, PartyDTO;

    public String toValue() {
        switch (this) {
            case OrganisationDTO: return "OrganisationDTO";
            case PartyDTO: return "PartyDTO";
        }
        return null;
    }

    public static EntityType forValue(String value) throws IOException {
        if (value.equals("OrganisationDTO")) return OrganisationDTO;
        if (value.equals("PartyDTO")) return PartyDTO;
        throw new IOException("Cannot deserialize Type");
    }
}
