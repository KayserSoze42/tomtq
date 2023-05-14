package com.oxiemoron.tomtq.rest.models.details.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season {
    @JsonProperty("air_date")
    public String getAir_date() {
        return this.air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    String air_date;

    @JsonProperty("episode_count")
    public int getEpisode_count() {
        return this.episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    int episode_count;

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("overview")
    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    String overview;

    @JsonProperty("poster_path")
    public String getPoster_path() {
        return this.poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    String poster_path;

    @JsonProperty("season_number")
    public int getSeason_number() {
        return this.season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    int season_number;
}
