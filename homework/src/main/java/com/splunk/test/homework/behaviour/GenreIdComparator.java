package com.splunk.test.homework.behaviour;

import com.splunk.test.homework.model.Movie;

import java.util.Comparator;

public class GenreIdComparator implements Comparator<Movie.Results> {

    @Override
    public int compare(Movie.Results o1, Movie.Results o2) {
        return compareTo(o1, o2);
    }

    public int compareTo(Movie.Results o1, Movie.Results o2){
        Integer[] generId1 = o1.getGenreIds();
        Integer[] generId2 = o2.getGenreIds();

        if(generId1 == null && generId2 != null){
           return -1;
        }else if(generId1 != null && generId2 == null){
            return 1;
        }
        return 0;
    }
}
