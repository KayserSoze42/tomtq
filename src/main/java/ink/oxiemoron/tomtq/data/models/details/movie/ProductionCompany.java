package ink.oxiemoron.tomtq.data.models.details.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionCompany {
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("logo_path")
    public String getLogo_path() {
        return this.logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    String logo_path;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("origin_country")
    public String getOrigin_country() {
        return this.origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    String origin_country;
}
