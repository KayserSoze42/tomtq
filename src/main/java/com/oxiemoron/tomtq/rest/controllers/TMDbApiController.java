package com.oxiemoron.tomtq.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.oxiemoron.tomtq.rest.models.details.movie.MovieDetailsResponse;
import com.oxiemoron.tomtq.rest.models.details.show.ShowDetailsResponse;
import com.oxiemoron.tomtq.rest.models.search.movie.MovieSearchResponse;
import com.oxiemoron.tomtq.rest.models.search.movie.MovieSearchResult;
import com.oxiemoron.tomtq.rest.models.search.show.ShowSearchResponse;
import com.oxiemoron.tomtq.rest.models.search.show.ShowSearchResult;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TMDbApiController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String API_KEY = System.getenv("tmdb-api-key");
    private static final String SEARCH_URL = "https://api.themoviedb.org/3/search/%s?api_key=%s&query=%s";
    private static final String DETAILS_URL = "https://api.themoviedb.org/3/%s/%d?api_key=%s";

    public static ObjectNode searchMovieByTitle(String title) {

        String queryUrl = String.format(SEARCH_URL, "movie", API_KEY, title.replace(" ", "+"));
        MovieSearchResponse response;
        String jsonOutputs = "{N/A}";
        ObjectNode outputs = objectMapper.createObjectNode();
        try {
            response = objectMapper.readValue(new URL(queryUrl), MovieSearchResponse.class);
            ArrayList<MovieSearchResult> results = response.getResults();

            int resultNo = 0;

            for (MovieSearchResult result : results) {
                resultNo += 1;

                ObjectNode output = objectMapper.createObjectNode();

                output.put("id", result.getId());
                output.put("title", result.getTitle());
                output.put("release_date", result.getRelease_date());
                output.put("overview", result.getOverview());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);
            }

            jsonOutputs = objectMapper.writeValueAsString(outputs);

        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        return outputs;
    }

    public static ObjectNode searchShowByTitle(String title) {

        String queryUrl = String.format(SEARCH_URL, "tv", API_KEY, title.replace(" ", "+"));
        ShowSearchResponse response;
        String jsonOutputs = "{N/A}";
        ObjectNode outputs = objectMapper.createObjectNode();
        try {
            response = objectMapper.readValue(new URL(queryUrl), ShowSearchResponse.class);
            ArrayList<ShowSearchResult> results = response.getResults();

            int resultNo = 0;

            for (ShowSearchResult result : results) {
                resultNo += 1;

                ObjectNode output = objectMapper.createObjectNode();

                output.put("id", result.getId());
                output.put("original_name", result.getOriginal_name());
                output.put("first_air_date", result.getFirst_air_date());
                output.put("overview", result.getOverview());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);
            }

            jsonOutputs = objectMapper.writeValueAsString(outputs);

        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        return outputs;
    }

    public static ObjectNode getMovieById(int id) {

        String queryUrl = String.format(DETAILS_URL, "movie", id, API_KEY);
        MovieDetailsResponse response;
        ObjectNode output = objectMapper.createObjectNode();
        String jsonOutput = "{N/A}";
        try {
            response = objectMapper.readValue(new URL(queryUrl), MovieDetailsResponse.class);

            output.put("id", response.getId());
            output.put("title", response.getTitle());
            output.put("release_date", response.getRelease_date());
            output.put("overview", response.getOverview());

            jsonOutput = objectMapper.writeValueAsString(output);

        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        return output;
    }

    public static ObjectNode getShowById(int id) {

        String queryUrl = String.format(DETAILS_URL, "tv", id, API_KEY);
        ShowDetailsResponse response;
        ObjectNode output = objectMapper.createObjectNode();
        String jsonOutput = "{N/A}";
        try {
            response = objectMapper.readValue(new URL(queryUrl), ShowDetailsResponse.class);

            output.put("id", response.getId());
            output.put("name", response.getName());
            output.put("first_air_date", response.getFirst_air_date());
            output.put("overview", response.getOverview());

            jsonOutput = objectMapper.writeValueAsString(output);

        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        return output;
    }


}
