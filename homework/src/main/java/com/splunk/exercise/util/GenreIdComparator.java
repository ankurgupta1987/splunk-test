package com.splunk.exercise.util;

import com.splunk.exercise.model.Movies;

import java.util.Comparator;

public class GenreIdComparator implements Comparator<Movies.Results> {

    @Override
    public int compare(Movies.Results o1, Movies.Results o2) {
        return compareTo(o1, o2);
    }

    public int compareTo(Movies.Results o1, Movies.Results o2){
        Integer[] genreId1 = o1.getGenreIds();
        Integer[] genreId2 = o2.getGenreIds();

        if(genreId1 == null && genreId2 != null){
           return -1;
        }else if(genreId1 != null && genreId2 == null){
            return 1;
        }
        return 0;
    }
}
