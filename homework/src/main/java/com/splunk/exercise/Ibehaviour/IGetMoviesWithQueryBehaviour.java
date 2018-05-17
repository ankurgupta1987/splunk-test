package com.splunk.exercise.Ibehaviour;

import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;

import java.io.IOException;

public interface IGetMoviesWithQueryBehaviour {
    ResponseUtil sendOnlyCount() throws BaseException;

    ResponseUtil sendQMalformed() throws BaseException;

    ResponseUtil querySQLInjection() throws BaseException;

    ResponseUtil sendQWildcard() throws BaseException;

    ResponseUtil useDiffVerb() throws BaseException;

    ResponseUtil queryForLimitingCount() throws IOException, BaseException;

    ResponseUtil queryEmptyString() throws IOException, BaseException;
}
