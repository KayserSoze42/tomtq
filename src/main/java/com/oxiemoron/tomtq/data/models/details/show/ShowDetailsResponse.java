package com.oxiemoron.tomtq.data.models.details.show;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ShowDetailsResponse{
    @JsonProperty("adult")
    public boolean getAdult() {
        return this.adult; }
    public void setAdult(boolean adult) {
        this.adult = adult; }
    boolean adult;
    @JsonProperty("backdrop_path")
    public String getBackdrop_path() {
        return this.backdrop_path; }
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path; }
    String backdrop_path;
    @JsonProperty("created_by")
    public ArrayList<CreatedBy> getCreated_by() {
        return this.created_by; }
    public void setCreated_by(ArrayList<CreatedBy> created_by) {
        this.created_by = created_by; }
    ArrayList<CreatedBy> created_by;
    @JsonProperty("episode_run_time")
    public ArrayList<Integer> getEpisode_run_time() {
        return this.episode_run_time; }
    public void setEpisode_run_time(ArrayList<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time; }
    ArrayList<Integer> episode_run_time;
    @JsonProperty("first_air_date")
    public String getFirst_air_date() {
        return this.first_air_date; }
    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date; }
    String first_air_date;
    @JsonProperty("genres")
    public ArrayList<Genre> getGenres() {
        return this.genres; }
    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres; }
    ArrayList<Genre> genres;
    @JsonProperty("homepage")
    public String getHomepage() {
        return this.homepage; }
    public void setHomepage(String homepage) {
        this.homepage = homepage; }
    String homepage;
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("in_production")
    public boolean getIn_production() {
        return this.in_production; }
    public void setIn_production(boolean in_production) {
        this.in_production = in_production; }
    boolean in_production;
    @JsonProperty("languages")
    public ArrayList<String> getLanguages() {
        return this.languages; }
    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages; }
    ArrayList<String> languages;
    @JsonProperty("last_air_date")
    public String getLast_air_date() {
        return this.last_air_date; }
    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date; }
    String last_air_date;
    @JsonProperty("last_episode_to_air")
    public LastEpisodeToAir getLast_episode_to_air() {
        return this.last_episode_to_air; }
    public void setLast_episode_to_air(LastEpisodeToAir last_episode_to_air) {
        this.last_episode_to_air = last_episode_to_air; }
    LastEpisodeToAir last_episode_to_air;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("next_episode_to_air")
    public Object getNext_episode_to_air() {
        return this.next_episode_to_air; }
    public void setNext_episode_to_air(Object next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air; }
    Object next_episode_to_air;
    @JsonProperty("networks")
    public ArrayList<Network> getNetworks() {
        return this.networks; }
    public void setNetworks(ArrayList<Network> networks) {
        this.networks = networks; }
    ArrayList<Network> networks;
    @JsonProperty("number_of_episodes")
    public int getNumber_of_episodes() {
        return this.number_of_episodes; }
    public void setNumber_of_episodes(int number_of_episodes) {
        this.number_of_episodes = number_of_episodes; }
    int number_of_episodes;
    @JsonProperty("number_of_seasons")
    public int getNumber_of_seasons() {
        return this.number_of_seasons; }
    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons; }
    int number_of_seasons;
    @JsonProperty("origin_country")
    public ArrayList<String> getOrigin_country() {
        return this.origin_country; }
    public void setOrigin_country(ArrayList<String> origin_country) {
        this.origin_country = origin_country; }
    ArrayList<String> origin_country;
    @JsonProperty("original_language")
    public String getOriginal_language() {
        return this.original_language; }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language; }
    String original_language;
    @JsonProperty("original_name")
    public String getOriginal_name() {
        return this.original_name; }
    public void setOriginal_name(String original_name) {
        this.original_name = original_name; }
    String original_name;
    @JsonProperty("overview")
    public String getOverview() {
        return this.overview; }
    public void setOverview(String overview) {
        this.overview = overview; }
    String overview;
    @JsonProperty("popularity")
    public double getPopularity() {
        return this.popularity; }
    public void setPopularity(double popularity) {
        this.popularity = popularity; }
    double popularity;
    @JsonProperty("poster_path")
    public String getPoster_path() {
        return this.poster_path; }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path; }
    String poster_path;
    @JsonProperty("production_companies")
    public ArrayList<ProductionCompany> getProduction_companies() {
        return this.production_companies; }
    public void setProduction_companies(ArrayList<ProductionCompany> production_companies) {
        this.production_companies = production_companies; }
    ArrayList<ProductionCompany> production_companies;
    @JsonProperty("production_countries")
    public ArrayList<ProductionCountry> getProduction_countries() {
        return this.production_countries; }
    public void setProduction_countries(ArrayList<ProductionCountry> production_countries) {
        this.production_countries = production_countries; }
    ArrayList<ProductionCountry> production_countries;
    @JsonProperty("seasons")
    public ArrayList<Season> getSeasons() {
        return this.seasons; }
    public void setSeasons(ArrayList<Season> seasons) {
        this.seasons = seasons; }
    ArrayList<Season> seasons;
    @JsonProperty("spoken_languages")
    public ArrayList<SpokenLanguage> getSpoken_languages() {
        return this.spoken_languages; }
    public void setSpoken_languages(ArrayList<SpokenLanguage> spoken_languages) {
        this.spoken_languages = spoken_languages; }
    ArrayList<SpokenLanguage> spoken_languages;
    @JsonProperty("status")
    public String getStatus() {
        return this.status; }
    public void setStatus(String status) {
        this.status = status; }
    String status;
    @JsonProperty("tagline")
    public String getTagline() {
        return this.tagline; }
    public void setTagline(String tagline) {
        this.tagline = tagline; }
    String tagline;
    @JsonProperty("type")
    public String getType() {
        return this.type; }
    public void setType(String type) {
        this.type = type; }
    String type;
    @JsonProperty("vote_average")
    public double getVote_average() {
        return this.vote_average; }
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average; }
    double vote_average;
    @JsonProperty("vote_count")
    public int getVote_count() {
        return this.vote_count; }
    public void setVote_count(int vote_count) {
        this.vote_count = vote_count; }
    int vote_count;
}


