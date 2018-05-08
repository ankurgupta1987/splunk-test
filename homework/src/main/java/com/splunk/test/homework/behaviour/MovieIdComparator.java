package com.splunk.test.homework.behaviour;

import com.splunk.test.homework.model.Movie;

import java.util.Comparator;

public class MovieIdComparator implements Comparator<Movie.Results> {


    @Override
    public int compare(Movie.Results o1, Movie.Results o2) {
        long id1 = o1.getId();
        long id2 = o2.getId();

        if(id1 > id2){
            return 1;
        }else if(id1 < id2){
            return -1;
        }
        return 0;
    }
}
