package ink.oxiemoron.tomtq.data.models.search.show;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class ShowSearchResponse {
    @JsonProperty("page")
    public int getPage() {
        return this.page; }
    public void setPage(int page) {
        this.page = page; }
    int page;
    @JsonProperty("results")
    public ArrayList<ShowSearchResult> getResults() {
        return this.results; }
    public void setResults(ArrayList<ShowSearchResult> results) {
        this.results = results; }
    ArrayList<ShowSearchResult> results;
    @JsonProperty("total_pages")
    public int getTotal_pages() {
        return this.total_pages; }
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages; }
    int total_pages;
    @JsonProperty("total_results")
    public int getTotal_results() {
        return this.total_results; }
    public void setTotal_results(int total_results) {
        this.total_results = total_results; }
    int total_results;
}

