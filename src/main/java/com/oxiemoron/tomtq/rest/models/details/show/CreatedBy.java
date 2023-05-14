package com.oxiemoron.tomtq.rest.models.details.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedBy {
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("credit_id")
    public String getCredit_id() {
        return this.credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    String credit_id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("gender")
    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    int gender;

    @JsonProperty("profile_path")
    public String getProfile_path() {
        return this.profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    String profile_path;
}
