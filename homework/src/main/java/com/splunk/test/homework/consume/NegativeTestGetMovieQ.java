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
 * Rest Controller to get the negative scenarios for get Movie API with 'q' param
 */
@RestController
@RequestMapping("/getMoviesWithQ")
@Produces("application/json")
@Consumes("application/json")
public class NegativeTestGetMovieQ {

    @RequestMapping(method = RequestMethod.GET, value="qNotPassed")
    ResponseEntity<?> qNotPassed() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="qAsNull")
    ResponseEntity<?> qAsNull(@PathVariable String q) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="qMalformed")
    ResponseEntity<?> qMalformed(@PathVariable String q) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="qSQLInjection")
    ResponseEntity<?> qSQLInjection(@PathVariable String q) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="qWildcard")
    ResponseEntity<?> qWildcard(@PathVariable String q) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value="qWithDiffVerb")
    ResponseEntity<?> qWithDiffVerb(@PathVariable String q) {
        return null;
    }
}
