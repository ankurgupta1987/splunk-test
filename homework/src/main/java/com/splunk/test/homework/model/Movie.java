package com.splunk.test.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Ankur
 * Class used as a model for getting the movies from Movie API
 */
public class Movie {

    public Movie() {
    }

    @JsonProperty("vote_count")
    private long voteCount;

    private long id;

    @JsonProperty("video")
    private boolean isVideo;

    @JsonProperty("vote_average")
    private long voteAvg;

    private String title;

    private BigDecimal popularity;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("genre_ids")
    private Integer[] genreIds;

    @JsonProperty("adult")
    private boolean isAdult;

    private String overview;


    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public long getVoteAvg() {
        return voteAvg;
    }

    public void setVoteAvg(long voteAvg) {
        this.voteAvg = voteAvg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public void setPopularity(BigDecimal popularity) {
        this.popularity = popularity;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Integer[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(Integer[] genreIds) {
        this.genreIds = genreIds;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
