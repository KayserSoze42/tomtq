package ink.oxiemoron.tomtq.rest.consumers.tmdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ink.oxiemoron.tomtq.data.models.details.movie.MovieDetailsResponse;
import ink.oxiemoron.tomtq.data.models.details.person.Cast;
import ink.oxiemoron.tomtq.data.models.details.person.CastDetailsResponse;
import ink.oxiemoron.tomtq.data.models.details.person.PersonDetailsResponse;
import ink.oxiemoron.tomtq.data.models.details.show.ShowDetailsResponse;
import ink.oxiemoron.tomtq.data.models.search.movie.MovieSearchResponse;
import ink.oxiemoron.tomtq.data.models.search.movie.MovieSearchResult;
import ink.oxiemoron.tomtq.data.models.search.person.PersonSearchResponse;
import ink.oxiemoron.tomtq.data.models.search.person.PersonSearchResult;
import ink.oxiemoron.tomtq.data.models.search.show.ShowSearchResponse;
import ink.oxiemoron.tomtq.data.models.search.show.ShowSearchResult;
import ink.oxiemoron.tomtq.utils.exceptions.BadRequestException;
import ink.oxiemoron.tomtq.utils.exceptions.ItemNotFoundException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TMDbApiController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String API_KEY = System.getenv("tmdb-api-key");
    private static final String SEARCH_URL = "https://api.themoviedb.org/3/search/%s?api_key=%s&query=%s&page=%d";
    private static final String DETAILS_URL = "https://api.themoviedb.org/3/%s/%d?api_key=%s";
    private static final String DISCOVER_URL = "https://api.themoviedb.org/3/discover/%s?api_key=%s&with_cast=%s&page=%d";

    private static final String MAGIC_URL = "https://api.themoviedb.org/3/person/%d/movie_credits?api_key=%s";
                                // Will change to credits url when new magik be lern


    public static ObjectNode searchPersonWithName(String name) throws ItemNotFoundException, BadRequestException {

        String queryUrl = String.format(SEARCH_URL, "person", API_KEY, name.replace(" ", "+"), 1);
        PersonSearchResponse response;
        ObjectNode output = objectMapper.createObjectNode();

        try {

            response = objectMapper.readValue(new URL(queryUrl), PersonSearchResponse.class);
            ArrayList<PersonSearchResult> results = response.getResults();

            int resultNo = 0;

            output.put("id", results.get(0).getId());
            output.put("name", results.get(0).getName());

        } catch (IOException ioE) {

            throw new BadRequestException("Unable to process your request.. :(");

        } catch (IndexOutOfBoundsException iobE) {

            throw new ItemNotFoundException("Person(s) not found with given query");

        }

        return output;

    }

    public static ObjectNode searchMovieWithTitle(String title) throws ItemNotFoundException, BadRequestException {

        String queryUrl = String.format(SEARCH_URL, "movie", API_KEY, title.replace(" ", "+"), 1);
        MovieSearchResponse response;
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
                output.put("backdrop_path", result.getBackdrop_path());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);
            }

        } catch (IOException ioE) {

            throw new BadRequestException("Unable to process your request.. :(");

        } catch (IndexOutOfBoundsException iobE) {

            throw new ItemNotFoundException("Movie(s) not found with given query");

        }

        return outputs;
    }

    public static ObjectNode searchMovieWithCast(String cast) throws ItemNotFoundException, BadRequestException {

        StringBuilder castQuery = new StringBuilder();
        String delimiter = "";

        for (String person : cast.split(",")) {

            ObjectNode currentPerson = null;

            try {

                currentPerson = searchPersonWithName(person.replace(" ", "+"));

            } catch (BadRequestException e) {

                throw new ItemNotFoundException("Person not found with given query");

            }

            int currentId = currentPerson.get("id").asInt();
            castQuery.append(delimiter);
            castQuery.append(currentId);
            delimiter = ",";

        }

        String queryUrl = String.format(DISCOVER_URL, "movie", API_KEY, castQuery.toString(), 1);
        MovieSearchResponse response;
        ObjectNode outputs = objectMapper.createObjectNode();

        try {

            response = objectMapper.readValue(new URL(queryUrl), MovieSearchResponse.class);
            ArrayList<MovieSearchResult> results = response.getResults();

            if (results.size() == 0) {
                throw new ItemNotFoundException("Movie(s) not found with given query");
            }

            int resultNo = 0;

            for (MovieSearchResult result : results) {
                resultNo += 1;

                ObjectNode output = objectMapper.createObjectNode();

                output.put("id", result.getId());
                output.put("title", result.getTitle());
                output.put("release_date", result.getRelease_date());
                output.put("overview", result.getOverview());
                output.put("backdrop_path", result.getBackdrop_path());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);
            }

        } catch (IOException ioe) {

            throw new BadRequestException("Unable to process your request.. :(");
        }

        return outputs;

    }

    public static ObjectNode searchShowWithTitle(String title) throws ItemNotFoundException, BadRequestException {

        String queryUrl = String.format(SEARCH_URL, "tv", API_KEY, title.replace(" ", "+"), 1);
        ShowSearchResponse response;
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
                output.put("backdrop_path", result.getBackdrop_path());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);
            }

        } catch (IOException ioE) {

            throw new BadRequestException("Unable to process your request.. :(");

        } catch (IndexOutOfBoundsException ioobe) {

            throw new ItemNotFoundException("Show(s) not found with given query");
        }
        return outputs;
    }

    public static ObjectNode searchShowWithCast(String cast) throws ItemNotFoundException, BadRequestException {

        StringBuilder castQuery = new StringBuilder();
        String delimiter = "";

        for (String person : cast.split(",")) {

            ObjectNode currentPerson = null;

            try {

                currentPerson = searchPersonWithName(person.replace(" ", "+"));

            } catch (BadRequestException e) {

                throw new ItemNotFoundException("Person not found with given query");

            }

            int currentId = currentPerson.get("id").asInt();
            castQuery.append(delimiter);
            castQuery.append(currentId);
            delimiter = ",";

        }

        String queryUrl = String.format(DISCOVER_URL, "tv", API_KEY, castQuery.toString(), 1);
        ShowSearchResponse response;
        ObjectNode outputs = objectMapper.createObjectNode();

        try {

            response = objectMapper.readValue(new URL(queryUrl), ShowSearchResponse.class);
            ArrayList<ShowSearchResult> results = response.getResults();

            int resultNo = 0;

            for (ShowSearchResult result : results) {
                resultNo += 1;

                ObjectNode output = objectMapper.createObjectNode();

                output.put("id", result.getId());
                output.put("name", result.getName());
                output.put("first_air_date", result.getFirst_air_date());
                output.put("overview", result.getOverview());
                output.put("backdrop_path", result.getBackdrop_path());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);
            }

        } catch (IOException ioe) {
            throw new BadRequestException("Unable to process your request.. :(");
        }

        return outputs;


    }

    public static ObjectNode getPersonWithId(int id) throws ItemNotFoundException{

        String queryUrl = String.format(DETAILS_URL, "person", id, API_KEY);
        PersonDetailsResponse response;
        ObjectNode output = objectMapper.createObjectNode();
        try {
            response = objectMapper.readValue(new URL(queryUrl), PersonDetailsResponse.class);

            output.put("id", response.getId());
            output.put("name", response.getName());
            output.put("imdb_id", response.getImdb_id());

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            throw new ItemNotFoundException("Person not found with given id");
        }

        return output;
    }

    public static ObjectNode getMovieWithId(int id) throws ItemNotFoundException {

        String queryUrl = String.format(DETAILS_URL, "movie", id, API_KEY);
        MovieDetailsResponse response;
        ObjectNode output = objectMapper.createObjectNode();
        try {
            response = objectMapper.readValue(new URL(queryUrl), MovieDetailsResponse.class);

            output.put("id", response.getId());
            output.put("title", response.getTitle());
            output.put("release_date", response.getRelease_date());
            output.put("overview", response.getOverview());

        } catch (IOException ioE) {
            throw new ItemNotFoundException("Movie not found with given id");
        }
        return output;
    }

    public static ObjectNode getShowWithId(int id) throws ItemNotFoundException{

        String queryUrl = String.format(DETAILS_URL, "tv", id, API_KEY);
        ShowDetailsResponse response;
        ObjectNode output = objectMapper.createObjectNode();
        try {
            response = objectMapper.readValue(new URL(queryUrl), ShowDetailsResponse.class);

            output.put("id", response.getId());
            output.put("name", response.getName());
            output.put("first_air_date", response.getFirst_air_date());
            output.put("overview", response.getOverview());

        } catch (IOException ioE) {
            throw new ItemNotFoundException("Show not found with given id");
        }
        return output;
    }

    public static ObjectNode getCreditsForPerson(int id) throws Exception{

        String queryUrl = String.format(MAGIC_URL, id, API_KEY);
        CastDetailsResponse response;
        ObjectNode outputs = objectMapper.createObjectNode();
        try {

            response = objectMapper.readValue(new URL(queryUrl), CastDetailsResponse.class);

            ArrayList<Cast> casts = response.getCast(); // Hocus pokus, man I can't focus

            int resultNo = 0;

            for (Cast cast : casts) {

                resultNo += 1;

                ObjectNode output = objectMapper.createObjectNode();

                output.put("adult", cast.getAdult()); // Lol, asking important questions here..
                output.put("id", cast.getId());
                output.put("character", cast.getCharacter()); // Good to have, see also: integrity
                // Jokes aside, the magic part and the first piece of the puzzle
                // IntelliJ froze (no kidding) as I wrote this, it knows..
                output.put("credit_id", cast.getCredit_id());

                String jsonOutput = objectMapper.writeValueAsString(output);

                outputs.put(Integer.toString(resultNo), jsonOutput);

            }


        } catch (IOException ioe) {

            throw new BadRequestException("Not sure about the logic and the names, keeping for noe");

        }

        return outputs;


    }


}
