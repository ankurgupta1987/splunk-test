package com.splunk.exercise.util;

import com.splunk.exercise.model.Movies;

import java.util.Comparator;

public class MovieIdComparator implements Comparator<Movies.Results> {


    @Override
    public int compare(Movies.Results o1, Movies.Results o2) {
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
