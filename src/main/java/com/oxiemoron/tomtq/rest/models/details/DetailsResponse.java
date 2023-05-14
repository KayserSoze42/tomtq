package com.oxiemoron.tomtq.rest.models.details;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DetailsResponse{
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
    @JsonProperty("belongs_to_collection")
    public BelongsToCollection getBelongs_to_collection() {
        return this.belongs_to_collection; }
    public void setBelongs_to_collection(BelongsToCollection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection; }
    BelongsToCollection belongs_to_collection;
    @JsonProperty("budget")
    public int getBudget() {
        return this.budget; }
    public void setBudget(int budget) {
        this.budget = budget; }
    int budget;
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
    @JsonProperty("imdb_id")
    public String getImdb_id() {
        return this.imdb_id; }
    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id; }
    String imdb_id;
    @JsonProperty("original_language")
    public String getOriginal_language() {
        return this.original_language; }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language; }
    String original_language;
    @JsonProperty("original_title")
    public String getOriginal_title() {
        return this.original_title; }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title; }
    String original_title;
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
    @JsonProperty("release_date")
    public String getRelease_date() {
        return this.release_date; }
    public void setRelease_date(String release_date) {
        this.release_date = release_date; }
    String release_date;
    @JsonProperty("revenue")
    public int getRevenue() {
        return this.revenue; }
    public void setRevenue(int revenue) {
        this.revenue = revenue; }
    int revenue;
    @JsonProperty("runtime")
    public int getRuntime() {
        return this.runtime; }
    public void setRuntime(int runtime) {
        this.runtime = runtime; }
    int runtime;
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
    @JsonProperty("title")
    public String getTitle() {
        return this.title; }
    public void setTitle(String title) {
        this.title = title; }
    String title;
    @JsonProperty("video")
    public boolean getVideo() {
        return this.video; }
    public void setVideo(boolean video) {
        this.video = video; }
    boolean video;
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

