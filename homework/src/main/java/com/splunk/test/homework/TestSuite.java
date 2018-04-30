package com.splunk.test.homework;

import com.splunk.test.homework.behavior.Behavior1;
import com.splunk.test.homework.behavior.Behavior2;

public class TestSuite {
    public void run(){
        new Behavior1().check();
        new Behavior2().check();
    }
}
