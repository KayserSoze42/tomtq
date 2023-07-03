package ink.oxiemoron.tomtq.data.models.search.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class ShowSearchResult {
    @JsonProperty("adult")
    public boolean getAdult() {
        return this.adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    boolean adult;

    @JsonProperty("backdrop_path")
    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    String backdrop_path;

    @JsonProperty("genre_ids")
    public ArrayList<Integer> getGenre_ids() {
        return this.genre_ids;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    ArrayList<Integer> genre_ids;

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("origin_country")
    public ArrayList<String> getOrigin_country() {
        return this.origin_country;
    }

    public void setOrigin_country(ArrayList<String> origin_country) {
        this.origin_country = origin_country;
    }

    ArrayList<String> origin_country;

    @JsonProperty("original_language")
    public String getOriginal_language() {
        return this.original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    String original_language;

    @JsonProperty("original_name")
    public String getOriginal_name() {
        return this.original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    String original_name;

    @JsonProperty("overview")
    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    String overview;

    @JsonProperty("popularity")
    public double getPopularity() {
        return this.popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    double popularity;

    @JsonProperty("poster_path")
    public String getPoster_path() {
        return this.poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    String poster_path;

    @JsonProperty("first_air_date")
    public String getFirst_air_date() {
        return this.first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    String first_air_date;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

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
}
