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

public class TOMTQPersonController {

    ObjectNode error = new ObjectMapper().createObjectNode();
    Logger logger = LoggerFactory.getLogger(TOMTQShowController.class);

    @GetMapping("/tomtq/person")
    public ResponseEntity<ObjectNode> findPersonWithName(@RequestParam(value = "query", defaultValue = "Robert Glenister") String query) {

        logger.info("Request /tomtq/person");

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

        logger.info("Request /tomtq/person/" + id);

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
