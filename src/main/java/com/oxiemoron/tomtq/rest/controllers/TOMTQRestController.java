package com.oxiemoron.tomtq.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TOMTQRestController {

    @GetMapping("/tomtq/movie")
    public ObjectNode findMovieWithTitle(@RequestParam(value = "title", required = false) String title,
                                       @RequestParam(value = "cast", required = false) String cast) {

        if (title != null) {
            return TMDbApiController.searchMovieWithTitle(title);
        } else if (cast != null) {
            return TMDbApiController.searchMovieWithCast(cast);
        } else {
            return TMDbApiController.searchMovieWithTitle("Lord Of The Rings");
        }

    }

    @GetMapping("/tomtq/movie/{id}")
    public ObjectNode getMovieWithId(@PathVariable(value = "id") int id) {
        return TMDbApiController.getMovieWithId(id);
    }

    @GetMapping("/tomtq/show")
    public ObjectNode findShowWithTitle(@RequestParam(value = "title", required = false) String title,
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
    public ObjectNode getShowWithId(@PathVariable(value = "id") int id) {
        return TMDbApiController.getShowWithId(id);
    }

    @GetMapping("/tomtq/person")
    public ObjectNode findPersonWithName(@RequestParam(value = "query", defaultValue = "Robert Glenister") String query) {
        return  TMDbApiController.searchPersonWithName(query);
    }

    @GetMapping("/tomtq/person/{id}")
    public ObjectNode getPersonWithId(@PathVariable(value = "id") int id) {
        return TMDbApiController.getPersonWithId(id);
    }
}
