package com.splunk.test.homework.behaviour;

import com.splunk.test.homework.util.Utility;
import org.springframework.http.ResponseEntity;

public class MovieCountBehaviour {

    private String url;
    private ResponseEntity<String> response;
    private Utility utility;

    public MovieCountBehaviour(Utility utility){
        this.utility = utility;

    }

    public void sendOnlyCount(){
        url = this.utility.prepareUrl(null,"2");
        response = this.utility.invokeRestAPI(url, true);

    }
}
