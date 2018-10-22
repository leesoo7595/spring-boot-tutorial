package org.isooproject;

import org.springframework.stereotype.Service;

@Service("SampleService")
public interface SampleService {

    String getName();

    int getNumber();

}
