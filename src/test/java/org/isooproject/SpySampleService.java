package org.isooproject;

public class SpySampleService implements SampleService {

    @Override
    public String getName() {
        return "Spy";
    }

    @Override
    public int getNumber() {
        return 0;
    }


}