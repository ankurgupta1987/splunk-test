package com.splunk.exercise.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.AddMovieResponse;
import com.splunk.exercise.model.Movies;
import com.splunk.exercise.model.PostMovieModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import static com.splunk.exercise.util.Constants.*;

/**
 * Class for Utility methods
 */
public class Utility {


    private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);
    private RestTemplate restTemplate;
    private ResponseEntity<String> response;

    public String prepareUrl(String q, String count) {
        StringBuilder builder = new StringBuilder();
        builder.append(MOVIE_API_URL).append(QUESTION_MARK);
        if (q != null) {
            builder.append(Q_PARAM).append(q);
        }
        if (count != null) {
            if (q != null) {
                builder.append(AMPERSAND);
            }
            builder.append(COUNT_PARAM).append(count);
        }
        return builder.toString();
    }

    public ResponseEntity<String> invokeRestAPI(String url, boolean isGet) throws BaseException {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<>(1);
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypeList);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

    public int getResponseStatusCode(ResponseEntity<?> response) {
        if (response != null) {
            return response.getStatusCodeValue();
        }
        return -1;
    }

    public String getResponseBody(ResponseEntity<?> response) {
        if (response != null) {
            return response.getBody().toString();
        }
        return null;
    }

    public HttpHeaders getResponseHeader(ResponseEntity<?> response) {
        if (response != null) {
            return response.getHeaders();
        }
        return null;
    }

    public int checkMovieCount(String jsonString) throws BaseException {
        int count = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            Movies.Results[] results = movies.getResults();
            if (results != null) {
                count = results.length;
            }
        } catch (IOException ioEx) {
            LOGGER.error("Error getting movie count", ioEx);
            throw new BaseException("Error checking for duplicate movie image", ioEx);
        }
        return count;
    }

    //1
    public boolean checkForTheDuplicateMovieImage(String jsonString) throws BaseException {
        boolean containsDuplicates = false;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            Movies.Results[] results = movies.getResults();
            containsDuplicates = checkDuplicateImageUtil(results);
        } catch (IOException ioEx) {
            LOGGER.error("Error checking for duplicate movie image", ioEx);
            throw new BaseException("Error checking for duplicate movie image", ioEx);
        }
            return containsDuplicates;

    }

    //2
    public boolean checkIfPosterPathLinksAreValid(String jsonString) throws BaseException {
        boolean posterLinksValid = false;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            Movies.Results[] results = movies.getResults();
            posterLinksValid = arePosterPathsValid(results);
        } catch (IOException ioEx) {
            LOGGER.error("Error checking poster path links", ioEx);
            throw new BaseException("Error checking poster path links", ioEx);
        }
        return posterLinksValid;
    }

    //3
    public boolean checkForOrderOfMovies(String jsonString) throws BaseException {
        boolean moviesOrderCorrect = false;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            List<Movies.Results> resultListReturned = Arrays.asList(movies.getResults());
            List<Movies.Results> resultListExpected = new ArrayList<>(resultListReturned);
            Collections.sort(resultListExpected, new MovieIdComparator());
            Collections.sort(resultListExpected, new GenreIdComparator());
            moviesOrderCorrect = validateIfMovieOrderIsSame(resultListReturned, resultListExpected);
        } catch (IOException ioEx) {
            LOGGER.error("Error checking movie order", ioEx);
            throw new BaseException("Error checking movie order", ioEx);
        }
        return moviesOrderCorrect;
    }

    //4
    public boolean checkIfGenreIdSumGreaterThan400(String jsonString) throws BaseException {
        int movieCountWithGenreIdSumGreater = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            Movies.Results[] results = movies.getResults();
            if (results != null) {
                for (Movies.Results result : results) {
                    Integer[] genreIdArr = result.getGenreIds();
                    if (genreIdArr != null) {
                        int sum = 0;
                        for (Integer genreId : genreIdArr) {
                            sum += genreId;
                        }
                        if (sum > GENRE_ID_SUM) {
                            movieCountWithGenreIdSumGreater++;
                            if (movieCountWithGenreIdSumGreater > MOVIE_COUNT) {
                                return false;
                            }
                            }
                        }
                    }
                }
        } catch (IOException ioEx) {
            LOGGER.error("Error checking genre id sum", ioEx);
            throw new BaseException("Error checking genre id sum", ioEx);
        }
        return movieCountWithGenreIdSumGreater > MOVIE_COUNT ? false : true;
    }

    //5
    public boolean ifMovieTitlesContainsPalindrome(String jsonString) throws BaseException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            Movies.Results[] results = movies.getResults();
            if (results != null) {
                for (Movies.Results result : results) {
                    if (titleHasPalindrome(result.getTitle())) {
                        return true;
                    }
                }
            }
        } catch (IOException ioEx) {
            LOGGER.error("Error checking palindrome string", ioEx);
            throw new BaseException("Error checking palindrome string", ioEx);
        }
        return false;
    }

    //6
    public boolean checkIfTitleContainsAnotherTitle(String jsonString) throws BaseException {
        boolean titleContainsTitle = false;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(jsonString, Movies.class);
            Movies.Results[] results = movies.getResults();
            titleContainsTitle = titleContainsAnotherTitleUtil(results);
        } catch (IOException ioEx) {
            LOGGER.error("Error checking title contains another title", ioEx);
            throw new BaseException("Error checking title contains another title", ioEx);
        }
        return titleContainsTitle;
    }

    public boolean titleContainsAnotherTitleUtil(Movies.Results[] results) {
        if (results == null || results.length == 0) {
            return false;
        }
        List<Movies.Results> movieList = Arrays.asList(results);
        Collections.sort(movieList, new MovieTitleLengthComparator());
        int count = 0;
        for (int i = 0; i < movieList.size(); i++) {
            int ptr = i + 1;
            String movieTitle = movieList.get(i).getTitle();
            if (movieTitle == null) {
                continue;
            }
            while (ptr < movieList.size()) {
                if (movieList.get(ptr).getTitle() != null && movieList.get(ptr).getTitle().indexOf(movieTitle) != -1) {
                    count++;
                }
                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean titleHasPalindrome(String title) {
        if (title == null || title.isEmpty()) {
            return false;
        }

        String[] wordsArr = title.split(" ");
        for (String str : wordsArr) {
            if (isPalindrome(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateIfMovieOrderIsSame(List<Movies.Results> resultListReturned, List<Movies.Results> resultListExpected) {
        if (resultListReturned == null || resultListExpected == null) {
            return false;
        }

        for (int i = 0; i < resultListReturned.size(); i++) {
            Movies.Results result1 = resultListReturned.get(i);
            Movies.Results result2 = resultListExpected.get(i);
            if (result1.getId() != result2.getId()
                    || (result1.getGenreIds() != null && result2.getGenreIds() == null)
                    || (result1.getGenreIds() == null && result2.getGenreIds() != null)
                    || (result1.getGenreIds() != result2.getGenreIds())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicateImageUtil(Movies.Results[] results) {
        if (results != null) {
            Set<String> uniqueImages = new HashSet<>(results.length);
            for (Movies.Results result : results) {
                if (result.getPosterPath() != null &&
                        !uniqueImages.add(extractMovieImageName(result.getPosterPath()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String extractMovieImageName(String posterPath) {
        if (posterPath == null || posterPath.isEmpty()) {
            return EMPTY_STRING;
        }
        if (posterPath.contains("?")) {
            posterPath = posterPath.substring(0, posterPath.lastIndexOf("?"));
        }
        StringBuilder movieImageName = new StringBuilder();
        for (int i = posterPath.length() - 1; i > 0; i--) {
            if (posterPath.charAt(i) == '/') {
                break;
            } else {
                movieImageName.append(posterPath.charAt(i));
            }
        }
        return movieImageName.reverse().toString();
    }

    public boolean arePosterPathsValid(Movies.Results[] results) {
        if (results != null) {
            Set<String> uniqueImages = new HashSet<>(results.length);
            for (Movies.Results result : results) {
                if (!validatePosterPath(result.getPosterPath())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validatePosterPath(String posterPath) {
        if (posterPath == null || posterPath.isEmpty()) {
            return true;
        }

        if (posterPath.startsWith(POSTER_PATH_PREFIX) && posterPath.endsWith(POSTER_PATH_SUFFIX)) {
            return true;
        }
        return false;
    }

    public String convertMovieObjectToJSONString(String name, String description) throws BaseException {
        String json = "";
        try {
            PostMovieModel movie = new PostMovieModel();
            movie.setDescription(EMPTY_STRING);
            movie.setName(EMPTY_STRING);
            json = new ObjectMapper().writeValueAsString(movie);
        }catch (JsonProcessingException ex ){
            LOGGER.error("Error converting movie object to json string", ex);
            throw new BaseException("Error converting movie object to json string", ex);
        }
        return json;
    }

    public ResponseEntity<String> postMovie(String json, HttpHeaders headers) throws BaseException{
        restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> response = restTemplate.exchange(MOVIE_API_URL, HttpMethod.POST, httpEntity, String.class);
        return response;
    }

    public boolean checkForResultsInReponse(String responseString) throws BaseException {
        boolean containsResult = false;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Movies movies = objectMapper.readValue(responseString, Movies.class);
            Movies.Results[] results = movies.getResults();
            containsResult = true;
        }catch (IOException ex){
            LOGGER.error("Error parsing response string", ex);
            throw new BaseException("Error parsing response string", ex);
        }
            return containsResult;
    }

    public AddMovieResponse parseAddMovieResponse(String jsonString) throws BaseException {
        AddMovieResponse addMovieResponse = null;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            addMovieResponse = objectMapper.readValue(jsonString, AddMovieResponse.class);
        }catch (IOException ex){
            LOGGER.error("Error parsing response string", ex);
            throw new BaseException("Error parsing response string", ex);
        }
            return addMovieResponse;
    }
}
