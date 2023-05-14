package com.oxiemoron.tomtq.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TOMTQRestController {


    @GetMapping("/tomtq/movie")
    public ObjectNode findMovieByTitle(@RequestParam(value = "title", defaultValue = "Lord Of The Rings") String title) {
        return TMDbApiController.searchMovieByTitle(title);
    }

    @GetMapping("/tomtq/movie/{id}")
    public ObjectNode getMovieById(@PathVariable(value = "id") int id) {
        return TMDbApiController.getMovieById(id);
    }

    @GetMapping("/tomtq/show")
    public ObjectNode findShowByTitle(@RequestParam(value = "title", defaultValue = "603") String title) {
        return TMDbApiController.searchShowByTitle(title);
    }

    @GetMapping("/tomtq/show/{id}")
    public ObjectNode getShowById(@PathVariable(value = "id") int id) {
        return TMDbApiController.getShowById(id);
    }
}
