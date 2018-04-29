package com.splunk.test.homework.consume;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 * @author Ankur
 * Rest controller for testing the negative test cases for get movie API with 'count' param
 */
@RestController
@RequestMapping("/getMoviesWithCount")
@Produces("application/json")
@Consumes("application/json")
public class NegativeTestGetMovieCount {

    @RequestMapping(method = RequestMethod.GET, value="onlyCount")
    ResponseEntity<?> onlyCount(@PathVariable long count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="negativeCount")
    ResponseEntity<?> negativeCount(@PathVariable long count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="highCount")
    ResponseEntity<?> highCount(@PathVariable long count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="floatingNumCount")
    ResponseEntity<?> floatingNumCount(@PathVariable float count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="countAsString")
    ResponseEntity<?> countAsString(@PathVariable String count) {
        return null;
    }
}
