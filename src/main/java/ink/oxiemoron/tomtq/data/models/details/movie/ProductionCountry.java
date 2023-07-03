package ink.oxiemoron.tomtq.data.models.details.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionCountry {
    @JsonProperty("iso_3166_1")
    public String getIso_3166_1() {
        return this.iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    String iso_3166_1;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
