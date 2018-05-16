package com.splunk.exercise.util;

import com.splunk.exercise.model.Movies;

import java.util.Comparator;

public class MovieTitleLengthComparator implements Comparator<Movies.Results> {
    @Override
    public int compare(Movies.Results o1, Movies.Results o2) {
        String movieTitle1 = o1.getTitle();
        String movieTitle2 = o2.getTitle();

        if(movieTitle1.length() < movieTitle2.length()){
            return -1;
        }
        else if(movieTitle1.length() > movieTitle2.length()){
            return 1;
        }
        return 0;
    }
}
