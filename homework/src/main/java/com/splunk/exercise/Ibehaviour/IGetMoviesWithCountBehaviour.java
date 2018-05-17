package com.splunk.exercise.Ibehaviour;

import com.splunk.exercise.model.ResponseUtil;

public interface IGetMoviesWithCountBehaviour {
    ResponseUtil sendNegativeCount();

    ResponseUtil sendHighCountValue();

    ResponseUtil sendFloatingPointCount();

    ResponseUtil sendCountAsWord();

    ResponseUtil sqlInjectionWithCount();

    ResponseUtil emptyCount();
}
