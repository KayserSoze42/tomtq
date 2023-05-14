package com.oxiemoron.tomtq.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TOMTQRestController {


    @GetMapping("/tomtq/search/movie")
    public ObjectNode findMovieByTitle(@RequestParam(value = "title", defaultValue = "Lord Of The Rings") String title) {
        return TMDbApiController.searchMovieByTitle(title);
    }

    @GetMapping("/tomtq/get/movie")
    public ObjectNode getMovieById(@RequestParam(value = "id", defaultValue = "Lord Of The Rings") int id) {
        return TMDbApiController.getMovieById(id);
    }

    @GetMapping("/tomtq/search/show")
    public ObjectNode findShowByTitle(@RequestParam(value = "title", defaultValue = "Lord Of The Rings") String title) {
        return TMDbApiController.searchShowByTitle(title);
    }

    @GetMapping("/tomtq/get/show")
    public ObjectNode getShowById(@RequestParam(value = "id", defaultValue = "Lord Of The Rings") int id) {
        return TMDbApiController.getMovieById(id);
    }
}
