package com.oxiemoron.tomtq.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class TOMTQRestController {

    @GetMapping("/tomtq/movie")
    public ObjectNode findMovieByTitle(@RequestParam(value = "title", required = false) String title,
                                       @RequestParam(value = "cast", required = false) String cast) {

        if (title != null) {
            return TMDbApiController.searchMovieWithTitle(title);
        } else if (cast != null) {
            return TMDbApiController.searchMoviesWithCast(cast);
        } else {
            return TMDbApiController.searchMovieWithTitle("Lord Of The Rings");
        }

    }

    @GetMapping("/tomtq/movie/{id}")
    public ObjectNode getMovieById(@PathVariable(value = "id") int id) {
        return TMDbApiController.getMovieById(id);
    }

    @GetMapping("/tomtq/show")
    public ObjectNode findShowByTitle(@RequestParam(value = "title", required = false) String title,
                                       @RequestParam(value = "cast", required = false) String cast) {

        if (title != null) {
            return TMDbApiController.searchShowWithTitle(title);
        } else if (cast != null) {
            return TMDbApiController.searchShowWithCast(cast);
        } else {
            return TMDbApiController.searchShowWithTitle("The Good Place");
        }

    }

    @GetMapping("/tomtq/show/{id}")
    public ObjectNode getShowById(@PathVariable(value = "id") int id) {
        return TMDbApiController.getShowById(id);
    }

    @GetMapping("/tomtq/person")
    public ObjectNode findPersonByName(@RequestParam(value = "query", defaultValue = "Robert Glenister") String query) {
        return  TMDbApiController.searchPersonByName(query);
    }
}
