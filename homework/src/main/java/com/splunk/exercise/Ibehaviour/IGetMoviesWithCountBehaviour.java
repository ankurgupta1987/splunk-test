package com.splunk.exercise.Ibehaviour;

public interface IGetMoviesWithCountBehaviour {
    void sendNegativeCount();

    void sendHighCountValue();

    void sendFloatingPointCount();

    void sendCountAsWord();

    void sqlInjectionWithCount();
}
