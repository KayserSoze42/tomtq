package ink.oxiemoron.tomtq.data.models.details.person;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

import java.util.ArrayList;

public class CastDetailsResponse{
    @JsonProperty("cast")
    public ArrayList<Cast> getCast() {
        return this.cast; }
    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast; }
    ArrayList<Cast> cast;
    @JsonProperty("crew")
    public ArrayList<Object> getCrew() {
        return this.crew; }
    public void setCrew(ArrayList<Object> crew) {
        this.crew = crew; }
    ArrayList<Object> crew;
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
}

