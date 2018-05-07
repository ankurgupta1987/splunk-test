package com.splunk.test.homework.behaviour;

import com.splunk.test.homework.util.Utility;
import org.springframework.http.ResponseEntity;

public class MovieCountBehaviour {

    private String url;
    private ResponseEntity<String> response;

    public void sendOnlyCount(){
        url = Utility.prepareUrl(null,"2");
        response = Utility.invokeRestAPI(url, true);

    }
}
