package com.splunk.exercise.Ibehaviour;

import java.io.IOException;

public interface IGetMoviesWithQueryBehaviour {
    void sendOnlyCount();

    void sendQMalformed();

    void querySQLInjection();

    void sendQWildcard();

    void useDiffVerb();

    void queryForLimitingCount() throws IOException;

    void queryEmptyString() throws IOException;
}
