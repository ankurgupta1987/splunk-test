package com.splunk.test.homework.consume;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 * @author Ankur
 * Rest Controller to test the get movie API
 */
@RestController
@RequestMapping("/getMovies")
@Produces("application/json")
@Consumes("application/json")
public class GetMovie {

    @RequestMapping(method = RequestMethod.GET, value="emptyParams")
    ResponseEntity<?> emptyParams(@PathVariable String q, @PathVariable long count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="countCheck")
    ResponseEntity<?> countCheck(@PathVariable String q, @PathVariable long count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="countZero")
    ResponseEntity<?> countZero(@PathVariable String q, @PathVariable long count) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="countTwo")
    ResponseEntity<?> countTwo(@PathVariable String q, @PathVariable long count) {
        return null;
    }

}
