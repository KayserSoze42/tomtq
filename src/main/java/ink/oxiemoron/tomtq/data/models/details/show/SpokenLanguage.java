package ink.oxiemoron.tomtq.data.models.details.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpokenLanguage {
    @JsonProperty("english_name")
    public String getEnglish_name() {
        return this.english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    String english_name;

    @JsonProperty("iso_639_1")
    public String getIso_639_1() {
        return this.iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    String iso_639_1;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
