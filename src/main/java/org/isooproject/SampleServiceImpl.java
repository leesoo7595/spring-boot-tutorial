package org.isooproject;

public class SampleServiceImpl implements SampleService {

    public String getName() {
        return "Remote Service";
    }

    public int getNumber() {
        return 100;
    }
}
