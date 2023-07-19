package ink.oxiemoron.tomtq.rest.controllers.tomtq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ink.oxiemoron.tomtq.rest.controllers.tmdb.TMDbApiController;
import ink.oxiemoron.tomtq.utils.exceptions.BadRequestException;
import ink.oxiemoron.tomtq.utils.exceptions.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TOMTQRestController {

    ObjectNode error = new ObjectMapper().createObjectNode();
    Logger logger = LoggerFactory.getLogger(TOMTQRestController.class);

    @GetMapping("/tomtq/movie")
    public ResponseEntity<ObjectNode> findMovieWithTitle(@RequestParam(value = "title", required = false) String title,
                                             @RequestParam(value = "cast", required = false) String cast) {

        logger.debug("Request /tomtq/movie");


        if (title != null) {

            logger.debug("Query for movies with title");

            try {

                return ResponseEntity.ok(TMDbApiController.searchMovieWithTitle(title));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());
                logger.error(title);

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());
                logger.error(title);

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }

        } else if (cast != null) {

            logger.debug("Query for movies with cast");

            try {

                return ResponseEntity.ok(TMDbApiController.searchMovieWithCast(cast));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());
                logger.error(cast);

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());
                logger.error(cast);

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }
        } else {

            logger.debug("No queries provided, using default");

            try {

                return ResponseEntity.ok(TMDbApiController.searchMovieWithTitle("Lord Of The Rings"));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }
        }

    }

    @GetMapping("/tomtq/movie/{id}")
    public ResponseEntity<ObjectNode> getMovieWithId(@PathVariable(value = "id") int id) {

        logger.debug("Request /tomtq/movie/" + id);

        ObjectNode error = new ObjectMapper().createObjectNode();

        try {

            return ResponseEntity.ok(TMDbApiController.getMovieWithId(id));

        } catch (ItemNotFoundException infe) {

            logger.error(infe.getMessage());
            logger.error(String.valueOf(id));

            error.put("message", infe.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/tomtq/show")
    public ResponseEntity<ObjectNode> findShowWithTitle(@RequestParam(value = "title", required = false) String title,
                                       @RequestParam(value = "cast", required = false) String cast) {

        logger.debug("Request /tomtq/show");

        ObjectNode error = new ObjectMapper().createObjectNode();

        if (title != null) {

            logger.debug("Query for shows with title");

            try {

                return ResponseEntity.ok(TMDbApiController.searchShowWithTitle(title));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());
                logger.error(title);

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());
                logger.error(title);

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }
        } else if (cast != null) {

            logger.debug("Query for shows with cast");

            try {

                return ResponseEntity.ok(TMDbApiController.searchShowWithCast(cast));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());
                logger.error(cast);

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());
                logger.error(cast);

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }

        } else {

            logger.debug("No queries provided, using default");

            try {

                return ResponseEntity.ok(TMDbApiController.searchShowWithTitle("The Good Place"));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }
        }

    }

    @GetMapping("/tomtq/show/{id}")
    public ResponseEntity<ObjectNode> getShowWithId(@PathVariable(value = "id") int id) {

        logger.debug("Request /tomtq/show/" + id);

        ObjectNode error = new ObjectMapper().createObjectNode();

        try {

            return ResponseEntity.ok(TMDbApiController.getShowWithId(id));

        } catch (ItemNotFoundException infe) {

            logger.error(infe.getMessage());
            logger.error(String.valueOf(id));

            error.put("message", infe.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/tomtq/person")
    public ResponseEntity<ObjectNode> findPersonWithName(@RequestParam(value = "query", defaultValue = "Robert Glenister") String query) {

        logger.debug("Request /tomtq/person");

        ObjectNode error = new ObjectMapper().createObjectNode();

        try {

            return ResponseEntity.ok(TMDbApiController.searchPersonWithName(query));

        } catch (BadRequestException bre) {

            logger.error(bre.getMessage());
            logger.error(query);

            error.put("message", bre.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        } catch (ItemNotFoundException infe) {

            logger.error(infe.getMessage());
            logger.error(query);

            error.put("message", infe.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/tomtq/person/{id}")
    public ResponseEntity<ObjectNode>getPersonWithId(@PathVariable(value = "id") int id) {

        logger.debug("Request /tomtq/person/" + id);

        ObjectNode error = new ObjectMapper().createObjectNode();

        try {

            return ResponseEntity.ok(TMDbApiController.getPersonWithId(id));

        } catch (ItemNotFoundException infe) {

            logger.error(infe.getMessage());
            logger.error(String.valueOf(id));

            error.put("message", infe.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        }
    }
}
