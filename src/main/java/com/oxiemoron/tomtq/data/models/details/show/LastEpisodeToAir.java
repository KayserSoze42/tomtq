package com.oxiemoron.tomtq.data.models.details.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastEpisodeToAir {
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

    @JsonProperty("vote_average")
    public double getVote_average() {
        return this.vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    double vote_average;

    @JsonProperty("vote_count")
    public int getVote_count() {
        return this.vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    int vote_count;

    @JsonProperty("air_date")
    public String getAir_date() {
        return this.air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    String air_date;

    @JsonProperty("episode_number")
    public int getEpisode_number() {
        return this.episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    int episode_number;

    @JsonProperty("production_code")
    public String getProduction_code() {
        return this.production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    String production_code;

    @JsonProperty("runtime")
    public int getRuntime() {
        return this.runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    int runtime;

    @JsonProperty("season_number")
    public int getSeason_number() {
        return this.season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    int season_number;

    @JsonProperty("show_id")
    public int getShow_id() {
        return this.show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    int show_id;

    @JsonProperty("still_path")
    public String getStill_path() {
        return this.still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }

    String still_path;
}
