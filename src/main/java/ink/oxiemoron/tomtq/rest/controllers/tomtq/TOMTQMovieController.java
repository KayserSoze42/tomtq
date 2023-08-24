package ink.oxiemoron.tomtq.rest.controllers.tomtq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ink.oxiemoron.tomtq.rest.consumers.tmdb.TMDbApiController;
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
public class TOMTQMovieController {

    ObjectNode error = new ObjectMapper().createObjectNode();
    Logger logger = LoggerFactory.getLogger(TOMTQMovieController.class);

    @GetMapping("/tomtq/movie")
    public ResponseEntity<ObjectNode> findMovie(@RequestParam(value = "title", required = false) String title,
                                                @RequestParam(value = "cast", required = false) String cast,
                                                @RequestParam(value = "lang", required = false) String lang) {

        logger.info("Request /tomtq/movie");


        if (title != null) {

            logger.info("Query for movies with title");

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

            logger.info("Query for movies with cast");

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

        } else if (lang != null) {

            logger.info("Query for movies with lang");

            try {

                return ResponseEntity.ok(TMDbApiController.searchMovieWithLanguage(lang));

            } catch (BadRequestException bre) {

                logger.error(bre.getMessage());
                logger.error(lang);

                error.put("message", bre.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

            } catch (ItemNotFoundException infe) {

                logger.error(infe.getMessage());
                logger.error(lang);

                error.put("message", infe.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

            }
        }
        else {

            logger.info("No queries provided, using default");

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

        logger.info("Request /tomtq/movie/" + id);

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
}
