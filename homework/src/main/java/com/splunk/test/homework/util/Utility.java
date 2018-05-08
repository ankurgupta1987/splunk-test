package com.splunk.test.homework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splunk.test.homework.behaviour.GenreIdComparator;
import com.splunk.test.homework.behaviour.MovieIdComparator;
import com.splunk.test.homework.behaviour.MovieTitleLengthComparator;
import com.splunk.test.homework.model.Movie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

/**
 * @author Ankur
 * Class for utilty methods
 */
public class Utility {

    public static final String MOVIE_API_URL = "https://splunk.mocklab.io/movies";
    public static final String QUESTION_MARK = "?";
    public static final String AMPERSAND = "&";
    public static final String Q_PARAM = "q=";
    public static final String COUNT_PARAM = "count=";
    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String EMPTY_STRING = "";
    public static final String POSTER_PATH_PREFIX = "https://www.dropbox.com/s";
    public static final String POSTER_PATH_SUFFIX = "jpg?dl=0";

    private RestTemplate restTemplate;
    private ResponseEntity<String> response;

    public static String prepareUrl(String q, String count) {
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

    public ResponseEntity<String> invokeRestAPI(String url, boolean isGet){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

    public int getResponseStatusCode(ResponseEntity<?> response){
        if(response != null){
            return response.getStatusCodeValue();
        }
        return -1;
    }

    public Object getResponseBody(ResponseEntity<?> response){
        if(response != null){
            return response.getBody();
        }
        return null;
    }

    public HttpHeaders getResponseHeader(ResponseEntity<?> response){
        if(response != null){
            return response.getHeaders();
        }
        return null;
    }

    public int checkMovieCount(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);
            Movie.Results[] results = movie.getResults();
            if(results != null){
                return results.length;
            }
        }catch (IOException ioEx){
            System.out.println(ioEx.getMessage());
        }
        return 0;
    }
    //1
    public boolean checkForTheDuplicateMovieImage(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);
            Movie.Results[] results = movie.getResults();
            return checkDuplicateImageUtil(results);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    //2
    public boolean checkIfPosterPathIsValid(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);
            Movie.Results[] results = movie.getResults();
            return arePosterPathsValid(results);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    //3
    public boolean isMovieOrderCorrect(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);

            List<Movie.Results> resultListReturned = Arrays.asList(movie.getResults());
            List<Movie.Results> resultListExpected = new ArrayList<>(resultListReturned);
            Collections.sort(resultListExpected, new MovieIdComparator());
            Collections.sort(resultListExpected, new GenreIdComparator());

            return validateIfMovieOrderIsSame(resultListReturned, resultListExpected);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    //4
    public boolean checkIfGenreIdSumGreaterThan400(String jsonString){
        int movieCountWithGenreIdSumGreater = 0;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);
            Movie.Results[] results = movie.getResults();


            if(results != null){
                for(Movie.Results result : results){
                    Integer[] genreIdArr = result.getGenreIds();
                    if(genreIdArr != null){
                        int sum = 0;

                        for(Integer genreId : genreIdArr){
                            sum += genreId;
                        }
                        if(sum > 400){
                            movieCountWithGenreIdSumGreater++;
                            if(movieCountWithGenreIdSumGreater > 7)return false;
                        }
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return movieCountWithGenreIdSumGreater > 7 ? false : true;
    }

    //5
    public boolean ifMovieTitlesContainsPalindrome(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);
            Movie.Results[] results = movie.getResults();
            if(results != null) {
                for (Movie.Results result : results){
                    if(titleHasPalindrome(result.getTitle())){
                        return true;
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    //6
    public boolean checkIfTitleContainsAnotherTitle(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(jsonString, Movie.class);
            Movie.Results[] results = movie.getResults();
            return titleContainsAnotherTitleUtil(results);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean titleContainsAnotherTitleUtil(Movie.Results[] results){
        if(results == null || results.length == 0){
            return false;
        }
        List<Movie.Results> movieList = Arrays.asList(results);
        Collections.sort(movieList, new MovieTitleLengthComparator());
        int count = 0;
        for(int i = 0; i< movieList.size() ; i++){
            int ptr  = i + 1;
            String movieTitle = movieList.get(i).getTitle();
            if(movieTitle == null){
                continue;
            }
            while(ptr < movieList.size()){
                if(movieList.get(ptr).getTitle() != null && movieList.get(ptr).getTitle().indexOf(movieTitle) != -1){
                    count++;
                }
                if(count == 2){
                    return true;
                }
            }
        }
        return false;
    }



    public boolean titleHasPalindrome(String title){
       if(title == null || title.isEmpty()){
           return false;
       }

       String[] wordsArr = title.split(" ");
       for(String str : wordsArr ){
            if(isPalindrome(str)){
                return true;
            }
       }
       return false;
    }

    public boolean isPalindrome(String str){
        if(str == null || str.isEmpty()){
            return false;
        }

        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
        }
        return true;
    }

    public boolean validateIfMovieOrderIsSame(List<Movie.Results> resultListReturned, List<Movie.Results> resultListExpected) throws Exception{
        if(resultListReturned == null || resultListExpected == null){
            return false;
        }

        for(int i = 0; i < resultListReturned.size() ; i++){
            Movie.Results result1 =  resultListReturned.get(i);
            Movie.Results result2 =  resultListExpected.get(i);
            if(result1.getId() != result2.getId()
                    || (result1.getGenreIds() != null && result2.getGenreIds() == null)
                    || (result1.getGenreIds() == null && result2.getGenreIds() != null)
                || (result1.getGenreIds() != result2.getGenreIds())) return false;
        }
        return true;
    }

    public boolean checkDuplicateImageUtil(Movie.Results[] results){
        if(results != null) {
            Set<String> uniqueImages = new HashSet<>(results.length);
            for(Movie.Results result : results){
                if(result.getPosterPath() != null &&
                        !uniqueImages.add(extractMovieImageName(result.getPosterPath()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String extractMovieImageName(String posterPath){
        if(posterPath == null || posterPath.isEmpty()){
            return EMPTY_STRING;
        }
        if(posterPath.contains("?")){
            posterPath = posterPath.substring(0, posterPath.lastIndexOf("?"));
        }
        StringBuilder movieImageName = new StringBuilder();
        for(int i = posterPath.length()-1 ; i>0 ; i--){
            if(posterPath.charAt(i) == '/'){
                break;
            }else {
                movieImageName.append(posterPath.charAt(i));
            }
        }
        return movieImageName.reverse().toString();
    }

    public  boolean arePosterPathsValid(Movie.Results[] results){
        if(results != null) {
            Set<String> uniqueImages = new HashSet<>(results.length);
            for(Movie.Results result : results){
                if(!validatePosterPath(result.getPosterPath())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validatePosterPath(String posterPath){
        if(posterPath == null || posterPath.isEmpty()){
            return true;
        }

        if(posterPath.startsWith(POSTER_PATH_PREFIX) && posterPath.endsWith(POSTER_PATH_SUFFIX)){
            return true;
        }
        return false;
    }

}
