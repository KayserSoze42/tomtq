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
public class TOMTQShowController {

    ObjectNode error = new ObjectMapper().createObjectNode();
    Logger logger = LoggerFactory.getLogger(TOMTQShowController.class);

    @GetMapping("/tomtq/show")
    public ResponseEntity<ObjectNode> findShowWithTitle(@RequestParam(value = "title", required = false) String title,
                                                        @RequestParam(value = "cast", required = false) String cast,
                                                        @RequestParam(value = "lang", required = false) String lang){

        logger.info("Request /tomtq/show");

        if (title != null) {

            logger.info("Query for shows with a title");

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

            logger.info("Query for shows with cast");

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

            logger.info("No queries provided, using default");

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

        logger.info("Request /tomtq/show/" + id);

        try {

            return ResponseEntity.ok(TMDbApiController.getShowWithId(id));

        } catch (ItemNotFoundException infe) {

            logger.error(infe.getMessage());
            logger.error(String.valueOf(id));

            error.put("message", infe.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        }
    }

}
