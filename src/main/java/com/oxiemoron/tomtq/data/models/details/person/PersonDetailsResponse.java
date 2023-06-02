package com.oxiemoron.tomtq.data.models.details.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class PersonDetailsResponse{
    @JsonProperty("adult")
    public boolean getAdult() {
        return this.adult; }
    public void setAdult(boolean adult) {
        this.adult = adult; }
    boolean adult;
    @JsonProperty("also_known_as")
    public ArrayList<String> getAlso_known_as() {
        return this.also_known_as; }
    public void setAlso_known_as(ArrayList<String> also_known_as) {
        this.also_known_as = also_known_as; }
    ArrayList<String> also_known_as;
    @JsonProperty("biography")
    public String getBiography() {
        return this.biography; }
    public void setBiography(String biography) {
        this.biography = biography; }
    String biography;
    @JsonProperty("birthday")
    public String getBirthday() {
        return this.birthday; }
    public void setBirthday(String birthday) {
        this.birthday = birthday; }
    String birthday;
    @JsonProperty("deathday")
    public Object getDeathday() {
        return this.deathday; }
    public void setDeathday(Object deathday) {
        this.deathday = deathday; }
    Object deathday;
    @JsonProperty("gender")
    public int getGender() {
        return this.gender; }
    public void setGender(int gender) {
        this.gender = gender; }
    int gender;
    @JsonProperty("homepage")
    public Object getHomepage() {
        return this.homepage; }
    public void setHomepage(Object homepage) {
        this.homepage = homepage; }
    Object homepage;
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
    @JsonProperty("known_for_department")
    public String getKnown_for_department() {
        return this.known_for_department; }
    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department; }
    String known_for_department;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("place_of_birth")
    public String getPlace_of_birth() {
        return this.place_of_birth; }
    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth; }
    String place_of_birth;
    @JsonProperty("popularity")
    public double getPopularity() {
        return this.popularity; }
    public void setPopularity(double popularity) {
        this.popularity = popularity; }
    double popularity;
    @JsonProperty("profile_path")
    public String getProfile_path() {
        return this.profile_path; }
    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path; }
    String profile_path;
}

