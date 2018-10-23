package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    RestTemplate restTemplate;

//    빈으로 등록되어 있다.
//    @Autowired
    public SampleServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String getName() {
        return restTemplate.getForObject("/foo", String.class);
    }

    public int getNumber() {
        return 100;
    }
}
